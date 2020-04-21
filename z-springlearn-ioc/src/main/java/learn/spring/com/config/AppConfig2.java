package learn.spring.com.config;

import learn.spring.com.bean.Person;
import learn.spring.com.filter.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/14 15:10
 */
@Configuration
//@ComponentScan(value = "learn.spring.com",includeFilters = {
//		@ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyFilter.class})
//},useDefaultFilters = false)
@ComponentScan("learn.spring.com")
@Import({MyImportBeanDefinitionRegistrar.class})
public class AppConfig2 {

	@Bean
	public Person person(){
		return new Person("张三",22);
	}
}
