package z_tknight.oa.persist.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import z_tknight.oa.model.entity.TUser;
import z_tknight.oa.service.baseService.UserService;
import z_tknight.oa.service.baseServiceImpl.UserServiceImpl;

/**
 * 创建测试数据
 * 
 * @author 随心
 *
 */
public class CreateTestData {


	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/spring-*.xml"); 
		String[] beanNames = ctx.getBeanNamesForType(UserService.class);
		System.out.println(beanNames.length);
		for(String beanName : beanNames) {
			System.out.println(beanName);
		}
		UserServiceImpl service = (UserServiceImpl)ctx.getBean("userServiceImpl");
		TUser user = new TUser();
		user.setUserName("2357@qq.com");
		user.setPassword("test");
		user.setNickName("编号2357");
		service.userRegister(user);
	}
}
