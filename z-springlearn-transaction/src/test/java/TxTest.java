import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.learn.com.config.TxConfig;
import spring.learn.com.event.InsertEvent;
import spring.learn.com.service.UserServices;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/17 14:58
 */
public class TxTest {

	@Test
	public void test(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
		UserServices userServices = (UserServices) context.getBean("userServices");
		userServices.insertUser();
	}

	@Test
	public void test01(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
		context.publishEvent(new InsertEvent("我的事件..."));
		context.close();
	}
}
