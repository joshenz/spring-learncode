package learn.spring.com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/15 20:54
 */
@Configuration
@PropertySource("classpath:/dbConfig.properties")
public class AppConfig4 {

	@Value("${db.driverClass}")
	public String driverClass;

	@Bean("devDataSource")
	@Profile("dev")
	public DataSource dataSourceDev(@Value("${db.password}")String pwd) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("${db.user}");
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	@Bean("testDataSource")
	@Profile("test")
	public DataSource dataSourceTest(@Value("${db.password}")String pwd) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("${db.user}");
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	@Bean("prodDataSource")
	@Profile("prod")
	public DataSource dataSourceProd(@Value("${db.password}")String pwd) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("${db.user}");
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/prod");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
}
