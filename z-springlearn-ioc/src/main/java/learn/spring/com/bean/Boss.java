package learn.spring.com.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/14 16:10
 */
public class Boss implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {

	private int age;

	private Person person;

	private Cat cat;

	public Boss(Person person, Cat cat, Money money) {
		this.person = person;
		this.cat = cat;
		this.age = money.getAmount();
		System.out.println("3参数构造器，贪婪构造..."+money);
	}

	public Boss(Person person, Cat cat) {
		this.person = person;
		this.cat = cat;
		System.out.println("2参数构造器，贪婪构造...");
	}

	public Boss(Person person) {
		this.person = person;
		person.setName("我被构造器改掉了");
		System.out.println("1参数构造器...");
	}

	public Boss() {
		System.out.println("默认调用无参数构造器");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("********setAge(int age)*************");
		this.age = age;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		System.out.println("********setPerson(Person person)*************");
		this.person = person;
	}

	public void setPersonNew(Person person) {
		System.out.println("********setPersonNew(Person person)*************");
		this.person = person;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		System.out.println("********setCat(Cat cat)*************");
		this.cat = cat;
	}

	public void setCatNew(Cat cat) {
		System.out.println("********setCatNew(Cat cat)*************");
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Boss{" +
				"age=" + age +
				", person=" + person +
				", cat=" + cat +
				'}';
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("**************beanName is :"+name+"**************");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("**************beanFactory is :"+beanFactory+"**************");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(applicationContext);
	}
}
