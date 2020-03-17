package liveDemo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import liveDemo.dao.RedisConfig;
import liveDemo.dao.UserRedisDAO;
import liveDemo.model.UserRedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RedisConfig.class,UserRedisDAO.class})
public class UserRedisTest {
	@Autowired
	UserRedisDAO userRedis;
	
	@Test
	public void testPut(){
		UserRedis user = new UserRedis();
		user.setName("武则天");
		user.setPassword("123456");
		userRedis.put(user.getName(), user, -1);
	}
	
	@Test
	public void testFindAll(){
		List<UserRedis> users = userRedis.getAll();
		for(UserRedis user1:users){
			System.out.println(user1.getName()+"-密码："+user1.getPassword());
		}
	}
}
