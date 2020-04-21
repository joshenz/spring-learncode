package spring.learn.com.event;

import org.springframework.context.ApplicationEvent;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/17 22:03
 */
public class InsertEvent extends ApplicationEvent {

	private static final long serialVersionUID = 7099057708183571937L;

	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public InsertEvent(Object source) {
		super(source);
	}
}
