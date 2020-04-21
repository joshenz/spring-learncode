package learn.spring.com.config;

import learn.spring.com.bean.Cat;
import learn.spring.com.bean.Money;
import learn.spring.com.bean.Person;
import learn.spring.com.filter.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.*;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/14 15:10
 */
@Configuration
@ComponentScan("learn.spring.com")
@Import(MyImportBeanDefinitionRegistrar.class)
public class AppConfig3 {

	@Bean
	@Primary
	public Person person(){
		return new Person("张三",18);
	}

	@Bean
	public Cat cat(){
		return new Cat("red");
	}

	@Bean
	public Money money(){
		return new Money();
	}
}
