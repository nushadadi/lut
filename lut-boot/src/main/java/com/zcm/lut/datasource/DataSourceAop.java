package com.zcm.lut.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author ZCM
 * @package com.zcm.lut.datasource
 * @class DataSourceAop
 * @date 2019/08/04
 **/

@Component
@Aspect
public class DataSourceAop {
    private final String POINT_CUT = "execution(* com.zcm.lut.service.*Service.*(..))";

    @Pointcut(POINT_CUT)
    public void pointCut(){}

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if(method.getName().startsWith("add")
                || method.getName().startsWith("create")
                || method.getName().startsWith("save")
                || method.getName().startsWith("edit")
                || method.getName().startsWith("update")
                || method.getName().startsWith("delete")
                || method.getName().startsWith("remove")){
            System.out.println("切换到: master");
            DataSourceSwitcher.setMaster();
        }
        else  {
            System.out.println("切换到: slave");
            DataSourceSwitcher.setSlave();
        }
    }

}
