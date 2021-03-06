package spring.learn.com.proxy;

import spring.learn.com.api.UserLogin;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/4/11 21:44
 */
public class UserLoginTimeProxy implements UserLogin{

	private UserLogin userLogin;

	public UserLoginTimeProxy(UserLogin userLogin){
		this.userLogin = userLogin;
	}

	@Override
	public void login(String name) {
		userLogin.login(name);
		System.out.println(name+"登录时间日志记录成功...");
	}
}
