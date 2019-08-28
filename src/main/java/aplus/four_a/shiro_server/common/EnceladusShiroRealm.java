package aplus.four_a.shiro_server.common;

import aplus.four_a.shiro_server.authorize.entity.UserInfo;
import aplus.four_a.shiro_server.authorize.entity.UserRole;
import aplus.four_a.shiro_server.authorize.service.IUserInfoService;
import aplus.four_a.shiro_server.authorize.service.IUserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @packae aplus.four_a.shiro_server.common
 * @auther Kevin
 * @date 07/08/2019 14:29
 */

public class EnceladusShiroRealm extends AuthorizingRealm {

    @Autowired
    IUserInfoService userService;

    @Autowired
    IUserRoleService userRoleService;

    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String) principalCollection.getPrimaryPrincipal();
        UserInfo user = userService.getOne(new QueryWrapper<UserInfo>().eq("user_name", username));
        List<UserRole> roles = userService.getRoles(user.getId());
        roles.stream().forEach(role -> {
            authorizationInfo.addRole(role.getRole());
            List<String> permissions = userRoleService.getPermission(role);
            authorizationInfo.addStringPermissions(permissions);
        });
        return authorizationInfo;
    }

    /**
     * 获取用户身份验证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();
        UserInfo user = userService.getOne(new QueryWrapper<UserInfo>().eq("user_name", username));
        if (user == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()), getName());
        return authenticationInfo;
    }
}
