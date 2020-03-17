package liveDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liveDemo.dao.LiveRedisDAO;
import liveDemo.model.LiveRedis;

@Service
public class LiveService {
	@Autowired
	LiveRedisDAO liveRedisDAO;
	
	public List<LiveRedis> getAll() {
		List<LiveRedis> users = liveRedisDAO.getAll();
		return users;
	}
	
	public void save(LiveRedis live){
		liveRedisDAO.put(live.getKeyName(), live, -1);
	}
}
