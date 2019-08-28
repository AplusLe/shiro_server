package aplus.four_a.shiro_server.authorize.mapper;

import aplus.four_a.shiro_server.authorize.entity.UserInfo;
import aplus.four_a.shiro_server.authorize.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kevin
 * @since 2019-08-06
 */
@Component
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    List<UserRole> getRoles(Integer id);
}
