package com.powernode.bank.service;

import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.exceptions.TransferException;

/**
 * 注意：业务类当中的业务方法的名字在起名字的时候，最好见名知意，能够体现出具体的业务是做什么的
 * 账户业务类
 */
public interface AccountService {
    /**
     *账户转账业务
     * fromActno 转出账号
     * toActno 转入账号
     * money 转账金额
     */
    void transfer(String fromActno,String toActno,double money) throws MoneyNotEnoughException, TransferException;
}
