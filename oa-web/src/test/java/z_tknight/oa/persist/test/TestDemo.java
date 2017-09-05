package z_tknight.oa.persist.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import z_tknight.oa.model.dto.BoardSpaceAndBoardDto;
import z_tknight.oa.persist.complex.mapper.BoardSpaceAndBoardMapper;

@ContextConfiguration("classpath:config/spring/spring-*.xml")
public class TestDemo extends AbstractJUnit4SpringContextTests {

	@Resource
	BoardSpaceAndBoardMapper mapper;
	
	@Test
	public void test() {
		List<BoardSpaceAndBoardDto> result = mapper.selectBoardSpaceAndBoardDetail(1);
		for(BoardSpaceAndBoardDto dto : result) {
			System.out.println("[" + dto.getBoard().toString() + "]");
			System.out.println("[" + dto.getBoardSpace().toString() + "]");
		}
		System.err.println("共计" + result.size() + "条记录");
	}
}
