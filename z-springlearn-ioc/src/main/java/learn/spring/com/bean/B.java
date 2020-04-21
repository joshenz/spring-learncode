package learn.spring.com.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/4/7 21:50
 */
@Component
public class B {

	@Autowired
	private A a;

}
