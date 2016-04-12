package com.pingan.jinke.infra.padis.util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.curator.test.TestingServer;

/**
 * ��Ƕ��Zookeeper������.
 * 
 * <p>
 * ���Ը��ݲ�ͬ�Ķ˿ں��������Zookeeper����.
 * ��ÿ����ͬ�Ķ˿ںŹ���һ������ʵ��.
 * </p>
 * 
 * @author feiyongjun
 */

public final class NestedZookeeperServers {
    
    private static NestedZookeeperServers instance = new NestedZookeeperServers();
    
    private static ConcurrentMap<Integer, TestingServer> nestedServers = new ConcurrentHashMap<Integer, TestingServer>();
    
    private NestedZookeeperServers(){
    	
    }
    
    /**
     * ��ȡ����ʵ��.
     * 
     * @return ����ʵ��
     */
    public static NestedZookeeperServers getInstance() {
        return instance;
    }
    
    /**
     * ������Ƕ��Zookeeper����.
     * 
     * @param port �˿ں�
     * 
     * <p>
     * ����ö˿ںŵ�Zookeeper����δ����, ����������.
     * ����ö˿ںŵ�Zookeeper����������, �����κβ���.
     * </p>
     */
    public synchronized void startServerIfNotStarted(final int port, final String dataDir) {
        if (!nestedServers.containsKey(port)) {
            TestingServer testingServer = null;
            try {
                testingServer = new TestingServer(port, new File(dataDir));
            // CHECKSTYLE:OFF
            } catch (final Exception ex) {
            // CHECKSTYLE:ON
                RegExceptionHandler.handleException(ex);
            }
            nestedServers.putIfAbsent(port, testingServer);
        }
    }
    
    /**
     * �ر���Ƕ��Zookeeper����.
     * 
     * @param port �˿ں�
     */
    public void closeServer(final int port) {
        TestingServer nestedServer = nestedServers.get(port);
        if (null == nestedServer) {
            return;
        }
        try {
            nestedServer.close();
            nestedServers.remove(port);
        } catch (final IOException ex) {
            RegExceptionHandler.handleException(ex);
        }
    }
}
