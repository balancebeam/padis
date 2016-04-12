package com.pingan.jinke.infra.padis.common;

import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.curator.framework.state.ConnectionStateListener;

import com.pingan.jinke.infra.padis.core.ClusterManager;
import com.pingan.jinke.infra.padis.storage.NodeStorage;

/**
 * ע�����ĵļ����������ߵĳ�����.
 * 
 * @author feiyongjun
 */
public abstract class AbstractListenerManager {
    
    protected final NodeStorage nodeStorage;
    protected final String instance;
    protected final ClusterManager clusterManager;
    
    protected AbstractListenerManager(final String instance,final CoordinatorRegistryCenter coordinatorRegistryCenter,final ClusterManager clusterManager) {
    	this.nodeStorage = new NodeStorage(coordinatorRegistryCenter);
    	this.instance = instance;
    	this.clusterManager = clusterManager;
    	
    }

    /**
     * ����������.
     */
    public abstract void start();
    
    protected void addDataListener(final TreeCacheListener listener,String path) {
    	nodeStorage.addDataListener(listener,path);
    }
    
    protected void addConnectionStateListener(final ConnectionStateListener listener) {
    	nodeStorage.addConnectionStateListener(listener);
    }
}