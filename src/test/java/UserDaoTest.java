import static org.junit.Assert.*;

import org.controller.User;
import org.junit.Before;
import org.junit.Test;
import org.persistence.UserDao;

public class UserDaoTest {

	private UserDao userDao;
	
	@Before
	public void setup() {
		userDao = new UserDao();
	}
	
	@Test
	public void addUserTest() {
		User user = new User("qwebnm7788", "jaewon", "password", "KOR");
		userDao.addUser(user);
	}
	
	@Test
	public void findByUseridTest() {
		User user = userDao.findByUserid("qwebnm7788");
		assertNotNull(user);

		user = userDao.findByUserid("mk");
		assertNull(user);
	}
	
	@Test
	public void removeUserTest() {
		userDao.removeUser("qwebnm7788");
		
		assertNull(userDao.findByUserid("qwebnm7788"));
	}
}
