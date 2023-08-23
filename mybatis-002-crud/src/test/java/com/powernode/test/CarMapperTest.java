package com.powernode.test;

import com.powernode.utils.SqlSessionUtil;
import com.powernode.utils.pojo.Car;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMapperTest {

    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();


        //这个对象我们先使用map集合进行数据的封装
        Map<String,Object> map=new HashMap<>();
        map.put("carNum","1111");
        map.put("brand","比亚迪汉2");
        map.put("guidePrice",10.0);
        map.put("produceTime","2023-7-10");
        map.put("carType","电车");


        //第一个参数：sqlId，从CarMapper.xml文件中复制
        //第二个参数：封装数据的对象
        sqlSession.insert("insertCar",map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarByPojo(){
        SqlSession sqlSession=SqlSessionUtil.openSession();
        //封装数据
        Car car=new Car(null,"2222","奥迪a6",50.0,"2022-6-30","燃油车");
        sqlSession.insert("insertCar",car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeletById(){
        SqlSession sqlSession=SqlSessionUtil.openSession();
        sqlSession.delete("deleteById",10);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession=SqlSessionUtil.openSession();
        //准备数据
        Car car=new Car(4L,"9999","亚洲龙",30.0,"2001-11-16","燃油车");
        sqlSession.update("updateById",car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession=SqlSessionUtil.openSession();
        //mybatis底层执行了select语句之后，一定会返回一个结果集对象：ResultSet
        //JDBC中叫ResultSet，接下来就是mybatis应该从ResultSet中取出数据，封装Java对象
        Object car = sqlSession.selectOne("selectById", 1);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession=SqlSessionUtil.openSession();
        List<Object> cars = sqlSession.selectList("selectAll");
        //遍历
        //lambda表达式
        cars.forEach(car->System.out.println(car));
        /*for(Object car:cars){
            System.out.println(car);
        }*/
        sqlSession.commit();
        sqlSession.close();
    }
}
