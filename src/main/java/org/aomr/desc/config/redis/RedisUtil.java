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

@SuppressWarnings("unchecked")
@Component
public class RedisUtil {
    private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    @SuppressWarnings("rawtypes")
    @Resource
    private RedisTemplate redisTemplate;

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
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        Object result = null;
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        if (result == null) {
            return null;
        }
        return result.toString();
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
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
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
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
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
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, timeUnit);
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
            redisTemplate.opsForHash().putAll(key, value);
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
            result = redisTemplate.opsForHash().entries(key);
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
                redisTemplate.opsForSet().add(key, value);
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
            result = redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            logger.error("redis读取set失败,{}", e);
        }
        return result;
    }



}
