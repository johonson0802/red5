package liveDemo.dao;

import org.springframework.stereotype.Repository;

import liveDemo.model.LiveRedis;

@Repository
public class LiveRedisDAO extends IRedisDAO<LiveRedis>{
	private static final String REDIS_KEY = "liveDemo.model.LiveRedis";
	
	@SuppressWarnings("static-access")
	@Override
	protected String getRedisKey() {
		// TODO Auto-generated method stub
		return this.REDIS_KEY;
	}

}
