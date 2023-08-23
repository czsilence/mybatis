package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class CarMapperTest {
    //什么时候不走缓存？
    //SqlSession对象不是同一个，不走缓存
    //查询条件不一样，不走缓存


    //什么时候缓存失效？
    //第一次DQL和第二次DQL之间做了以下任意一件，都会让一级缓存清空：
    //1：执行了sqlSession的clearCache()方法，这是手动清空缓存
    //2.执行了INSERT或DELETE或UPDATE语句，不管操作哪张表，都会清空一级缓存
    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

       Car car= mapper.selectById(15L);
        System.out.println(car);

        //手动清空一级缓存
        sqlSession.clearCache();

        Car car2= mapper.selectById(15L);
        System.out.println(car2);

       sqlSession.commit();
       sqlSession.close();

    }


    @Test
    public void testSelectById2() throws  Exception{
        //这里只有一个sqlSessionFactory对象，二级缓存对应的就是sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);

        //这行代码执行结束之后，实际上数据是缓存到一级缓存当中的。（sqlSession是一级缓存）
        Car car1=mapper1.selectById2(15L);
        System.out.println(car1);

        //如果这里不关闭SqlSession1对象的话，二级缓存中还是没有数据
        sqlSession1.close();

        //这行代码结束之后，实际上数据会缓存到一级缓存当中（SqlSession2是一级缓存）
        Car car2=mapper2.selectById2(15L);
        System.out.println(car2);

        //程序执行到这里会将sqlSession1一级缓存中的数据写入到二级缓存中
        //sqlSession1.close();
        //程序执行到这里会将sqlSession2一级缓存中的数据写入到二级缓存中
        sqlSession2.close();
    }
}
