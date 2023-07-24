package com.zhou.zhouboot.config.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * @author zhougq
 **/
@Component
@Intercepts({
@Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
})
public class AllUpdate implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("拦截器触发更新方法");
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        String sql = boundSql.getSql();
        System.out.println("拦截器触发更新方法sql"+sql);
        System.out.println("拦截器触发更新方法参数"+parameter);
        System.out.println("拦截器触发更新方法参数"+mappedStatement);
        Object proceed = invocation.proceed();

        System.out.println("拦截器触发更新方法结束");
        return proceed;
    }
}
