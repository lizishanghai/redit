package ca.ws.redis;

import java.util.*;
import java.util.UUID;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import ca.ws.entity.User;
import redis.clients.jedis.Jedis;

public class TestRedis {
	
	@Test
	public void test(){
		Jedis j = new Jedis("192.168.0.121",6379);
		System.out.println(j);
		
		System.out.println(j.get("name"));;
		System.out.println(j.get("age"));;
	}
	
	@Test
	public void testUser(){
		
		//插入500w跳数据
		
		//SELECT * FROM USER WEHER AGE = 25
		//SELECT * FROM USER WEHER AGE = 25 AND SEX = 'm'
		
		//多种集合配合使用 hash 和set 类型同时使用
		
		//指定业务 查询业务： SYS_USER_SEL_AGE_25
		//指定业务 查询业务： SYS_USER_SEL_SEX_m
		//指定业务 查询业务： SYS_USER_SEL_SEX_w 
		
		Jedis j = new Jedis("192.168.0.121",6379);
		
		final String SYS_USER_TABLE = "SYS_USER_TABLE";
		final String SYS_USER_SEL_AGE_25 = "SYS_USER_SEL_AGE_25";
		final String SYS_USER_SEL_SEX_m = "SYS_USER_SEL_SEX_m";
		final String SYS_USER_SEL_SEX_w = "SYS_USER_SEL_SEX_w";
		
		Set<String> user_age25_sexm = j.sinter(SYS_USER_SEL_AGE_25, SYS_USER_SEL_SEX_m);
		//System.out.println(user_age25_sexm.size());
		for(Iterator iterator = user_age25_sexm.iterator();iterator.hasNext();){
			String string = (String) iterator.next();
			System.out.println(string);
			
			String ret = j.hget(SYS_USER_TABLE, string);
			System.out.println(ret);
			
			User u = JSON.parseObject(ret, User.class);
			System.out.println(u.getSex());
			System.out.println(u.getAge());
		}
		
		
/*		Set<String> user_ages = j.smembers(SYS_USER_SEL_AGE_25);		
		for(Iterator iterator = user_ages.iterator();iterator.hasNext();){
			String string = (String) iterator.next();
			String ret = j.hget(SYS_USER_TABLE, string);
			System.out.println(ret);
		}
*/		
		/*
		Map<String, String> map = new HashMap<String, String>();
		
		String u1id = UUID.randomUUID().toString();
		User u1 = new User(u1id, "z1", 28, "m");
		map.put(u1id, JSON.toJSONString(u1));
		j.sadd(SYS_USER_SEL_SEX_m, u1id);

		String u2id = UUID.randomUUID().toString();
		User u2 = new User(u2id, "z2", 25, "m");
		map.put(u2id, JSON.toJSONString(u2));
		j.sadd(SYS_USER_SEL_SEX_m, u2id);
		j.sadd(SYS_USER_SEL_AGE_25, u2id);

		String u3id = UUID.randomUUID().toString();
		User u3 = new User(u3id, "z3", 25, "w");
		map.put(u3id, JSON.toJSONString(u3));
		j.sadd(SYS_USER_SEL_SEX_w, u3id);
		j.sadd(SYS_USER_SEL_AGE_25, u3id);
		

		String u4id = UUID.randomUUID().toString();
		User u4 = new User(u4id, "z4", 40, "m");
		map.put(u4id, JSON.toJSONString(u4));
		j.sadd(SYS_USER_SEL_SEX_m, u4id);

		String u5id = UUID.randomUUID().toString();
		User u5 = new User(u5id, "z5", 50, "w");
		map.put(u5id, JSON.toJSONString(u5));
		j.sadd(SYS_USER_SEL_SEX_w, u5id);
	
		j.hmset("SYS_USER_TABLE", map);
		*/

	}

}
