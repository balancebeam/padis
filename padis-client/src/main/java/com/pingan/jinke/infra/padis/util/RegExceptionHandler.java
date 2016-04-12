package com.pingan.jinke.infra.padis.util;

import org.apache.zookeeper.KeeperException.ConnectionLossException;
import org.apache.zookeeper.KeeperException.NoNodeException;
import org.apache.zookeeper.KeeperException.NodeExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RegExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(RegExceptionHandler.class);
    
    /**
     * ������жϺ�����ʧЧ�쳣�������׳�RuntimeException.
     * 
     * @param cause ��������쳣.
     */
    public static void handleException(final Exception cause) {
        if (isIgnoredException(cause) || isIgnoredException(cause.getCause())) {
            log.debug("padis: ignored exception for: {}", cause.getMessage());
        } else if (cause instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        } else {
            throw new RuntimeException(cause);
        }
    }
    
    private static boolean isIgnoredException(final Throwable cause) {
        return null != cause && (cause instanceof ConnectionLossException || cause instanceof NoNodeException || cause instanceof NodeExistsException);
    }
}
