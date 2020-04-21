package spring.learn.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.learn.com.dao.UserDAO;
import spring.learn.com.event.InsertEvent;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/17 14:49
 */
@Service
public class UserServices {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public void insertUser(){
		userDAO.insertUser();
		System.out.println("insert over...");
//		userDAO.insertException();
	}

	@EventListener
	public void listener(InsertEvent event){
		System.out.println("UserServices 监听到了事件："+event);
	}
}
