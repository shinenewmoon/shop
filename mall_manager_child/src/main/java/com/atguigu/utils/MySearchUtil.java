package com.atguigu.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.atguigu.bean.OBJECT_T_MALL_ATTR;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class MySearchUtil {
	
	public static <T> List<T> getRedis(Class<T> t,String key){
		List<T> list = new ArrayList<T>();
		//从redis中获取数据
		/*
		 * redis获取数据有两种方式，此时采用的时第二种方式，将二级分类的id作为key值，object_sku的json值为value
		 */
		//连接redis
		JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
		Jedis jedis = jedisPool.getResource();
		//获取到redis中的json集合
		Set<String> set = jedis.zrange(key, 0, -1);
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String next = iterator.next();
			T object = MyJsonUtil.json_to_object(next, t);
			list.add(object);
		}
		return list;
	}

	public static <T> void setRedis(String key, List<T> list) {
			JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
			Jedis jedis = jedisPool.getResource();
			for (int i = 0; i < list.size(); i++) {
				jedis.zadd(key, i, MyJsonUtil.object_to_json(list.get(i)));
			}
	}

	public static <T> String getRedisByKeys(String[] keys) {
		JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
		Jedis jedis = jedisPool.getResource();
		String new_key = "new_key";
		for (int i = 0; i < keys.length; i++) {
			new_key = new_key + "_" + keys[i];
		}
		if(!jedis.exists(new_key)) {
			jedis.zinterstore(new_key, keys);
		}
		return new_key;
	}
}
