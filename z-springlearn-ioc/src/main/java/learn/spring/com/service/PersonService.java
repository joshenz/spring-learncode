package learn.spring.com.service;

import learn.spring.com.dao.PersonDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/14 15:17
 */
@Service
public class PersonService implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public PersonDao getPersonDao() {
		return personDao;
	}

	@Autowired
	public PersonService(PersonDao personDao) {
		this.personDao = personDao;
	}

	private PersonDao personDao;

	public void biz(){
		System.out.println(personDao);
		personDao.biz();

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
}
