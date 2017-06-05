import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.joao.bean.User;
import com.joao.service.UserService;

public class UserTest {

	UserService userService = new UserService();

	@Test
	public void getAllUse() {

		assertEquals(5, userService.getAllUsers().size());

	}

	@Test
	public void addUser() {

		User u = new User();
		u.setId(15l);
		u.setName("teste nome");

		assertNotNull(userService.addUser(u));

	}

	@Test
	public void getUser() {

		assertNotNull(userService.getUser(4));

	}

	@Test
	public void deletaUser() {

		userService.deleteUser(11);
		assertEquals(5, userService.getAllUsers().size());

	}
}
