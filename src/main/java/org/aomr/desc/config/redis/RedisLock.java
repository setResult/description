package org.aomr.desc.config.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.tianli.common.config
 * Author:      aomr
 * Date:        2018/12/29 下午3:29
 * Description:
 */
@Component
public class RedisLock {

    private static final Logger logger = LoggerFactory.getLogger(RedisLock.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 加唯一性控制锁
     *
     * @param key productId - 商品的唯一标志
     * @return
     */
    public boolean lock(String key, String value, Long expireTime) {
        try {
            String uuid = UUID.randomUUID().toString();
            BoundValueOperations<String, String> ops = stringRedisTemplate.boundValueOps(key);
            Boolean absent = ops.setIfAbsent(uuid);
            if (absent != null && absent) {
                ops.expire(expireTime, TimeUnit.SECONDS);
                Map<String, String> map = threadLocal.get();
                if (map == null) {
                    map = new HashMap<>();
                    threadLocal.set(map);
                }
                map.put(key, uuid);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 解锁
     *
     * @param key
     */
    public void unlock(String key) {
        String attribute = null;
        Map<String, String> map = threadLocal.get();
        if (map != null) {
            attribute = map.get(key);
        }
        if (attribute != null && !attribute.isEmpty()) {
            BoundValueOperations<String, String> ops = stringRedisTemplate.boundValueOps(key);
            String value = ops.get();
            if (!StringUtils.isEmpty(value) && value.equals(attribute)) {
                stringRedisTemplate.delete(key);
                map.remove(key);
            }
        }
    }


    public void unlock() {
        Map<String, String> map = threadLocal.get();
        if (map != null) {
            for (String key : map.keySet()) {
                unlock(key);
            }
        }
    }

    private final ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();
}
