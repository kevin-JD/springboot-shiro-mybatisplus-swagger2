package com.dbzq.springboot.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dbzq.springboot.entity.User;
import com.dbzq.springboot.service.UserService;
import com.dbzq.springboot.utils.JsonMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuld
 * @since 2019-01-24
 */
@RestController
@RequestMapping("/user")
@Api(value="UserController",tags={"用户相关接口"})
public class UserController {

	@Autowired
	private UserService service;

	@ApiOperation(value="查询用户信息", notes="分页查询满足条件的用户信息")
	@GetMapping("/getAll")
	public JsonMessage getAll(@RequestParam(value = "current", defaultValue = "1") Integer current,
							  @RequestParam(value = "size", defaultValue = "5") Integer size,
							  User user){
		JsonMessage message = new JsonMessage();
		try {
			Wrapper<User> wrapper = getWrapper(user);
			//current:当前页,size:每页显示条数
			Page<User> page = service.selectPage(new Page<>(current, size),wrapper);
			message.setSuccess(true);
			message.setData(page);
		} catch (Exception e) {
			message.setSuccess(false);
			e.printStackTrace();
		}
		return message;
	}


	/**
	 * 条件构造器
	 * @param user
	 * @return
	 */
	private Wrapper<User> getWrapper(User user){
		Wrapper<User> wrapper = new EntityWrapper<User>();

		if(!StringUtils.isEmpty(user)){
			if(!StringUtils.isEmpty(user.getLoginacct())){
				wrapper.like("loginacct",user.getLoginacct());
			}
			if(!StringUtils.isEmpty(user.getEmail())){
				wrapper.like("email",user.getEmail());
			}
		}
		return wrapper;
	}
}

