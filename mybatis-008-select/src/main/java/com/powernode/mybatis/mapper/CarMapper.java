package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface CarMapper {

    /**
     *获取car的总记录条数
     */
    Long selectTotal();
    /**
     *启用驼峰命名自动映射
     */
    List<Car> selectAllByMapUnderscoreToCamelCase();

    /**
     * 查询所有的car信息，使用resultMap标签进行结果映射
     */
    List<Car> selectAllByResultMap();



    /**
     *查询所有的car，返回一个大map集合
     * map集合的key是每条记录的主键值
     * map集合的value是每条记录。
     * {
     *    21={car_num=157, id=21, guide_price=50.00, produce_time=2002-10-20, brand=奔驰E300, car_type=燃油车},
     *    23={car_num=798, id=23, guide_price=15.00, produce_time=2023-7-1, brand=比亚迪秦, car_type=新能源},
     *    40={car_num=565, id=40, guide_price=25.00, produce_time=2022-8-16, brand=比亚迪汉, car_type=新能源},
     *    41={car_num=999, id=41, guide_price=30.00, produce_time=2022-10-10, brand=亚洲龙, car_type=燃油车},
     *    10={car_num=857, id=10, guide_price=55.15, produce_time=2022-10-10, brand=奥迪a6L, car_type=燃油车},
     *    30={car_num=421, id=30, guide_price=160.00, produce_time=2021-5-1, brand=奔驰S65, car_type=燃油车},
     *    15={car_num=787, id=15, guide_price=150.00, produce_time=2022-9-15, brand=路虎揽胜, car_type=燃油车}
     * }
     */
    @MapKey("id")//将查询结果的id值作为整个大map集合的key
    Map<Long,Map<String,Object>> selectAllRetMap();


    /**
     *查询所有的car信息，返回一个存放map集合的list集合
     */
    List<Map<String,Object>> selectAllRetListMap();

    Map<String,Object> selectByIdRetMap(Long id);


    List<Car> selectAll();
    Car selectById(Long id);
}
