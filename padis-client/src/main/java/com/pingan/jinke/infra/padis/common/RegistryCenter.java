package com.pingan.jinke.infra.padis.common;
/**
 * ע������.
 * 
 * @author feiyongjun
 */
public interface RegistryCenter {
    
    /**
     * ��ʼ��ע������.
     */
    void init();
    
    /**
     * �ر�ע������.
     */
    void close();
    
    /**
     * ��ȡע������.
     * 
     * @param key ��
     * @return ֵ
     */
    String get(String key);
    
    /**
     * ��ȡ�����Ƿ����.
     * 
     * @param key ��
     * @return �����Ƿ����
     */
    boolean isExisted(String key);
    
    /**
     * �־û�ע������.
     * 
     * @param key ��
     * @param value ֵ
     */
    void persist(String key, String value);
    
    /**
     * ����ע������.
     * 
     * @param key ��
     * @param value ֵ
     */
    void update(String key, String value);
    
    /**
     * ɾ��ע������.
     * 
     * @param key ��
     */
    void remove(String key);
    
    /**
     * ��ȡע�����ĵ�ǰʱ��.
     * 
     * @param key ���ڻ�ȡʱ��ļ�
     * @return ע�����ĵ�ǰʱ��
     */
    long getRegistryCenterTime(String key);
    
    /**
     * ֱ�ӻ�ȡ����ע�����ĵ�ԭ���ͻ���.
     * �磺Zookeeper��Redis��ԭ���ͻ���.
     * 
     * @return ע�����ĵ�ԭ���ͻ���
     */
    Object getRawClient();
}