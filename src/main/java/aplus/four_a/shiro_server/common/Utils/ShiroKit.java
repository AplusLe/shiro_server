package aplus.four_a.shiro_server.common.Utils;

import aplus.four_a.shiro_server.authorize.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @packae aplus.four_a.shiro_server.common.Utils
 * @auther Kevin
 * @date 09/08/2019 15:47
 */

public class ShiroKit {
    /**
     *  获取用户信息
     * @return
     */
    public static UserInfo getUser(){
        Subject subject = SecurityUtils.getSubject();
        UserInfo user = (UserInfo) subject.getPrincipal();
        return user;
    }

    /**
     * 获取随机盐值
     * @param length
     * @return
     */
    public static String getRandomSalt(int length) {
        return ToolUtil.getRandomString(length);
    }
}
