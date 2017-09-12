package z_tknight.oa.persist.complex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import z_tknight.oa.model.dto.BoardSpaceAndBoardDto;
import z_tknight.oa.model.entity.TBoardSpace;

/**
 * 看板空间和看板复杂SQL操作
 * 
 * @author 随心
 *
 */
public interface BoardSpaceAndBoardMapper {

	/**
	 * 根据用户编号查询用户可见的所有看板及其看板空间详细信息
	 *
	 * @param userNo [Integer](主键属性)用户编号
	 * @return [List<BoardSpaceAndBoardDto>]用户可见的所有看板及其看板空间详细信息
	 */
	List<BoardSpaceAndBoardDto> selectBoardSpaceAndBoardDetail(@Param("userNo") Integer userNo);
	
	/**
	 * 根据用户编号查询用户可见的看板空间详细信息
	 * <pre>
	 * 查询出来的看板空间分为两类
	 * 1、用户是成员的普通类型的看板空间
	 * 2、用户是所有人的看板空间
	 * </pre>
	 *
	 * @param userNo [Integer](主键属性)用户编号
	 * @return [List<BoardSpaceAndBoardDto>]用户可见的看板空间详细信息
	 */
	List<TBoardSpace> selectBoardSpaceByUserNo(@Param("userNo") Integer userNo);
}
