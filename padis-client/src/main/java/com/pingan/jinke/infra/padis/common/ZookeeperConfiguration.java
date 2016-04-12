package com.pingan.jinke.infra.padis.common;

import com.google.common.base.Strings;

/**
 * ����Zookeeper��ע����������.
 * 
 * @author feiyongjun
 */


public class ZookeeperConfiguration {

	
    /**
     * ����Zookeeper���������б�.
     * ����IP��ַ�Ͷ˿ں�.
     * �����ַ�ö��ŷָ�.
     * ��: host1:2181,host2:2181
     */
    private String serverLists;
    
    /**
     * �����ռ�.
     */
    private String namespace;
    
    /**
     * �ȴ����Եļ��ʱ��ĳ�ʼֵ.
     * ��λ����.
     */
    private int baseSleepTimeMilliseconds;
    
    /**
     * �ȴ����Եļ��ʱ������ֵ.
     * ��λ����.
     */
    private int maxSleepTimeMilliseconds;
    
    /**
     * ������Դ���.
     */
    private int maxRetries;
    
    /**
     * �Ự��ʱʱ��.
     * ��λ����.
     */
    private int sessionTimeoutMilliseconds;
    
    /**
     * ���ӳ�ʱʱ��.
     * ��λ����.
     */
    private int connectionTimeoutMilliseconds;
    
    /**
     * ����Zookeeper��Ȩ������.
     * ȱʡΪ����ҪȨ����֤.
     */
    private String digest;
    
    /**
     * ��ǶZookeeper�Ķ˿ں�.
     * -1��ʾ��������ǶZookeeper.
     */
    private int nestedPort = -1;
    
    /**
     * ��ǶZookeeper�����ݴ洢·��.
     * Ϊ�ձ�ʾ��������ǶZookeeper.
     */
    private String nestedDataDir;
    
    /**
     * �����˱������ԵĹ�����.
     * 
     * @param serverLists ����Zookeeper���������б�
     * @param namespace �����ռ�
     * @param baseSleepTimeMilliseconds �ȴ����Եļ��ʱ��ĳ�ʼֵ
     * @param maxSleepTimeMilliseconds �ȴ����Եļ��ʱ������ֵ
     * @param maxRetries ������Դ���
     */
    public ZookeeperConfiguration(final String serverLists, final String namespace, final int baseSleepTimeMilliseconds, final int maxSleepTimeMilliseconds, final int maxRetries) {
        this.serverLists = serverLists;
        this.namespace = namespace;
        this.baseSleepTimeMilliseconds = baseSleepTimeMilliseconds;
        this.maxSleepTimeMilliseconds = maxSleepTimeMilliseconds;
        this.maxRetries = maxRetries;
    }
    
    
    /**
     * �ж��Ƿ���Ҫ������ǶZookeeper.
     * 
     * @return �Ƿ���Ҫ������ǶZookeeper
     */
    public boolean isUseNestedZookeeper() {
        return -1 != nestedPort && !Strings.isNullOrEmpty(nestedDataDir);
    }
    

	public String getServerLists() {
		return serverLists;
	}

	public void setServerLists(String serverLists) {
		this.serverLists = serverLists;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public int getBaseSleepTimeMilliseconds() {
		return baseSleepTimeMilliseconds;
	}

	public void setBaseSleepTimeMilliseconds(int baseSleepTimeMilliseconds) {
		this.baseSleepTimeMilliseconds = baseSleepTimeMilliseconds;
	}

	public int getMaxSleepTimeMilliseconds() {
		return maxSleepTimeMilliseconds;
	}

	public void setMaxSleepTimeMilliseconds(int maxSleepTimeMilliseconds) {
		this.maxSleepTimeMilliseconds = maxSleepTimeMilliseconds;
	}

	public int getMaxRetries() {
		return maxRetries;
	}

	public void setMaxRetries(int maxRetries) {
		this.maxRetries = maxRetries;
	}

	public int getSessionTimeoutMilliseconds() {
		return sessionTimeoutMilliseconds;
	}

	public void setSessionTimeoutMilliseconds(int sessionTimeoutMilliseconds) {
		this.sessionTimeoutMilliseconds = sessionTimeoutMilliseconds;
	}

	public int getConnectionTimeoutMilliseconds() {
		return connectionTimeoutMilliseconds;
	}

	public void setConnectionTimeoutMilliseconds(int connectionTimeoutMilliseconds) {
		this.connectionTimeoutMilliseconds = connectionTimeoutMilliseconds;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public int getNestedPort() {
		return nestedPort;
	}

	public void setNestedPort(int nestedPort) {
		this.nestedPort = nestedPort;
	}

	public String getNestedDataDir() {
		return nestedDataDir;
	}

	public void setNestedDataDir(String nestedDataDir) {
		this.nestedDataDir = nestedDataDir;
	}
}
