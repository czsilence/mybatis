package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    /**
     * 批量删除第二种方法,使用or
     */
    int deleteByIds2(@Param("ids")Long[] ids);
    /**
     *批量插入
     */
    int insertBatch(@Param("cars")List<Car> cars);

    /**
     *批量删除，foreach
     */
    int deleteByIds(Long[] ids);

    /**
     *使用choose when otherwise标签
     */
    List<Car> selectByChoose(@Param("brand")String brand,@Param("guidePrice")Double guidePrice,@Param("carType")String carType);

    /**
     *  Car car=new Car(10L,null,"丰田卡罗拉",null,null,"电车");
     *只更改局部字段，其他字段不更改，不会返回空
     */
    int updateBySet(Car car);


    int updateById(Car car);

    /**
     *使用trim标签
     */
    List<Car> selectByMultiConditionWithTrim(@Param("brand")String brand,@Param("guidePrice")Double guidePrice,@Param("carType")String carType);


    /**
     *使用where标签，让where子句更加智能
     */
    List<Car> selectByMultiConditionWithWhere(@Param("brand")String brand,@Param("guidePrice")Double guidePrice,@Param("carType")String carType);

    /**
     *多条件查询
     */
    List<Car> selectByMultiCondition(@Param("brand")String brand,@Param("guidePrice")Double guidePrice,@Param("carType")String carType);
}
