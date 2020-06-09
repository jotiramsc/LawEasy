package com.legal;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggerAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.legal.controller.*.*(..)) || execution(* com.legal.service.*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
				+ "(): Start ");
	}

	@After(value = "execution(* com.legal.controller.*.*(..))|| execution(* com.legal.service.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
				+ "(): End ");
	}
}
