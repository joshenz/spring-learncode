package spring.learn.com.service;

import spring.learn.com.api.UserLogin;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/4/11 21:21
 */
public class UserLoginImpl implements UserLogin {

	public void login(String name){
		System.out.println(name+"欢迎回来...");
	}

}
