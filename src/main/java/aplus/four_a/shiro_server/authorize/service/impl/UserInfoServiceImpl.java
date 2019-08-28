package aplus.four_a.shiro_server.authorize.service.impl;

import aplus.four_a.shiro_server.authorize.entity.UserInfo;
import aplus.four_a.shiro_server.authorize.entity.UserRole;
import aplus.four_a.shiro_server.authorize.mapper.UserInfoMapper;
import aplus.four_a.shiro_server.authorize.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kevin
 * @since 2019-08-06
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Override
    public List<UserRole> getRoles(Integer id) {
        this.baseMapper.getRoles(id);
        return null;
    }
}
