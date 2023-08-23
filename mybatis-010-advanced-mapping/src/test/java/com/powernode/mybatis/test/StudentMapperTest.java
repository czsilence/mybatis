package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.StudentMapper;
import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentMapperTest {
    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
      Student student=  mapper.selectById(1);
        System.out.println(student);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByIdAssociation(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student=  mapper.selectByIdAssociation(1);
        System.out.println(student);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectByIdStep1(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student=  mapper.selectByIdStep1(5);
        //System.out.println(student);

        //只看学生的名字
        System.out.println(student.getSname());

        //程序执行到这里。查看班级的名字
        System.out.println(student.getClazz().getCname());
        sqlSession.commit();
        sqlSession.close();
    }
}
