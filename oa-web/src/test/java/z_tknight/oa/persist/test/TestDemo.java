package z_tknight.oa.persist.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import z_tknight.oa.model.entity.TBoardSpace;
import z_tknight.oa.persist.complex.mapper.BoardSpaceAndBoardMapper;

@ContextConfiguration("classpath:config/spring/spring-*.xml")
public class TestDemo extends AbstractJUnit4SpringContextTests {

	@Resource
	BoardSpaceAndBoardMapper mapper;
	
	@Test
	public void test() {
		List<TBoardSpace> tbsList = mapper.selectBoardSpaceByUserNo(2);
		for(TBoardSpace tbs : tbsList) {
			System.out.println(tbs.toString());
		}
		System.out.println("共计" + tbsList.size() + "个看板空间");
	}
}
