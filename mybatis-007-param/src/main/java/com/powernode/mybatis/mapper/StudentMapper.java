package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentMapper {

    /**
     *param注解
     */
    List<Student> selectByNameAndSex2(@Param("name")String name,@Param("sex")Character sex);


    /**
     * 这是多参数
     *根据name和sex查询学生信息
     */
    List<Student> selectByNameAndSex(String name,Character sex);


    /**
     *保存学生信息，通过map参数，以下是单个参数，但是参数的类型不是简单类型，是map集合
     *
     */
    int insertStudentByMap(Map<String,Object> map);

    /**
     *当接口中的方法只有一个（单个参数），并且参数类型都是简单类型
     * 根据id查询，name查询，birth查询，sex查询
     */
    List<Student> selectById(Long id);
    List<Student> selectByName(String name);
    List<Student> selectByBirth(Date birth);
    List<Student> selectBySex(Character sex);

}
