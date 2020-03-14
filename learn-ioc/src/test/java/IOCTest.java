import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import spring.learn.ioc.bean.Person;
import spring.learn.ioc.config.AppConfig;
import spring.learn.ioc.config.AppConfig2;

import java.util.Iterator;
import java.util.Map;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/12 23:51
 */
public class IOCTest {

	@Test
	public void test(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		Person p = context.getBean(Person.class);
		System.out.println(p.getName());
		System.out.println(context.getBean("person"));
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println("中文是乱码吗？"+beanDefinitionName);
		}
	}

	@Test
	public void test02(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig2.class);
		Person p = context.getBean(Person.class);
		System.out.println(p.getName());
		Person p2 = (Person)context.getBean("person");
		System.out.println(p==p2);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
		ConfigurableEnvironment environment = context.getEnvironment();
		Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
		Iterator<String> iterator = systemEnvironment.keySet().iterator();
		while (iterator.hasNext()) {
			String key =  iterator.next();
			System.out.println("key:"+key+".....value:"+systemEnvironment.get(key));
		}
		System.out.println("****************************************print system properties......");
		Map<String, Object> systemProperties = environment.getSystemProperties();
		iterator = systemProperties.keySet().iterator();
		while (iterator.hasNext()) {
			String key =  iterator.next();
			System.out.println("key:"+key+".....value:"+systemProperties.get(key));
		}
		context.close();
	}
}
