package com.pingan.jinke.infra.padis.storage;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.transaction.CuratorTransactionFinal;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.curator.framework.state.ConnectionStateListener;

import com.pingan.jinke.infra.padis.common.CoordinatorRegistryCenter;
import com.pingan.jinke.infra.padis.common.TransactionExecutionCallback;
import com.pingan.jinke.infra.padis.util.RegExceptionHandler;

public class NodeStorage {

    private final CoordinatorRegistryCenter coordinatorRegistryCenter;
       
    
    public NodeStorage(final CoordinatorRegistryCenter coordinatorRegistryCenter){
    	this.coordinatorRegistryCenter = coordinatorRegistryCenter;
    	
    }
    
    
    
    /**
     * �жϽڵ��Ƿ����.
     * 
     * @param path �ڵ�·��
     * @return �ڵ��Ƿ����
     */
    public boolean isNodePathExisted(final String path) {
        return coordinatorRegistryCenter.isExisted(path);
    }
    
    
    /**
     * ��ȡ�ڵ�����.
     * 
     * @param path �ڵ�·��
     * @return �ڵ�����ֵ
     */
    public String getNodePathData(final String path) {
        return coordinatorRegistryCenter.get(path);
    }
    
    
    /**
     * ֱ�Ӵ�ע�����Ķ��Ǳ��ػ����ȡ�ڵ�����.
     * 
     * @param path �ڵ�·��
     * @return �ڵ�����ֵ
     */
    public String getNodePathDataDirectly(final String path) {
        return coordinatorRegistryCenter.getDirectly(path);
    }
    
    
    /**
     * ��ȡ�ڵ��ӽڵ������б�.
     * 
     * @param path �ڵ�·��
     * @return �ڵ��ӽڵ������б�
     */
    public List<String> getNodePathChildrenKeys(final String path) {
        return coordinatorRegistryCenter.getChildrenKeys(path);
    }
    
    
    /**
     * ��������򴴽��ڵ�.
     * 
     * @param path �ڵ�·��
     */
    public void createNodePathIfNeeded(final String path) {
        if (!isNodePathExisted(path)) {
            coordinatorRegistryCenter.persist(path, "");
        }
    }
    
    /**
     * ɾ���ڵ�.
     * 
     * @param path �ڵ�·��
     */
    public void removeNodeIfExisted(final String path) {
        if (isNodePathExisted(path)) {
            coordinatorRegistryCenter.remove(path);
        }
    }
    
    
    /**
     * �����ʱ�ڵ�����.
     * 
     * @param path �ڵ�·��
     * @param value ��ҵ�ڵ�����ֵ
     */
    public void fillEphemeralNodePath(final String path, final Object value) {
        coordinatorRegistryCenter.persistEphemeral(path, value.toString());
    }
    
    /**
     * ���½ڵ�����.
     * 
     * @param path �ڵ�����
     * @param value �ڵ�����ֵ
     */
    public void updateNodePath(final String path, final Object value) {
        coordinatorRegistryCenter.update(path, value.toString());
    }
    
    
    /**
     * �滻��ҵ�ڵ�����.
     * 
     * @param path �ڵ�·��
     * @param value ���滻������
     */
    public void replaceNodePath(final String path, final Object value) {
        coordinatorRegistryCenter.persist(path, value.toString());
    }

    /**
     * ��������ִ�в���.
     * 
     * @param callback ִ�в����Ļص�
     */
    public void executeInTransaction(final TransactionExecutionCallback callback) {
        try {
            CuratorTransactionFinal curatorTransactionFinal = getClient().inTransaction().check().forPath("/").and();
            callback.execute(curatorTransactionFinal);
            curatorTransactionFinal.commit();
        //CHECKSTYLE:OFF
        } catch (final Exception ex) {
        //CHECKSTYLE:ON
            RegExceptionHandler.handleException(ex);
        }
    }
    
    /**
     * ע������״̬������.
     */
    public void addConnectionStateListener(final ConnectionStateListener listener) {
        getClient().getConnectionStateListenable().addListener(listener);
    }
    
    private CuratorFramework getClient() {
        return (CuratorFramework) coordinatorRegistryCenter.getRawClient();
    }
    
    /**
     * ע�����ݼ�����.
     */
    public void addDataListener(final TreeCacheListener listener,String path) {
        TreeCache cache = (TreeCache) coordinatorRegistryCenter.getRawCache(path);
        cache.getListenable().addListener(listener);
    }
    
    /**
     * ��ȡע�����ĵ�ǰʱ��.
     * 
     * @return ע�����ĵ�ǰʱ��
     */
    public long getRegistryCenterTime() {
        return coordinatorRegistryCenter.getRegistryCenterTime("/padis/systemTime/current");
    }
}
