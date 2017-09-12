package z_tknight.oa.persist.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import z_tknight.oa.commons.util.CollectionUtil;
import z_tknight.oa.commons.util.MathUtil;
import z_tknight.oa.commons.util.StringUtil;
import z_tknight.oa.model.entity.TBoard;
import z_tknight.oa.model.entity.TBoardSpace;
import z_tknight.oa.model.entity.TBoardSpaceUser;
import z_tknight.oa.model.entity.TBoardSpaceUserExample;
import z_tknight.oa.model.entity.TBoardUser;
import z_tknight.oa.model.entity.TUser;
import z_tknight.oa.persist.mapper.TBoardMapper;
import z_tknight.oa.persist.mapper.TBoardSpaceMapper;
import z_tknight.oa.persist.mapper.TBoardSpaceUserMapper;
import z_tknight.oa.persist.mapper.TBoardUserMapper;
import z_tknight.oa.persist.mapper.TUserMapper;
//@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
import z_tknight.oa.service.baseService.BoardSpaceService;
import z_tknight.oa.service.baseService.UserService;

/**
 * 创建测试数据
 * 
 * @author 随心
 *
 */
@ContextConfiguration("classpath:config/spring/spring-*.xml")
public class CreateTestData extends AbstractJUnit4SpringContextTests {

	@Resource
	TUserMapper umapper;
	
	@Resource
	TBoardSpaceMapper bsmapper;
	
	@Resource
	TBoardSpaceUserMapper bsumapper;
	
	@Resource
	UserService uservice;
	
	@Resource
	BoardSpaceService bsservice;
	
	@Test
	public void createDate() {
		// 注册10个用户,每个用户创建3个看板空间
		createUserAndBS(10, 3);
	}
	
	/**
	 * 创建指定数量的用户,每个用户再创建指定数量的看板空间
	 * <pre>
	 * 用户密码统一为:test
	 * </pre>
	 * @param userNum [int]用户数量
	 * @param bsNum [int]每个用户创建的看板空间数量
	 */
	private void createUserAndBS(int userNum, int bsNum) {
		// 存储用户编号
		List<Integer> userNos = new ArrayList<Integer>();
		// 存储用户创建的看板空间(个人空间+普通项目)
		List<TBoardSpace> allBss = new ArrayList<TBoardSpace>();
		// 注册userNum个用户
		for(int i = 0; i < userNum; i ++) {
			TUser user = new TUser();
			int no = MathUtil.getRandom(1000, 9999) * 10 + i;
			user.setUserName(no + "@qq.com");
			user.setPassword("test");
			user.setNickName("编号" + no);
			umapper.insertSelective(user);
			// 存储用户编号
			userNos.add(user.getUserNo());
			// 存储个人空间
			allBss.add(insertBS("个人空间", 1, user.getUserNo()));
			// 每个用户创建bsNum个项目
			for(int k = 1; k <= bsNum; k ++) {
				String boardSpaceName = no + "的看板" + k;
				int userNo = user.getUserNo();
				// 存储普通项目看板空间
				allBss.add(insertBS(boardSpaceName, 2, userNo));
			}
		}
		System.err.println("共计创建了" + userNos.size() + "个用户," + allBss.size() + "个看板空间");
		// 看板空间随机添加成员
		addUserForBS(allBss, userNos);
	}
	
	/**
	 * 新建看板空间
	 * @param boardSpaceName [String]看板名称/默认摘要名
	 * @param cNo [int]看板空间类型
	 * @param userNo [int]看板所有人编号
	 * @return [TBoardSpace]创建的看板对象
	 */
	private TBoardSpace insertBS(String boardSpaceName, int cNo, int userNo) {
		TBoardSpace boardSpace = new TBoardSpace();
		boardSpace.setBoardSpaceName(boardSpaceName);
		boardSpace.setIsDelete(false);
		boardSpace.setSummary(boardSpaceName);
		boardSpace.setUserNo(userNo);
		boardSpace.setCategoryNo(cNo);
		bsmapper.insertSelective(boardSpace);
		return boardSpace;
	}
	
	@Resource
	TBoardMapper bmapper;
	
	/**
	 * 每个看板空间随机1~userNum/2个成员创建看板,每个看板随机添加1~userNum-2个人
	 * @param bss [List<TBoardSpace>]看板空间信息
	 * @param userNos [List<Integer>]用户编号
	 */
	private void addUserForBS(List<TBoardSpace> bss, List<Integer> userNos) {
		// 一半用户
		int halfNum = userNos.size() >> 1;
		int randNum;
		int userNo;
		int buNo;
		int index;
		List<Integer> uNos;
		List<Integer> buNos;
		int bsi = 0;
		int bi = 0;
		for(TBoardSpace bs : bss) {
			++ bsi;
			// 创建看板的用户数目
			randNum = MathUtil.getRandom(1, halfNum);
			buNos = new ArrayList<Integer>(userNos);
			System.out.println("[第" + bsi + "个看板空间需要创建" + randNum + "个看板]");
			bi = 0;
			// 循环遍历随机添加
			while(randNum > 0) {
				++ bi;
				// 随机取出一个用户
				index = MathUtil.getRandom(0, buNos.size() - 1);
				buNo = buNos.get(index);
				buNos.remove(index);
				randNum --;
				// 创建看板
				TBoard tb = createB(bs.getBoardSpaceNo() + "$" + buNo + "编号看板", bs, buNo);
				// 随机添加1~userNum/2人
				uNos = new ArrayList<Integer>(userNos);
				int userNum = MathUtil.getRandom(1, userNos.size() - 2);
				System.err.println("第" + bsi + "个看板空间中的第" + bi + "个看板一共" + userNum + "个成员");
				while(userNum > 0) {
					// 随机取出一个用户
					index = MathUtil.getRandom(0, uNos.size() - 1);
					userNo = uNos.get(index);
					uNos.remove(index);
					if(userNo != tb.getUserNo()) {
						// 添加进看板
						insertBSUser(bs.getBoardSpaceNo(), tb.getBoardNo(), userNo);
						userNum --;
					}
				}
			}
		}
	}
	
	/**
	 * 新建看板
	 * @param bName
	 * @param bs
	 * @param userNo
	 * @return
	 */
	private TBoard createB(String bName, TBoardSpace bs, int userNo) {
		// 创建看板
		TBoard tb = new TBoard();
		tb.setBoardName(bName);
		tb.setBoardSpaceNo(bs.getBoardSpaceNo());
		tb.setUserNo(userNo);
		tb.setDisplayNo(MathUtil.getRandom(1, 2)); // 随机可见性
		tb.setIsDelete(false);
		bmapper.insert(tb);
		// 修改看板空间顺序
		bs.setBoardOrder(bs.getBoardOrder() + 
				(StringUtil.isEmpty(bs.getBoardOrder()) ? "" : ",") + tb.getBoardNo());
		return tb;
	}
	
	@Resource
	TBoardUserMapper bumapper;
	
	/**
	 * 为看板添加用户
	 * @param bsu
	 * @param bNo
	 * @param userNo
	 */
	private void insertBSUser(int bsNo, int bNo, int userNo) {
		// 看板添加用户
		TBoardUser bu = new TBoardUser();
		bu.setBoardNo(bNo);
		bu.setUserNo(userNo);
		bumapper.insert(bu);
		// 看板空间添加用户
		TBoardSpaceUserExample example = new TBoardSpaceUserExample();
		TBoardSpaceUserExample.Criteria c = example.createCriteria();
		c.andBoardSpaceNoEqualTo(bsNo);
		c.andUserNoEqualTo(userNo);
		// 项目中是否存在看板用户
		if(CollectionUtil.isEmpty(bsumapper.selectByExample(example))) {
			TBoardSpace tbs = bsmapper.selectByPrimaryKey(bsNo);
			// 该用户是否是看板空间所有人
			if(tbs == null || tbs.getUserNo() != userNo) {
				TBoardSpaceUser bsu = new TBoardSpaceUser();
				bsu.setBoardSpaceNo(bsNo);
				bsu.setUserNo(userNo);
				bsumapper.insert(bsu);
			}
		}
	}
	
}
