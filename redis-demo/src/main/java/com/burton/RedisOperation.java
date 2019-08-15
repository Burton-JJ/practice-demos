package com.burton;

import redis.clients.jedis.JedisCluster;

/*********************************
 * <p> 文件名称: RedisOperationCluster
 * <p> 系统名称：交易银行系统V1.0
 * <p> 模块名称：com.burton
 * <p> 功能说明:
 * <p> 开发人员：jiangjun25372
 * <p> 开发时间：2019/8/3
 * <p> 修改记录：程序版本   修改日期    修改人员   修改单号   修改说明
 **********************************/
public interface RedisOperation {

    JedisCluster connect(String ip);

    void put(String key, String value);

    void put(String group, String key, String value);
}
