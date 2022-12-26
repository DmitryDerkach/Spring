package spring.integration.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import lombok.RequiredArgsConstructor;
import spring.database.pool.ConnectionPool;
import spring.integration.annotattion.IT;
import spring.service.UserService;

@IT
@RequiredArgsConstructor
public class UserServiceIT {
	
	private final UserService userService;
	private final ConnectionPool pool1;
	
	@Test
	void test() {
		
	}
}
