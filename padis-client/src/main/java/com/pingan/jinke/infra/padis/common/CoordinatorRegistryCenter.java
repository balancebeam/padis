package com.pingan.jinke.infra.padis.common;

import java.util.List;

/**
 * ����Э���ֲ�ʽ�����ע������.
 * 
 * @author feiyongjun
 */
public interface CoordinatorRegistryCenter extends RegistryCenter {
    
    /**
     * ֱ�Ӵ�ע�����Ķ��Ǳ��ػ����ȡ����.
     * 
     * @param key ��
     * @return ֵ
     */
    String getDirectly(String key);
    
    /**
     * ��ȡ�ӽڵ����Ƽ���.
     * 
     * @param key ��
     * @return �ӽڵ����Ƽ���
     */
    List<String> getChildrenKeys(String key);
    
    /**
     * �־û���ʱע������.
     * 
     * @param key ��
     * @param value ֵ
     */
    void persistEphemeral(String key, String value);
    
    /**
     * �־û���ʱ˳��ע������.
     * 
     * @param key ��
     */
    String persistEphemeralSequential(String key);
    
    /**
     * ��ӱ��ػ���.
     * 
     * @param cachePath ����뻺���·��
     */
    void addCacheData(String cachePath);
    
    /**
     * ��ȡע���������ݻ������.
     * 
     * @param cachePath ����Ľڵ�·��
     * @return ע���������ݻ������
     */
    Object getRawCache(String cachePath);
}