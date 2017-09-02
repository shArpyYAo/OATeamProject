package z_tknight.oa.persist.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import z_tknight.oa.commons.util.MathUtil;
import z_tknight.oa.model.entity.TUser;
import z_tknight.oa.service.baseService.BoardSpaceService;
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
		UserService service = (UserService)ctx.getBean("userServiceImpl");
		BoardSpaceService bsservice = (BoardSpaceService)ctx.getBean("boardSpaceServiceImpl");
		// 注册10个用户
		for(int i = 0; i < 10; i ++) {
			TUser user = new TUser();
			int no = MathUtil.getRandom(1000, 9999) * 10 + i;
			user.setUserName(no + "@qq.com");
			user.setPassword("test");
			user.setNickName("编号" + no);
			service.userRegister(user);
			// 每个用户创建三个项目
			for(int k = 1; k < 4; k ++) {
				bsservice.addBoardSpace(user.getUserNo(), no + "的看板" + k);
			}
		}
	}
}
