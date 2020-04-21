package spring.learn.com.log;

import spring.learn.com.service.UserLoginImpl;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/4/11 21:29
 */
public class UserLogProxy extends UserLoginImpl {
	@Override
	public void login(String name) {
		super.login(name);
		System.out.println(name+"登录日志记录成功...");
	}
}
