package com.powernode.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtil {
    //工具类的构造方法一般都是私有化的
    //工具类中所有的方法都是静态的，直接采用类名即可调用，不需要new对象
    //为了防止new对象，构造方法私有化
    private SqlSessionUtil(){}

      private static SqlSessionFactory sqlSessionFactory;

    //类加载时执行
    //工具类在第一次进行加载时，解析mybatis-config.xml文件，创建SqlSessionFactory对象
    static{
        try {
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    /*public static SqlSession openSession(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //一个SqlSessionFactory对象对应一个environment,一个environment通常是一个数据库
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
    */
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }

}
