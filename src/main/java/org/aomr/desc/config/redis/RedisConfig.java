package org.aomr.desc.config.redis;

import org.aomr.desc.config.redis.listener.RedisMessageListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.tianli.common.config.redis.listener
 * Author:      aomr
 * Date:        2019/2/25 下午4:00
 * Description:
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.database}")
    private int db;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis-cache.database}")
    private int cacheDb;
    @Value("${spring.redis-cache.host}")
    private String cacheHost;
    @Value("${spring.redis-cache.port}")
    private int cachePort;
    @Value("${spring.redis-cache.password}")
    private String cachePassword;
    @Resource
    private RedisMessageListener redisMessageListener;

    @Bean
    public RedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setDatabase(db);
        configuration.setHostName(host);
        configuration.setPort(port);
        configuration.setPassword(RedisPassword.of(password));
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    public RedisConnectionFactory cacheConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setDatabase(cacheDb);
        configuration.setHostName(cacheHost);
        configuration.setPort(cachePort);
        configuration.setPassword(RedisPassword.of(cachePassword));
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

    @Bean
    public RedisTemplate<String, Object> cacheRedisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(cacheConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }


    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(connectionFactory());
        return stringRedisTemplate;
    }


    @Bean
    public RedisMessageListenerContainer container(MessageListenerAdapter messageListenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.addMessageListener(messageListenerAdapter, new PatternTopic("__keyevent@" + db + "__:expired"));
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter() {
        return new MessageListenerAdapter(redisMessageListener);
    }
}
