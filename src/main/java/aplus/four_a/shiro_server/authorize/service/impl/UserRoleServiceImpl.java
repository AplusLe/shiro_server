package aplus.four_a.shiro_server.authorize.service.impl;

import aplus.four_a.shiro_server.authorize.entity.UserPermission;
import aplus.four_a.shiro_server.authorize.entity.UserRole;
import aplus.four_a.shiro_server.authorize.mapper.UserRoleMapper;
import aplus.four_a.shiro_server.authorize.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kevin
 * @since 2019-08-07
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Override
    public List<String> getPermission(UserRole role) {
        return this.baseMapper.getPermission(role.getId());
    }
}
