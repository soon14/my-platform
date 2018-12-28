package com.v.proxy;/**
 * Created by VLoye on 2018/12/18.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author V
 * @Classname ServiceInvokeHandler
 * @Description 服务代理调用执行链
 **/
public class ServiceInvokeHandler<T> implements InvocationHandler{
    private static final Logger logger = LoggerFactory.getLogger(InvocationHandler.class);
    private T target;
//    private Service service;


    public ServiceInvokeHandler(T target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        switch (method.getName()){
            case "execute":
                //// TODO: 2018/12/18  日志/追踪
                Object result = method.invoke(target,args);
                return result;
            default:
                return invoke(target,method,args);
        }

    }
}
