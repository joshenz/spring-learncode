package learn.spring.com.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/14 16:23
 */
@Component
public class MyFactoryBean implements FactoryBean<Person> {

	@Override
	public Person getObject() throws Exception {
		return new Person("factoryBean",30);
	}

	@Override
	public Class<?> getObjectType() {
		return Person.class;
	}
}
