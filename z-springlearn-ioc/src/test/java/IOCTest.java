import learn.spring.com.bean.Boss;
import learn.spring.com.config.*;
import learn.spring.com.dao.PersonDao;
import learn.spring.com.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/14 15:13
 */
public class IOCTest {
	@Test
	public void test(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		String[] names = context.getBeanDefinitionNames();
		System.out.println("print all bean in ioc...");
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			System.out.println(name);
		}
		System.out.println("print which bean you want...");
//		System.out.println(context.getBean("person"));
//		PersonService service = context.getBean(PersonService.class);
//		System.out.println("Ioc personService is:"+service);
//		System.out.println(service.getPersonDao()==context.getBean(PersonDao.class));
//		service.biz();
		System.out.println("myFactoryBean is:"+context.getBean("myFactoryBean"));
		System.out.println("myBeanFactory is:"+context.getBean("&myFactoryBean"));
		System.out.println("Boss bean by type is:"+context.getBean(Boss.class));
		System.out.println("Boss bean by name is:"+context.getBean("boss"));
		System.out.println("Person is:"+context.getBean("person"));
	}

	@Test
	public void test2(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-learn.xml");
		System.out.println(context.getBean("person3"));
	}

	@Test
	/**
	 * ClassPathXmlApplicationContext 获取 配置文件的过程
	 */
	public void test3(){
		//读取配置文件
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-learn.xml");

		//获取注册器
//		SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		//获取注册器及工厂
		DefaultListableBeanFactory registry = new DefaultListableBeanFactory();

		//通过注册器拿到reader读取xml文件
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);

		//加载XML文件
		reader.loadBeanDefinitions("spring-learn.xml");

		System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));

		System.out.println(registry.getBeanDefinition("person"));

		System.out.println(registry.getBean("person"));
	}

	@Test
	public void test4(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
		PersonService service = context.getBean(PersonService.class);
		System.out.println("personDao in personService is:"+service.getPersonDao());
		System.out.println("personDao in ioc is:"+context.getBean(PersonDao.class));
		service.biz();
	}

	@Test
	public void test5(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig3.class);
		//拿到工厂
		DefaultListableBeanFactory factory = context.getDefaultListableBeanFactory();
		//创建BeenDefinition
		RootBeanDefinition beanDefinition = new RootBeanDefinition(Boss.class);
//		beanDefinition.setAutowireMode(3);
		//注册been
		factory.registerBeanDefinition("boss",beanDefinition);
		//填充属性
		beanDefinition.getPropertyValues().add("age",66);


		System.out.println(context.getBean("boss"));
	}

	@Test
	public void test6(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig3.class);
		String[] names = context.getBeanDefinitionNames();
		System.out.println("print all bean in ioc...");
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			System.out.println(name);
		}
		System.out.println(context.getBean("boss"));
	}

	@Test
	public void test7(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev","test");
		context.register(AppConfig4.class);
		context.refresh();
		String[] names = context.getBeanDefinitionNames();
		System.out.println("print all bean in ioc...");
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			System.out.println(name);
		}
//		System.out.println("devDataSource is:"+context.getBean("devDataSource"));
//		System.out.println("testDataSource is:"+context.getBean("testDataSource"));
//		System.out.println("prodDataSource is:"+context.getBean("prodDataSource"));
	}

	@Test
	public void test8(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig5.class);
		String[] names = context.getBeanDefinitionNames();
		System.out.println("print all bean in ioc...");
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			System.out.println(name);
		}
	}

}
