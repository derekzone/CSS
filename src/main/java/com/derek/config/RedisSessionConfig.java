package com.derek.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author Derek
 * @date 2018/3/28 11:07
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
