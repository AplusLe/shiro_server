package aplus.four_a.shiro_server.authorize.mapper;

import aplus.four_a.shiro_server.authorize.entity.UserPermission;
import aplus.four_a.shiro_server.authorize.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kevin
 * @since 2019-08-07
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<String> getPermission(Integer id);
}
