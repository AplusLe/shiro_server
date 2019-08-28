package aplus.four_a.shiro_server.authorize.service;

import aplus.four_a.shiro_server.authorize.entity.UserPermission;
import aplus.four_a.shiro_server.authorize.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kevin
 * @since 2019-08-07
 */
public interface IUserRoleService extends IService<UserRole> {

    List<String> getPermission(UserRole role);
}
