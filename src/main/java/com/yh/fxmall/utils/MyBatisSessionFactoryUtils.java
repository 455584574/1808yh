package com.yh.fxmall.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * sessionFactory的封装，做到全局唯一
 */
public class MyBatisSessionFactoryUtils {

    public static SqlSessionFactory sqlSessionFactory;

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    static{
        initSessionFactory();
    }
    private static void initSessionFactory(){
        try {
            InputStream stream = Resources.getResourceAsStream("mybatis.cfg.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory==null){
            initSessionFactory();
        }
        return sqlSessionFactory;
    }

    public static SqlSession getSession(){
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession==null){
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }
}
