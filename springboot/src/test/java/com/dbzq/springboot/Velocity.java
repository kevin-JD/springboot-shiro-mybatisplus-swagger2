package com.dbzq.springboot;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author yuld
 */
public class Velocity {

	@Test
	public void  testGenerator() {
		//1. 全局配置
		GlobalConfig config = new GlobalConfig();
		config.setActiveRecord(false) // 是否支持AR模式
				.setAuthor("yuld") // 作者
				.setOutputDir("F:\\码云个人项目\\ssm-shiro\\src\\main\\java") // 生成路径,指定到当前项目
				.setFileOverride(true)  // 文件覆盖
				//.setIdType(IdType.AUTO) // 主键策略
				.setServiceName("%sService")  // %s 会自动填充表实体属性
				.setEnableCache(false)// XML 二级缓存
				.setBaseResultMap(true)//生成.xml基本查询resultMap文件
				.setBaseColumnList(true);//生成xml通用查询列

		//2. 数据源配置
		DataSourceConfig dsConfig  = new DataSourceConfig();
		dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
				.setDriverName("com.mysql.cj.jdbc.Driver")
				.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8")
				.setUsername("root")
				.setPassword("root");

		//3. 策略配置
		StrategyConfig stConfig = new StrategyConfig();
		stConfig.setCapitalMode(true) //全局大写命名
				.setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
				.setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
				.setTablePrefix("t_")//表前缀
				.setInclude("t_user");  // 对哪些表生成数据
		//,,,,
		//4. 包名策略配置
		PackageConfig pkConfig = new PackageConfig();
		pkConfig.setParent("com.dbzq.springboot")
				.setMapper("mapper")
				.setService("service")
				.setController("controller")
				.setEntity("entity")
				.setXml("mapper");

		//5. 整合配置
		AutoGenerator ag = new AutoGenerator();

		ag.setGlobalConfig(config)
				.setDataSource(dsConfig)
				.setStrategy(stConfig)
				.setPackageInfo(pkConfig);

		//6. 执行
		ag.execute();
	}


}