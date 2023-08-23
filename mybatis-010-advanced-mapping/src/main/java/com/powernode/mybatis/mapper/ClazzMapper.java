package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Clazz;

public interface ClazzMapper {

    /**
      *第三种方式：两条sql语句，分步查询（这种方式常用：优点一是可复用，优点二是支持延迟加载）
      *分布查询第二步，根据cid获取班级信息
      */
    Clazz selectByIdStep2(Integer cid);











    /**
     *第一种方法：根据班级编号查询班级信息
     */
    Clazz selectByCollection(Integer cid);


    /**
     *第二种方法：分步查询。
     *
     */
    Clazz selectByStep1(Integer cid);
}
