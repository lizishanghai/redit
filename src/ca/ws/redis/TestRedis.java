package ca.ws.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestRedis {
	
	@Test
	public void test(){
		Jedis j = new Jedis("192.168.0.121",6379);
		System.out.println(j);
		
		System.out.println(j.get("name"));;
		System.out.println(j.get("age"));;
	}

}
