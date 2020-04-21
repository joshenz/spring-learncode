package learn.spring.com.dao;

import org.springframework.stereotype.Repository;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/14 15:18
 */
@Repository
public class PersonDao {

	public void biz(){
		System.out.println("执行dao层的业务方法...");
	}
}
