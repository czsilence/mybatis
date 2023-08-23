package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.StudentMapper;
import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapperTest {

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
       List<Student> students=mapper.selectById(1L);
       students.forEach(student -> {
           System.out.println(student);
       });
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectByName(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students=mapper.selectByName("李四");
        students.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectByBirth() throws ParseException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date =sdf.parse("2001-07-01");
        List<Student> students=mapper.selectByBirth(date);
        students.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectBySex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Character sex = Character.valueOf('男');
        List<Student> students=mapper.selectBySex(sex);
        students.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testInsertStudentByMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("姓名","赵六");
        map.put("年龄",25);
        map.put("身高",1.60);
        map.put("生日",new Date());
        map.put("性别",'女');
        mapper.insertStudentByMap(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByNameAndSex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students=mapper.selectByNameAndSex("张三",'男');
        students.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByNameAndSex2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students=mapper.selectByNameAndSex2("张三",'男');
        students.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.commit();
        sqlSession.close();
    }
}
