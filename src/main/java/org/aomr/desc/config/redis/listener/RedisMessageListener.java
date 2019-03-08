package org.aomr.desc.config.redis.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.tianli.common.config.redis.listener
 * Author:      aomr
 * Date:        2019/2/25 下午4:00
 * Description:
 */
@Service
public class RedisMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        String key = message.toString();
        System.out.println(key);
    }
}
