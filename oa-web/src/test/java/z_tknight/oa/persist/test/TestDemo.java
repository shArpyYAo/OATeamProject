package z_tknight.oa.persist.test;

import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import z_tknight.oa.model.entity.TBoardSpace;
import z_tknight.oa.model.entity.TCard;
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
	
	static int hash(int h) {    
        h ^= (h >>> 20) ^ (h >>> 12);    
        return h ^ (h >>> 7) ^ (h >>> 4);    
    }  

	
	public static void main(String[] args) {
		Class<?> clazz = TCard.class;
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			System.out.println("    	" + field.getName() + ": ,");
		}
	}
}
