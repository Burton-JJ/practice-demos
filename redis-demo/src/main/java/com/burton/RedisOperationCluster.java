package com.burton;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/*********************************
 * <p> 模块名称：com.burton
 * <p> 功能说明: 
 * <p> 开发人员：jiangjun
 **********************************/
public class RedisOperationCluster implements RedisOperation{
    //操作单机redis
    private  static Jedis jedis;
    //操作集群redis
    private  static JedisCluster jedisCluster;

    @Override
    public JedisCluster connect(String ip) {
        Set<HostAndPort> nodes = new HashSet<>();
        String[] hostAndPorts = ip.split(",");
        for (String hostAndPort : hostAndPorts) {
            if (hostAndPort != "" && hostAndPort != null) {
                String[] split = hostAndPort.split(":");
                String host = split[0];
                String post = split[1];
                HostAndPort node = new HostAndPort(host, Integer.valueOf(post));
                nodes.add(node);
            }
        }
        jedisCluster = new JedisCluster(nodes);
        return jedisCluster;
    }

    @Override
    public void put(String key, String value) {

    }

    @Override
    public void put(String group, String key, String value) {

    }
}
