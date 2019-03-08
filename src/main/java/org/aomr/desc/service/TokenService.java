package org.aomr.desc.service;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.tianli.common.service
 * Author:      aomr
 * Date:        2018/11/15 上午11:35
 * Description:
 */
public interface TokenService {


    /**
     * 非强制获取userid(不一定登录 未登录时返回null)
     *
     * @param token token
     * @return userId
     */
    Integer analyzeToken(String token);

    /**
     * 强制解析token(必须登录 否则直接抛出异常)
     *
     * @param token token
     * @return 解析结果
     */
    Integer analyzeTokenMust(String token);

}
