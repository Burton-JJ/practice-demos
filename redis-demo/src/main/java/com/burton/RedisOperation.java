package com.burton;

import redis.clients.jedis.JedisCluster;

/*********************************
 * <p> 文件名称: RedisOperationCluster
 * <p> 模块名称：com.burton
 * <p> 功能说明:
 * <p> 开发人员：jiangjun
 **********************************/
public interface RedisOperation {

    JedisCluster connect(String ip);

    void put(String key, String value);

    void put(String group, String key, String value);
}
