package com.yh.fxmall.spring;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class SpringBeans {


    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();



    @Bean
    public SqlSessionFactory provideSessionFactory() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis.cfg.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        return sqlSessionFactory;
    }

    @Scope("prototype")
    @Bean
    public SqlSession provideSqlSession(SqlSessionFactory sqlSessionFactory){
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession==null){
             sqlSession = sqlSessionFactory.openSession();
             threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

}
