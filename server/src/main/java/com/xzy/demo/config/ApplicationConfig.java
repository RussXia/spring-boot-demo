package com.xzy.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2020-12-31
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        //用fast-json作为redis的序列化工具
        GenericFastJsonRedisSerializer fastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
        //配置redis设置(序列化工具、过期时间)
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer))
                .entryTtl(Duration.ofHours(1));
        return configuration;
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        //1.需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //2:添加fastJson的配置信息;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.BrowserSecure,
                // 消除对同一对象重复引用的优化
                SerializerFeature.DisableCircularReferenceDetect,
                // 将中文都会序列化为\Uxxxx 格式
                // 超过 −9007199254740992 到 9007199254740992 区间使用字符串，如："9007199254740993"
                SerializerFeature.BrowserCompatible,
                // 不隐藏为空的字段
                SerializerFeature.IgnoreNonFieldGetter,
                // map为Null，置为{}
                SerializerFeature.WriteMapNullValue,
                // Long、Integer、Short等number类型为Null，置为0
                SerializerFeature.WriteNullNumberAsZero,
                // Boolean为Null，置为false
                SerializerFeature.WriteNullBooleanAsFalse,
                // List为Null，置为[]
                SerializerFeature.WriteNullListAsEmpty,
                // String为Null，置为""
                SerializerFeature.WriteNullStringAsEmpty
        );
        //3.在convert中添加配置信息.
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters((HttpMessageConverter<?>) fastJsonHttpMessageConverter);
    }

}
