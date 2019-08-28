package aplus.four_a.shiro_server.authorize.service.impl;

import aplus.four_a.shiro_server.authorize.entity.UserPermission;
import aplus.four_a.shiro_server.authorize.mapper.UserPermissionMapper;
import aplus.four_a.shiro_server.authorize.service.IUserPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kevin
 * @since 2019-08-06
 */
@Service
public class UserPermissionServiceImpl extends ServiceImpl<UserPermissionMapper, UserPermission> implements IUserPermissionService {

}
