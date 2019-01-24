package com.dbzq.springboot.controller;

import com.dbzq.springboot.entity.User;
import com.dbzq.springboot.utils.JsonMessage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yuld
 */
@RestController
public class LoginController {

	@PostMapping("/login")
	public JsonMessage login(User user) {
		JsonMessage message = new JsonMessage();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginacct(),user.getUserpswd());
		try {
			//没有异常则登录成功
			subject.login(token);
			message.setSuccess(true);
			message.setInfo("登录成功");
		} catch (UnknownAccountException e) {
			message.setSuccess(false);
			message.setInfo("用户名或密码错误");//没有此用户
			e.printStackTrace();
		}catch (IncorrectCredentialsException e) {
			message.setSuccess(false);
			message.setInfo("用户名或密码错误");//密码错误
			e.printStackTrace();
		}
		return message;
	}

}