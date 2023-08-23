package com.powernode.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {
    @Test
    public void testSelectByPage(){

        //获取每页显示的记录条数
        int pageSize=3;
        //显示第几页，页码
        int pageNum=1;
        //计算开始下标
        int startIndex=(pageNum-1)*pageSize;
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars=mapper.selectByPage(startIndex,pageSize);
        cars.forEach(car ->
            System.out.println(car));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //一定要注意：在执行DQL语句之前，开启分页功能
        int pageNum=1;
        int pageSize=3;
        PageHelper.startPage(pageNum,pageSize);
       List<Car> cars= mapper.selectAll();
       //cars.forEach(car -> {System.out.println(car);});


        //封装分页信息对象new PageInfo()
        //PageInfo对象是PageHelper插件提供的，用来封装分页相关的信息的对象
        PageInfo<Car> carPageInfo = new PageInfo<>(cars, 3);
        System.out.println(carPageInfo);
        sqlSession.commit();
        sqlSession.close();

        /*
        *PageInfo{pageNum=1, pageSize=3, size=3, startRow=1, endRow=3, total=4, pages=2,
        * list=Page{count=true, pageNum=1, pageSize=3, startRow=0, endRow=3, total=4, pages=2, reasonable=false, pageSizeZero=false}
        * [Car{id=21, carNum='157', brand='奔驰E300', guidePrice=50.0, produceTime='2002-10-20', carType='燃油车'},
        * Car{id=30, carNum='421', brand='奔驰S65', guidePrice=160.0, produceTime='2021-5-1', carType='燃油车'},
        * Car{id=41, carNum='999', brand='亚洲龙', guidePrice=30.0, produceTime='2022-10-10', carType='燃油车'}],
        * prePage=0, nextPage=2, isFirstPage=true, isLastPage=false, hasPreviousPage=false, hasNextPage=true,
        * navigatePages=3, navigateFirstPage=1, navigateLastPage=2, navigatepageNums=[1, 2]}
        */
    }
}
