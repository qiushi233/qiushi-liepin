package com.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by qiushi on 16/5/9.
 */
public class MyInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) {
        Object result = null;
        StringBuffer info = new StringBuffer();
        info.append("intercept the method: ");
        info.append(invocation.getMethod().getDeclaringClass().
                getName());
        info.append(".");
        info.append(invocation.getMethod().getName());
        System.out.println("start " + info.toString());
        try {
            result = invocation.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("end " + info.toString());
        }
        return result;
    }
}
