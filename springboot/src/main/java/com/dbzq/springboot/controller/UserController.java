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
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.stereotype.Controller;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuld
 * @since 2019-01-24
 */
@RestController
@Api(value="UserController",tags={"用户相关接口"})
public class UserController {

	@Autowired
	private UserService service;

	@ApiOperation(value="根据条件查询用户信息", notes="分页查询满足条件的用户信息")
	@GetMapping("/user/")
	public JsonMessage findUserByCondition(@RequestParam(value = "current", defaultValue = "1") Integer current,
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


	@ApiOperation(value="根据id查看用户", notes="根据id查看用户")
	@GetMapping("/user/{id}")
	public JsonMessage findUserById(@PathVariable("id") Integer id){
		JsonMessage message = new JsonMessage();
		try {
			User user = service.selectById(id);
			message.setSuccess(true);
			message.setData(user);
		} catch (Exception e) {
			message.setSuccess(false);
			e.printStackTrace();
		}
		return message;
	}

	@ApiOperation(value="根据id删除用户", notes="根据id删除用户")
	@DeleteMapping("/user/{id}")
	public JsonMessage deleteUserById(@PathVariable("id") Integer id){
		JsonMessage message = new JsonMessage();
		try {
			service.deleteById(id);
			message.setSuccess(true);
		} catch (Exception e) {
			message.setSuccess(false);
			e.printStackTrace();
		}
		return message;
	}

	@ApiOperation(value="新增用户", notes="loginacct和userpswd不能为空,email要满足邮箱格式")
	@PostMapping("/user/")
	public JsonMessage addUser(User user){
		JsonMessage message = new JsonMessage();
		try {
			service.insert(user);
			message.setSuccess(true);
			message.setData(user);
		} catch (Exception e) {
			message.setSuccess(false);
			e.printStackTrace();
		}
		return message;
	}

	@ApiOperation(value="更新用户", notes="更新用户信息")
	@PutMapping("/user/")
	public JsonMessage updateUser(User user){
		JsonMessage message = new JsonMessage();
		try {
			Wrapper<User> wrapper = getWrapper(user);
			service.update(user,wrapper);
			message.setSuccess(true);
			message.setData(user);
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

