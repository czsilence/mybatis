package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarMapperTest {
    @Test
    public void testSelectByMultiCondition() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //假设三个条件都不是空
      /* List<Car> cars= mapper.selectByMultiCondition("比亚迪",10.00,"新能源");
       cars.forEach(car -> {
           System.out.println(car);
       });
       */


        //假设三个条件都是空
       /* List<Car> cars= mapper.selectByMultiCondition("",null,"");
        cars.forEach(car -> {
            System.out.println(car);
        });*/

        //假设后两个条件不为空，第一个条件为空
        /*List<Car> cars= mapper.selectByMultiCondition("",10.00,"新能源");
        cars.forEach(car -> {
            System.out.println(car);
        });*/


        //假设第一个条件不是空，后两个条件是空
        List<Car> cars = mapper.selectByMultiCondition("比亚迪", null, "");
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.commit();
        sqlSession.close();
    }




    @Test
    public void testSelectByMultiConditionWithWhere(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        //三个条件都不是空
       //List<Car> cars= mapper.selectByMultiConditionWithWhere("比亚迪",10.00,"新能源");

        //三个条件都是空
        //List<Car> cars= mapper.selectByMultiConditionWithWhere("",null,"");

        //假设后两个条件不为空，第一个条件为空
        //List<Car> cars= mapper.selectByMultiConditionWithWhere("",10.00,"新能源");


        //假设第一个条件不是空，后两个条件是空
        List<Car> cars= mapper.selectByMultiConditionWithWhere("比亚迪",null,"");
        cars.forEach(car -> {System.out.println(car);}
        );
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void testSelectByMultiConditionWithTrim(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars= mapper.selectByMultiConditionWithTrim("比亚迪",null,"");
        cars.forEach(car -> {System.out.println(car);}
        );
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(10L,null,"丰田卡罗拉",null,null,"电车");
        mapper.updateById(car);
                sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testUpdateBySet(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(10L,null,"丰田卡罗拉",null,null,"电车");
        mapper.updateBySet(car);
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void testSelectByChoose(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        //三个条件都给
       //List<Car> cars= mapper.selectByChoose("丰田卡罗拉",5.00,"电车");
       //第一个条件是空
        //List<Car> cars= mapper.selectByChoose("",5.00,"电车");
        //前两个都是空
        List<Car> cars= mapper.selectByChoose(null,null,"电车");
        cars.forEach(car -> {System.out.println(car);});
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testDeleteByIds(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[]ids ={10L,23L,40L};
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testInsertBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car1=new Car(null,"152","帕萨特",20.00,"2022-7-10","燃油车");
        Car car2=new Car(null,"171","宝来",12.00,"2020-7-10","燃油车");
        Car car3=new Car(null,"520","途观",25.00,"2021-7-10","燃油车");
        List<Car> cars=new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        mapper.insertBatch(cars);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testDeleteByIds2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[]ids={42L,44L};
        mapper.deleteByIds2(ids);
        sqlSession.commit();
        sqlSession.close();
    }
}
