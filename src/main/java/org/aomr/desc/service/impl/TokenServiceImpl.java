package org.aomr.desc.service.impl;

import org.aomr.desc.config.redis.RedisUtil;
import org.aomr.desc.exception.ErrorCodeEnum;
import org.aomr.desc.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.tianli.common.service.impl
 * Author:      aomr
 * Date:        2018/11/15 上午11:37
 * Description:
 */
@Service
public class TokenServiceImpl implements TokenService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String prefix = "server_";

    @Resource
    private RedisUtil redisUtil;

    @Override
    public Integer analyzeToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }

        return 1;
    }

    @Override
    public Integer analyzeTokenMust(String token) {
        if (StringUtils.isEmpty(token)) {
            throw ErrorCodeEnum.UNLOIGN.generalException();
        }

        return 1;
    }
}
