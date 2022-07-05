package com.upload.file.apps.conf;

import com.luhuiguo.fastdfs.FdfsAutoConfiguration;
import com.luhuiguo.fastdfs.FdfsProperties;
import com.luhuiguo.fastdfs.conn.FdfsConnectionPool;
import com.luhuiguo.fastdfs.conn.PooledConnectionFactory;
import com.luhuiguo.fastdfs.conn.TrackerConnectionManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.Arrays;

/**
 * 自动化配置核心数据库的连接配置
 */
//@Setter
//@Getter
//@Configuration
//@ConfigurationProperties(prefix = "fast.dfs")
//@PropertySource("classpath:fast-dfs.properties")
public class FastDfsConfig extends FdfsAutoConfiguration {
    /**
     * socket超时时间.
     */
    int soTimeout;
    /**
     * 链接超时时间.
     */
    int connectTimeout;
    String trackerServer;

    /**
     * 构造方法.
     *
     * @param properties
     */
    public FastDfsConfig(FdfsProperties properties) {
        super(properties);
    }

    /**
     * PooledConnectionFactory 连接工厂.
     *
     * @return
     */
    @Bean
    public PooledConnectionFactory pooledConnectionFactory() {
        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
     /*   pooledConnectionFactory.setSoTimeout(getSoTimeout());
        pooledConnectionFactory.setConnectTimeout(getConnectTimeout());*/
        return pooledConnectionFactory;
    }

    /**
     * TrackerConnectionManager 管理者.
     *
     * @param fdfsConnectionPool
     * @return
     */
    @Bean
    public TrackerConnectionManager trackerConnectionManager(FdfsConnectionPool fdfsConnectionPool) {
        return new TrackerConnectionManager(fdfsConnectionPool, Arrays.asList(trackerServer));
    }
}
