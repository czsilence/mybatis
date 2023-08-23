package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {
    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(null,"8654","凯美瑞",20.0,"2002-06-08","新能源");
        mapper.insert(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        mapper.deleteById(19L);
        sqlSession.commit();
        sqlSession.close();
    } @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
       Car car=new Car(1L,"222","凯美瑞",20.0,"2002-06-08","新能源");
       mapper.update(car);
       sqlSession.commit();
       sqlSession.close();
    } @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(5L);
        System.out.println(car);
        sqlSession.commit();
         sqlSession.close();

    } @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        //Lambda
        /*cars.forEach(car -> {
            System.out.println(car);
        });*/
        for(Car car:cars){
            System.out.println(car);
        }


    }

}
