package com.chaos.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ExceptionLogger {

	Logger logger = LoggerFactory.getLogger("ExceptionLogger");

	@Pointcut("execution(public * com.cms.jasmine.*.*(..))")
	public void boExceptionPointcut() {
	}
	
	@Pointcut("execution(public * com.cms.jasmine.*.*(..))")
	public void daoExceptionPointcut() {
	}

	@AfterThrowing(pointcut = "daoExceptionPointcut() || boExceptionPointcut() ", throwing = "ex")
	public void handleException(JoinPoint j, Exception ex) {
		logger.error(String.format("method:%s, param:%s", j.getSignature().getName(), argToString(j.getArgs())),ex);
	}

	public String argToString(Object[] args) {
		if (args != null) {
			StringBuffer arg = new StringBuffer();
			boolean first = true;
			for (Object o : args) {
				if(first){
					arg.append(o);
				}else{
					arg.append(o);
					arg.append(",");
				}
			}
			return arg.toString();
		}
		throw new RuntimeException("asd");
		//return null;
	}
}
