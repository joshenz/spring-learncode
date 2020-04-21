package learn.spring.com.filter;

import learn.spring.com.bean.Boss;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/14 18:16
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Boss.class);
//		rootBeanDefinition.getPropertyValues().add("age",66);
		registry.registerBeanDefinition("boss",rootBeanDefinition);
		/**
		 * 选择构造器
		 * AbstractBeanDefinition.AUTOWIRE_NO 0.默认
		 * AbstractBeanDefinition.AUTOWIRE_BY_NAME 1.byName 基于settor方法
		 * AbstractBeanDefinition.AUTOWIRE_BY_TYPE 2.byType 基于settor方法和Bean类型
		 * AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR 3.基于构造器和Bean类型，参数类型必须是Bean类型，找参数最多的构造器，贪婪模式
		 */
		rootBeanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);
	}
}
