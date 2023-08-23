package com.powernode;

import com.powernode.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class CarMapperTest {

    @Test
    public void testInsertCarByUtil(){
        SqlSession sqlSession= SqlSessionUtil.openSession();
        int count = sqlSession.insert("insertCar");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testInsertCar(){
        SqlSession sqlSession=null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = build.openSession();
            sqlSession.insert("insertCar");
            sqlSession.commit();
        } catch (IOException e) {
            if(sqlSession!=null){
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
