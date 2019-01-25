package com.dbzq.springboot.controller;

import com.dbzq.springboot.entity.User;
import com.dbzq.springboot.utils.JsonMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value="LoginController",tags={"登录相关接口"})
public class LoginController {

	@ApiOperation(value="登录", notes="需要用户名loginacct和密码userpswd")
	@PostMapping("/login")
	public JsonMessage login(User user) {
		JsonMessage message = new JsonMessage();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
		try {
			//没有异常则登录成功
			subject.login(token);
			message.setSuccess(true);
		} catch (UnknownAccountException e) {
			message.setSuccess(false);
			e.printStackTrace();
		}catch (IncorrectCredentialsException e) {
			message.setSuccess(false);
			e.printStackTrace();
		}
		return message;
	}

}