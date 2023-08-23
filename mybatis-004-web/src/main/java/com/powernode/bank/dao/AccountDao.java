package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

/**
 *账户的DAO对象，负责t_act表中的crud
 * DAO中的方法就是做CRUD的，所以方法名大部分是：insertXXX deleteXXX updateXXX selectXXX
 */
public interface AccountDao {
    /**
     * 根据账号查询账户信息
     */
    Account selectByActno(String actno);

    /**
     * 更新账户
     * 1表示成功，其他值表示失败
     */
    int updateByActno(Account act);

}
