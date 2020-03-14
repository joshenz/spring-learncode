package spring.learn.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import spring.learn.ioc.bean.Person;
import spring.learn.ioc.filter.MyFilter;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/12 23:47
 */
@Configuration
@ComponentScan(value = "spring.learn.ioc",includeFilters = {
//		@Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class}),
		@Filter(type = FilterType.CUSTOM,classes = MyFilter.class)
},useDefaultFilters = false)
public class AppConfig {

	@Bean
	public Person person(){
		return new Person("zhangsan",18);
	}
}
