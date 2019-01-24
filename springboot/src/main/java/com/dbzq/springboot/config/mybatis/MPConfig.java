package com.dbzq.springboot.config.mybatis;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuld
 */
@Configuration
public class MPConfig {

	@Bean
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		//SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长
		performanceInterceptor.setMaxTime(1000);
		//SQL是否格式化 默认false
		performanceInterceptor.setFormat(true);
		return performanceInterceptor;
	}

	/**
	 * 官方在分页插件上如是描述：自定义查询语句分页（自己写sql/mapper），也就是针对自己在Mapper中写的方法，
	 * 但经过测试，如果不配置分页插件，其默认采用的分页为RowBounds的分页即逻辑分页，也就是先把数据记录全部查询出来,
	 * 然在再根据offset和limit截断记录返回（数据量大的时候会造成内存溢出），故而不可取，而通过分页插件的配置即可达到物理分页效果
	 * @return
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		return paginationInterceptor;
	}

}