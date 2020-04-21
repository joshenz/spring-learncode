package spring.learn.com.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import spring.learn.com.event.InsertEvent;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/17 22:04
 */
@Component
public class AyApplicationListener implements ApplicationListener<InsertEvent> {
	@Override
	public void onApplicationEvent(InsertEvent event) {
		System.out.println("监听到事件"+event);
	}
}
