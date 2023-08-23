package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;

public interface CarMapper {
    Car selectById(Long id);



    /**
     *测试二级缓存
     */
    Car selectById2(Long id);
}
