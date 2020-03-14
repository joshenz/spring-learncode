package spring.learn.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import spring.learn.ioc.bean.Person;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/13 11:32
 */
@Configuration
public class AppConfig2 {

	@Bean
	@Scope("singleton")
	public Person person(){
		return new Person("zhangsan",20);
	}
}
