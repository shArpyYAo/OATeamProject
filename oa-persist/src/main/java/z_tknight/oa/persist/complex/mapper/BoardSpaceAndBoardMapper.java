package z_tknight.oa.persist.complex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import z_tknight.oa.model.dto.BoardSpaceAndBoardDto;

/**
 * 权限判断数据库操作接口
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
}
