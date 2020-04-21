package spring.learn.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring.learn.com.log.LogAspects;
import spring.learn.com.service.MathCalculator;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/15 16:26
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfig {

	@Bean("mathCal")
	public MathCalculator mathCalculator(){
		return new MathCalculator();
	}

	@Bean
	public LogAspects logAspects(){
		return new LogAspects();
	}
}
