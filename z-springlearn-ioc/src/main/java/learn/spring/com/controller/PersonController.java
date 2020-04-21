package learn.spring.com.controller;

import learn.spring.com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/14 15:18
 */
@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	public void biz(){
		personService.biz();
	}
}
