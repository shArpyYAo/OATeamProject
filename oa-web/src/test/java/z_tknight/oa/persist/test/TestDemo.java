package z_tknight.oa.persist.test;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import z_tknight.oa.model.entity.TComment;
import z_tknight.oa.persist.complex.mapper.BoardSpaceAndBoardMapper;
import z_tknight.oa.persist.mapper.TCommentMapper;

@ContextConfiguration("classpath:config/spring/spring-*.xml")
public class TestDemo extends AbstractJUnit4SpringContextTests {

	@Resource
	BoardSpaceAndBoardMapper mapper;
	
	@Resource
	TCommentMapper commentMapper;
	
	@Test
	public void test() {
		TComment comment = commentMapper.selectByPrimaryKey(3);
		System.out.println(comment.getCommentTime());
		comment = commentMapper.selectByPrimaryKey(2);
		System.out.println(comment.getCommentTime());
		comment = commentMapper.selectByPrimaryKey(4);
		System.out.println(comment.getCommentTime());
	}
	
	static int hash(int h) {    
        h ^= (h >>> 20) ^ (h >>> 12);    
        return h ^ (h >>> 7) ^ (h >>> 4);    
    }  

	
	public static void main(String[] args) {
//		Class<?> clazz = TCard.class;
//		Field[] fields = clazz.getDeclaredFields();
//		for(Field field : fields) {
//			System.out.println("    	" + field.getName() + ": ,");
//		}
//		Date date = new Date(); // 当前时间
//		// 创建简单的日期格式化对象,并设置转换成的字符串的格式
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh点mm分ss秒");
//		String dateStr = sdf.format(date); // 转换成指定格式的字符串
//		System.out.println(dateStr);
//		System.out.println(new Date(1505891544197L).toString());
//		System.out.println(new Timestamp(1505891544197L).toString());
		String a = "15,26,615,2,256,265,8,9,25";
		System.out.println(a);
		System.out.println(a.replaceAll("^15,", ""));
	}
}
