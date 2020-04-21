package spring.learn.com.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/15 16:08
 */
@Aspect
public class LogAspects {

	@Pointcut("execution(public int spring.learn.com.service.MathCalculator.*(..))")
	public void pointCut(){}

	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		System.out.println("method name:【"+joinPoint.getSignature().getName()+"】starting by args:"+ Arrays.asList(args));
	}

	@After("pointCut()")
	public void logEnd(JoinPoint joinPoint){
		System.out.println("method name:【"+joinPoint.getSignature().getName()+"】is to end!");
	}

	@AfterReturning(value = "pointCut()",returning = "result")
	public void logReturn(JoinPoint joinPoint,Object result){
		System.out.println("method name:【"+joinPoint.getSignature().getName()+"】 having return【"+result+"】");
	}

	@AfterThrowing(value = "pointCut()",throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception){
		System.out.println("method name:【"+joinPoint.getSignature().getName()+"】 exception is 【"+exception+"】");
	}
}
