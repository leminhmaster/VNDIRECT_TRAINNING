package edu.hanoi.service.springhnservice;

import edu.hanoi.service.SpringHnserviceApplication;
import edu.hanoi.service.controller.UserRestServiceController;
import edu.hanoi.service.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@SpringBootTest(classes = SpringHnserviceApplication.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(listeners = {ServletTestExecutionListener.class, DependencyInjectionTestExecutionListener.class, WithSecurityContextTestExecutionListener.class})
class SpringHnserviceApplicationTests {
	@Autowired
	UserRestServiceController userRestServiceController;

	@Test
	@WithMockUser(username = "username-random2",password = "password101181232", roles = {"USER"})
	void contextLoads() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		List<User> users = userRestServiceController.listUser(request);
		Assert.assertTrue(users.size()>0);

		users.forEach(user -> {
			Assert.assertTrue(user.getAge() > 50);
		});
	}

}
