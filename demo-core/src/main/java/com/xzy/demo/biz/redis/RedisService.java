package com.xzy.demo.biz.redis;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by RuzzZZ on 2017/4/20.
 */
public interface RedisService {

    /**
     * 得到json实例通过key
     *
     * @param key
     * @return
     */
    String getString(String key);

    /**
     * 从redis中解析并返回对象，如果获取和解析过程中出现异常，直接抛出
     * add by houenxun 2015.07.17
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getObject(String key, Class<T> clazz);

    /**
     * 从redis中解析并返回对象，如果获取和解析过程中出现异常，忽略并返回null
     * add by houenxun 2015.07.17
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getObjectSilently(String key, Class<T> clazz);

    /**
     * 从redis中解析并返回对象列表，如果获取和解析过程中出现异常，忽略并返回null
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    <T> List<T> getObjectListSilently(String key, Class<T> clazz);


    /**
     * 得到json实例通过keys
     *
     * @param keys
     * @return
     */
    List<String> getStrings(List<String> keys);

    /**
     * 给某个key赋值 加给予有效期
     *
     * @param key
     * @param second
     * @return
     */
    String put(String key, String json, int second);

    /**
     * 存储json文本通过key
     *
     * @param key
     * @param json
     * @return
     */
    String putJson(String key, String json);


    /**
     * 批量删除实例keys
     *
     * @param key
     * @return
     */
    Long delete(String key);

    /**
     * 验证是否存在
     *
     * @param keys
     * @return
     */
    boolean delete(List<String> keys);

    /**
     * 移除一个分数从一个key中
     *
     * @param key
     * @param value
     */
    void removeWithScore(String key, String... value);

    /**
     * 统计set集合中元素根据索引 score从低到高
     *
     * @param key
     * @param startIndex
     * @param pageSize
     * @return
     */
    Collection<String> getZrangeByIndex(String key, int startIndex, int pageSize);

    /**
     * 统计set集合中元素根据score score从低到高
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    Collection<String> getZrangeByScore(String key, Double min, Double max);

    /**
     * 统计set集合中元素根据索引 score从高到低
     *
     * @param key
     * @param startIndex
     * @param pageSize
     * @return
     */
    Collection<String> getZrevrangeByIndex(String key, int startIndex, int pageSize);

    /**
     * 统计set集合全部元素 根据分数从低到高
     *
     * @param key
     * @return
     */
    Collection<String> getZRevrangeAll(String key);

    /**
     * 获取总数
     *
     * @param key
     * @return
     */
    Long getZcard(String key);

    /**
     * 增加Hash属性
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    Long hash(String key, String field, String value);

    /**
     * 获取key对应hash域的值
     *
     * @param key
     * @param field
     * @return
     */
    String getHash(String key, String field);

    /**
     * 是否存在域
     *
     * @param key
     * @param field
     * @return
     */
    Boolean hasHashByKey(String key, String field);


    /**
     * 删除key对应hash域的值
     *
     * @param key
     * @param field
     * @return
     */
    Long delHash(String key, String field);

    /**
     * 批量获取key对应hash域的值
     *
     * @param key
     * @param field
     * @return
     */
    List<String> getHash(String key, String... field);


    /**
     * 获取key中的所有的hash值的key
     *
     * @param key
     * @return
     */
    Set<String> getAllHashKey(String key);


    /**
     * 获取key中的所有的hash值
     *
     * @param key
     * @return
     */
    Map<String, String> getAllHash(String key);


    /**
     * 给某个key值给予有效期
     *
     * @param key
     * @param second
     * @return
     */
    Long expire(String key, int second);


    /**
     * 从左边加入key队列
     *
     * @param key
     * @param value
     * @return
     */
    Long addList(String key, String... value);


    /**
     * 获取key队列中指定序列的值
     *
     * @param key
     * @param index
     * @return
     */
    String getListByIndex(String key, int index);


    /**
     * 删除list中的值
     *
     * @param key
     * @param count
     * @param value @return
     */
    Long remList(String key, long count, String value);


    /**
     * 设置list中的值
     *
     * @param key
     * @param count
     * @param value @return
     */
    String lSet(String key, long count, String value);

    /**
     * 获取队列列表
     *
     * @param key
     * @param length
     * @return
     */
    Collection<String> getList(String key, int length);


    /**
     * 增加一个元素在set队列里面
     *
     * @param key
     * @param value
     * @return
     */
    Long addWithSet(String key, String... value);


    /**
     * 将元素插入集合中
     *
     * @param key
     * @param value
     * @return
     */
    Long addSet(String key, String value);


    /**
     * 从集合中删除元素
     *
     * @param key
     * @param value
     * @return
     */
    Long delSetByValue(String key, String... value);


    /**
     * 从集合获取元素
     *
     * @param key
     * @return
     */
    Set<String> getSet(String key);

    /**
     * key对应的值自增1
     *
     * @param key
     * @return
     */
    Long incr(String key);

    /**
     * key 对应的值增1，带过期时间
     * @param key
     * @param expire
     * @return
     */
    Long incr(String key, int expire);

    /**
     * key获取有效时间
     *
     * @param key
     * @return
     */
    Long ttlKey(String key);

    /**
     * 检查是否在set集合里面
     *
     * @param key
     * @param value
     * @return
     */
    Boolean sismemberSet(String key, String value);

    /**
     * 检查是否在set集合里面
     *
     * @param key
     * @return
     */
    String rankSet(String key);

    /**
     * 存放map
     *
     * @param key
     * @param map
     * @return
     */
    String putHash(String key, Map<String, String> map);

    Long getIndexByMember(String key, String member);

    /**
     * setnx
     * @param key
     * @param value
     * @param expire 超时时间，秒。若不超时则设置0
     * @return
     */
    boolean setNX(String key, String value, int expire);

    /**
     * 通过前缀获取所有的keys
     * @param prefix
     * @return
     */
    Collection<String> getKeys(String prefix);

    /**
     * 不catch异常信息的方式获取缓存值
     * @param key
     * @return
     */
    String getStringValue(String key);


    Long publish(String channal, String message);
}
