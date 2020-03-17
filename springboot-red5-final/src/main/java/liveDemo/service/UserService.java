package liveDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liveDemo.dao.UserRedisDAO;
import liveDemo.model.UserRedis;

@Service
public class UserService {
	@Autowired
	UserRedisDAO userRedisDAO;
	
	public List<UserRedis> getAll(){
		List<UserRedis> users = userRedisDAO.getAll();
		return users;
	}
	
	public void save(UserRedis user){
		userRedisDAO.put(user.getName(), user, -1);
	}
	
	public boolean isUser(UserRedis user){
		boolean isUser = true;
		UserRedis realUser = userRedisDAO.get(user.getName());
		if(realUser == null){
			isUser = false;
		}else{
			System.out.println(user);
			if(!user.getPassword().equals(realUser.getPassword())){
				isUser=false;
			}
			System.out.println(realUser);
			System.out.println(realUser.getEmail());
			System.out.println(user.getEmail());
			if(!user.getEmail().equals(realUser.getEmail())){
				isUser=false;
			}
		}
		return isUser;
	} 
}
