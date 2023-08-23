package com.powernode.bank.utils;

import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 工具类：可以动态的生成DAO的实现类。（或者说可以动态生成DAO的代理类）
 */
public class GenerateDaoProxy {
    /**
     *生成dao接口实现类，并且将实现类的对象创建出来并返回
     * daoInterface dao接口
     */
    public static Object generate(SqlSession sqlSession,Class daoInterface){
        //类池
        ClassPool pool = ClassPool.getDefault();
        //制造类(com.powernode.bank.dao.AccountDao-->com.powernode.bank.dao.AccountDaoProxy)
        CtClass ctClass = pool.makeClass(daoInterface.getName()+"Proxy");
        //制造接口
        CtClass ctInterface = pool.makeInterface(daoInterface.getName());
        //实现接口
        ctClass.addInterface(ctInterface);
        //实现接口中所有方法
        Method[] methods = daoInterface.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            //method是接口中的抽象方法
            //把method抽象方法给实现了
            try {
                //Account selectByActno(String actno);
                //public Account selectByActno(String actno){}
                StringBuilder methodCode=new StringBuilder();
                methodCode.append("public ");
                methodCode.append(method.getReturnType().getName());
                methodCode.append(" ");
                methodCode.append(method.getName());
                methodCode.append("(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    methodCode.append(parameterType.getName());
                    methodCode.append(" ");
                    methodCode.append("arg"+i);
                   if(i!= parameterTypes.length-1){
                       methodCode.append(",");
                   }
                }
                methodCode.append(")");
                methodCode.append("{");
                methodCode.append("org.apache.ibatis.session.SqlSession sqlSession=com.powernode.bank.utils.SqlSessionUtil.openSession();");
                //需要知道是什么类型的sql语句
                //sql语句的id是框架使用者提供的，具有多变性，对于我框架的开发人员来说，我不知道
                //既然框架开发人员不知道sqlId，mybatis框架的开发者于是就出台了一个规定：凡是使用GenerateDaoProxy机制的
                //sqlId都不能随便写，namespace必须是dao接口的全限定名字，id必须是dao接口中的方法名
               String sqlId= daoInterface.getName()+"."+method.getName();
                SqlCommandType sqlCommandType = sqlSession.getConfiguration().getMappedStatement(sqlId).getSqlCommandType();
                if (sqlCommandType== SqlCommandType.INSERT) {

                }
                if (sqlCommandType== SqlCommandType.DELETE) {

                }
                if (sqlCommandType== SqlCommandType.UPDATE) {
                    methodCode.append("return sqlSession.update(\""+sqlId+"\",arg0);");
                }
                if (sqlCommandType== SqlCommandType.SELECT) {
                    String returnType=method.getReturnType().getName();
                    methodCode.append("return ("+returnType+")sqlSession.selectOne(\""+sqlId+"\",arg0);");
                }

                methodCode.append("}");
                CtMethod  ctMethod = CtMethod.make(methodCode.toString(), ctClass);
                ctClass.addMethod(ctMethod);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //创建对象
        Object obj=null;
        try {
            Class<?> clazz = ctClass.toClass();
             obj = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
