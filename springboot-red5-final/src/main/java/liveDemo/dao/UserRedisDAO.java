package liveDemo.dao;

import org.springframework.stereotype.Repository;

import liveDemo.model.UserRedis;

@Repository
public class UserRedisDAO extends IRedisDAO<UserRedis>{

	private static final String REDIS_KEY = "liveDemo.model.UserRedis";
	
	@SuppressWarnings("static-access")
	@Override
	protected String getRedisKey() {
		// TODO Auto-generated method stub
		return this.REDIS_KEY;
	}

}
