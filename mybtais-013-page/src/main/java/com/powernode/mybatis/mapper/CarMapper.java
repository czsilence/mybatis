package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {


  /**
   *查询所以的car，通过分页查询PageHelper完成
   */
    List<Car> selectAll();

    /**
     *分页查询
     */
    List<Car> selectByPage(@Param("startIndex")int startIndex, @Param("pageSize")int pageSize);
}
