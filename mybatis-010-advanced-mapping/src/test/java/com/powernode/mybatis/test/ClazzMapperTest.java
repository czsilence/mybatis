package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.ClazzMapper;
import com.powernode.mybatis.pojo.Clazz;
import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ClazzMapperTest {
    @Test
    public  void testSelectByCollection(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz=mapper.selectByCollection(1000);
        System.out.println(clazz);
        sqlSession.commit();
        sqlSession.close();
    }




    @Test
    public  void testSelectByStep1(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz=mapper.selectByStep1(1000);
        System.out.println(clazz);
        sqlSession.commit();
        sqlSession.close();
    }
}
