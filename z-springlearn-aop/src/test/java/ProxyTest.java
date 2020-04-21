import org.junit.jupiter.api.Test;
import spring.learn.com.api.UserLogin;
import spring.learn.com.log.UserLogProxy;
import spring.learn.com.proxy.UserLoginProxy;
import spring.learn.com.proxy.UserLoginTimeProxy;
import spring.learn.com.service.UserLoginImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/4/11 21:32
 */
public class ProxyTest {

	@Test
	public void test() {
		UserLoginImpl userLogin = new UserLogProxy();
		userLogin.login("Cathy");
	}

	@Test
	public void test1() {
		UserLogin userLogin = new UserLoginImpl();
		UserLogin proxy1 = new UserLoginProxy(userLogin);
		UserLogin proxy2 = new UserLoginTimeProxy(proxy1);
		proxy2.login("Cathy");
	}

	@Test
	public void test2() {
		UserLogin proxy =
			(UserLogin) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] {UserLogin.class}, new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(proxy,args);
					return null;
				}
			});
//		UserLogin proxy1 = new UserLoginProxy(userLogin);
//		UserLogin proxy2 = new UserLoginTimeProxy(proxy1);
		proxy.login("Cathy");
	}
}
