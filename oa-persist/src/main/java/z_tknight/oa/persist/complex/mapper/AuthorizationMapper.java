package z_tknight.oa.persist.complex.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * 授权认证持久层接口
 * 
 * @author 随心
 *
 */
public interface AuthorizationMapper {

	/**
	 * 判断用户是否有权限查看看板详情
	 * <pre>
	 * 用户是看板所属看板空间所有人或
	 * 用户是看板所有人或
	 * 用户是看板成员时,总是有权限查看看板详情
	 * 看板可见度为2(项目成员可见)且用户是看板空间成员时也可查看看板详情
	 * </pre>
	 * @param userNo [Integer]用户编号
	 * @param boardNo [Integer]看板编号
	 * @return 
	 * 0:无权限查看,<br/>
	 * 1:用户是看板空间所有人,<br/>
	 * 2:用户是看板所有人,<br/>
	 * 3:用户是看板成员,<br/>
	 * 4:看板可见度为2(项目成员可见)用户作为看板空间成员可见项目
	 */
	Integer canSelectBoard(@Param("userNo") Integer userNo, 
			@Param("boardNo") Integer boardNo);
	
	/**
	 * 判断用户是否是看板空间所有人或成员
	 * @param boardSpaceNo [Integer]看板空间编号
	 * @param userNo [Integer]用户编号
	 * @return
	 * 0:不是看板空间成员或所有人<br/>
	 * 1:用户是看板空间所有人<br/>
	 * 2:用户是看板空间成员<br/>
	 * 3:用户不存在<br/>
	 * 4:看板空间不存在<br/>
	 */
	Integer isBoardSpaceMember(@Param("boardSpaceNo") Integer boardSpaceNo, 
			@Param("userNo") Integer userNo);
}
