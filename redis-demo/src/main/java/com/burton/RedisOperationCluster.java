package com.burton;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/*********************************
 * <p> 文件名称: RedisOperationCluster
 * <p> 系统名称：交易银行系统V1.0
 * <p> 模块名称：com.burton
 * <p> 功能说明: 
 * <p> 开发人员：jiangjun25372
 * <p> 开发时间：2019/8/3
 * <p> 修改记录：程序版本   修改日期    修改人员   修改单号   修改说明
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
