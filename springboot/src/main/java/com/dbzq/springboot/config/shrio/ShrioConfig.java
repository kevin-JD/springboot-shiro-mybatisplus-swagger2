package com.dbzq.springboot.config.shrio;

import com.dbzq.springboot.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yuld
 */
@Configuration
public class ShrioConfig {

	/**
	 * 自定义的realm
	 * @return
	 */
	@Bean
	public UserRealm myShiroRealm() {
		UserRealm userRealm = new UserRealm();
		return userRealm;
	}

	/**
	 * 安全管理器
	 * @return
	 */
	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		return securityManager;
	}

	/**
	 * 过滤链
	 * @param securityManager
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		Map<String,String> map = new LinkedHashMap<>();
		//登出
		map.put("/logout","logout");
		//登录请求不拦截
		map.put("/login","anon");
		//swagger页面不拦截
		map.put("/swagger-ui.html", "anon");
		map.put("/webjars/**", "anon");
		map.put("/v2/**", "anon");
		map.put("/swagger-resources/**", "anon");
		//拦截所有
		map.put("/**","authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		return shiroFilterFactoryBean;
	}
}