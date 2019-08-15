package com.burton;

import redis.clients.jedis.Jedis;

/**
 * @author Burton
 * @title: HashDemo
 * @projectName practice-demos
 * @description: TODO
 * @date 2019/7/2512:58
 */
public class HashDemo {
    /**
     * jedis.hset会覆盖之前的
     */
    private static Jedis jedis;
    static {
        jedis = new Jedis("127.0.0.1", 6379);
        //jedis.auth("123456"); // 之前我在redis配置中配置了权限密码，这里需要设置
    }
    public static void main(String[] args) {
        jedis.hset("burton","name","jiangjun");
        jedis.hset("burton","name","jiangjun2");
        jedis.hset("burton","age","jiangjun2");
        jedis.expire("burton",2);
        //jedis.hdel("burton","name");
    }
}
