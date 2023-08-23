package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {
    @Test
    public void testInsertCarGeneratedKeys(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(null,"999","亚洲龙",30.0,"2022-10-10","燃油车");
        mapper.insertCarGeneratedKeys(car);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByBrandLike(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars=mapper.selectByBrandLike("奔驰");
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count=mapper.deleteBatch("1,2,3");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAllByAscOrDesc(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
       List<Car> cars= mapper.selectAllByAscOrDesc("desc");
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByCarType(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //mapper实际上就是dao实现类对象
        //底层不但为CarMapper接口生成了实现类（字节码），并且还new实现类对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars= mapper.selectByCarType("新能源");
        //遍历
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.commit();
        sqlSession.close();
    }

}
