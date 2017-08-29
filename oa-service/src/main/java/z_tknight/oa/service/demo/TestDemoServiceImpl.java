package z_tknight.oa.service.demo;

import org.springframework.stereotype.Service;

@Service("service")
public class TestDemoServiceImpl implements TestDemoService {

	@Override
	public void test() {
		System.out.println("TestDemoServiceImpl....");
	}
}
