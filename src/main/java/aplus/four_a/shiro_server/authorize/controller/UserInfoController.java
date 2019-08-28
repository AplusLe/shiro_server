package aplus.four_a.shiro_server.authorize.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kevin
 * @since 2019-08-06
 */
@RestController
@RequestMapping("/authorize/user-info")
public class UserInfoController {

    @Autowired
    SecurityManager securityManager;

    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password){

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);
        subject.getPrincipal();
        subject.getPreviousPrincipals();
        subject.getPrincipals();
        return "";
    }
}
