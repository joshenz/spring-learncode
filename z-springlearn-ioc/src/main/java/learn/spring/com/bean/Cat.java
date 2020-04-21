package learn.spring.com.bean;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/14 22:18
 */
public class Cat {
	private String color;

	public Cat(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cat{" +
				"color='" + color + '\'' +
				'}';
	}
}
