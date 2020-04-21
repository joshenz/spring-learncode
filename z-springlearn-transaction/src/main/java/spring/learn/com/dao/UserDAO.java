package spring.learn.com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/17 14:49
 */
@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertUser(){
		String sql = "insert into tbl_user(name,age) values(?,?)";
		String name = UUID.randomUUID().toString().substring(0,5);
		jdbcTemplate.update(sql,name,19);
	}

	public void insertException(){
		String sql = "insert into tbl_user(name,age,nickname) values(?,?,?)";
		String name = UUID.randomUUID().toString().substring(0,5);
		jdbcTemplate.update(sql,name,19,111);
	}
}
