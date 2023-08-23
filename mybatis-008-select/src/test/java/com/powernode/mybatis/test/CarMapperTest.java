package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CarMapperTest {
    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=mapper.selectById(15L);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars=mapper.selectAll();
       cars.forEach(car -> {
           System.out.println(car);
       });
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectByIdRetMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String,Object> cars=mapper.selectByIdRetMap(15L);
        System.out.println(cars);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAllRetListMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
      List<Map<String,Object>>  cars=mapper.selectAllRetListMap();
        cars.forEach(map -> {
            System.out.println(map);
        });
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectAllRetMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long,Map<String,Object>> cars=mapper.selectAllRetMap();
        System.out.println(cars);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAllByResultMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
       List<Car> cars=mapper.selectAllByResultMap();
       cars.forEach(car -> {
           System.out.println(car);
       });
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectAllByMapUnderscoreToCamelCase(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars=mapper.selectAllByMapUnderscoreToCamelCase();
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectTotal(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
       Long cars=mapper.selectTotal();
        System.out.println("总记录条数"+cars);
        sqlSession.commit();
        sqlSession.close();
    }
}
