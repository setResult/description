package org.aomr.desc.config.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.tianli.common.config.redis
 * Author:      aomr
 * Date:        2019/1/28 下午5:55
 * Description:
 */
@SuppressWarnings("unchecked")
@Component
public class CacheRedisUtil {

    private static final Logger logger = LoggerFactory.getLogger(CacheRedisUtil.class);

    @Resource
    private RedisTemplate cacheRedisTemplate;

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = cacheRedisTemplate.keys(pattern);
        if (keys.size() > 0)
            cacheRedisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            cacheRedisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return cacheRedisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        Object result = null;
        cacheRedisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<Serializable, Object> operations = cacheRedisTemplate.opsForValue();
        result = operations.get(key);
        if (result == null) {
            return null;
        }
        return result.toString().replaceAll("\"", "");
    }


    /**
     * 读取缓存
     *
     * @param pattern
     * @return
     */
    public Set getLike(final String pattern) {

        return cacheRedisTemplate.keys("*" + pattern + "*");
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = cacheRedisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            logger.error("redis写入失败,{}", e);
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = cacheRedisTemplate.opsForValue();
            operations.set(key, value);
            cacheRedisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            logger.error("redis写入失败,{}", e);
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = cacheRedisTemplate.opsForValue();
            operations.set(key, value);
            cacheRedisTemplate.expire(key, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            logger.error("redis写入失败,{}", e);
        }
        return result;
    }

    /**
     * 写入hash类型缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean setHm(String key, Map<String, String> value) {
        boolean result = false;
        try {
            cacheRedisTemplate.opsForHash().putAll(key, value);
            result = true;
        } catch (Exception e) {
            logger.error("redis写入hash失败,{}", e);
        }
        return result;
    }

    /**
     * 读取hash类型缓存
     *
     * @param key
     * @return
     */
    public Map<String, String> getHm(String key) {
        Map<String, String> result = null;
        try {
            result = cacheRedisTemplate.opsForHash().entries(key);
        } catch (Exception e) {
            logger.error("redis读取hash失败,{}", e);
            return result;
        }
        return result;
    }

    public boolean setHs(String key, Set<String> set) {
        boolean result = false;
        try {
            for (String value : set) {
                cacheRedisTemplate.opsForSet().add(key, value);
            }
            result = true;
        } catch (Exception e) {
            logger.error("redis写入set失败,{}", e);
        }
        return result;
    }

    public Set<String> getHs(String key) {
        Set<String> result = new HashSet<>();
        try {
            result = cacheRedisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            logger.error("redis读取set失败,{}", e);
        }
        return result;
    }
}
