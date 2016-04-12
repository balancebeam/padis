package com.pingan.jinke.infra.padis.common;

import org.apache.curator.framework.api.transaction.CuratorTransactionFinal;

/**
 * ����ִ�в����Ļص��ӿ�.
 * 
 * @author feiyongjun
 */
public interface TransactionExecutionCallback {
    
    /**
     * ����ִ�еĻص�����.
     * 
     * @param curatorTransactionFinal ִ�������������
     * @throws Exception �������쳣
     */
    void execute(CuratorTransactionFinal curatorTransactionFinal) throws Exception;
}