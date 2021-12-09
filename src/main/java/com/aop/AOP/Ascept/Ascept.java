package com.aop.AOP.Ascept;

import com.aop.AOP.Entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class Ascept {

    @Pointcut("execution(* com.aop.AOP.Controller.*.*(..))")
                     //OR
    //@Pointcut("within(com.aop.AOP.Service..*)")

  //  @Pointcut("@annotation(com.aop.AOP.Annotation.CustomAnnotation)") // if we use This pointcut then we enable @CustomAnnotation of the service methods
    public void loggingPointCut(){}
    @Before("loggingPointCut()")
    public void before(JoinPoint joinPoint){
        log.info("Before method invoked :: "+ joinPoint.getSignature());
       // System.out.println("Before method invoked :: "+ joinPoint.getSignature());
    }
    @After("loggingPointCut()")
    public void after(JoinPoint joinPoint){
        log.info("After Method Invoked :: "+ joinPoint.getSignature());
    }

    @AfterReturning(value = "loggingPointCut()",returning = "student")
    public void afterReturning(Student student){
        log.info("After Returning Invoked :: "+ student);
    }
    @AfterThrowing(value = "loggingPointCut()", throwing = "th")
    public void afterThrowing(Exception th){
        log.info("After Throwing :: "+ th.getMessage());
    }

         //If we use to execute around advice then uncomment it
   /* @Around("loggingPointCut()")
    public Object aroundTest(ProceedingJoinPoint joinPoint) throws Throwable  {
        log.info("-----------< AROUND ADVICE >-----------------");
        log.info("Before Around Method Invoked " + joinPoint.getArgs()[0]);
        Object object = joinPoint.proceed();
        // code ---> call Business Method
        if (object instanceof Student) {
            log.info("After Around Method Invoked " + joinPoint.getArgs()[0]);
        }
        else if (object instanceof Student){
            log.info("After Method invoked ::"+joinPoint.getArgs()[0]);
        }
        return object;
    }*/
}
