package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Student;

import java.util.List;

public interface StudentMapper {

    /**
     *第三种方式：两条sql语句，分步查询（这种方式常用：优点一是可复用，优点二是支持延迟加载）
     *
     */
    Student selectByIdStep1(Integer sid);



    /**
     *第二种方式：一条sql语句，association
     */
    Student selectByIdAssociation(Integer id );


    /**
     *第一种方式：根据id获取学生信息，同时获取学生关联的班级信息
     */
        Student selectById(Integer id);






        /**
         * 根据班级编号查学生信息
         */
        List<Student> selectByCidStep2(Integer cid);
}
