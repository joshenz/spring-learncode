package spring.learn.com.servlet;

import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Iterator;
import java.util.Set;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/18 23:10
 */
@HandlesTypes(value = {BeanPostProcessor.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		System.out.println("print onStartup...");
		for (Iterator<Class<?>> iterator = c.iterator(); iterator.hasNext(); ) {
			Class<?> next =  iterator.next();
			System.out.println(next);
		}
	}
}
