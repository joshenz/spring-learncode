import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.learn.com.config.MainConfig;
import spring.learn.com.service.MathCalculator;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/15 16:05
 */
public class AOPTest {

	/**
	 * 1.传入配置类，创建ioc容器
	 * 2.注册配置类，调用refresh()方法
	 * 3.registerBeanPostProcessors(beanFactory); 注册bean的后置处理器，拦截bean的创建
	 * 	  1）先获取ioc容器中已经定义的后置处理器BeanPostProcessors
	 * 	  2）给容器添加其他的BeanPostProcessors
	 * 	  3）优先注册实现了PriorityOrdered的处理器，再来注册实现了Ordered的处理器，最后注册普通处理器
	 * 	  4）创建BeanPostProcessors对象保存在容器中
	 * 	  	 1.创建internalAutoProxyCreator的BeanPostProcessors -->>【AnnotationAwareAspectJAutoProxyCreator】
	 * 	  	 2.创建bean的实例，populateBean给bean的属性赋值
	 * 	  	 3.initializeBean:初始化bean
	 * 	  	     1）invokeAwareMethods() 处理Aware接口的方法调用
	 * 	  	     2）applyBeanPostProcessorBeforeInitialization()应用后置处理器的postProcessBeforeInitialization()
	 * 	  	     3）invokeInitMethods() 执行自定义的初始化方法
	 * 	  	     4）applyBeanPostProcessorAfterInitialization()应用后置处理器的postProcessAfterInitialization()
	 * 	  	 4.BeanPostProcessor【AnnotationAwareAspectJAutoProxyCreator】创建成功 得到aspectJAdvisorsBuilder
	 * 	  5）把BeanPostProcessors注册到BeanFactory中  beanFactory.addBeanPostProcessor(beanPostProcessors)
	 */
	@Test
	public void test01(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		MathCalculator bean = (MathCalculator) context.getBean("mathCal");
		try {
			bean.div(4,2);
		} catch (Exception e) {
		}
		context.close();
	}
}
