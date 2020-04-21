package spring.learn.com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/17 14:38
 */
@ComponentScan("spring.learn.com")
@Configuration
@PropertySource("classpath:/dbConfig.properties")
@EnableTransactionManagement
public class TxConfig {

	@Value("${db.driverClass}")
	public String driverClass;

	@Value("${db.user}")
	public String user;

	@Value("${db.password}")
	public String pwd;

	@Bean
	public PlatformTransactionManager transactionManager() throws PropertyVetoException {
		PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSourceDev());
		return transactionManager;
	}

	@Bean("devDataSource")
	public DataSource dataSourceDev() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev?serverTimezone=UTC&characterEncoding=utf-8");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceDev());
		return jdbcTemplate;
	}

}
