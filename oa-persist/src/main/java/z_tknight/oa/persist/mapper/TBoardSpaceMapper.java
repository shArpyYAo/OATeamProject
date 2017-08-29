package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TBoardSpace;
import z_tknight.oa.model.entity.TBoardSpaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBoardSpaceMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TBoardSpaceExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TBoardSpaceExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TBoardSpaceExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TBoardSpaceExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param boardSpaceNo [Integer](主键属性)看板空间编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("boardSpaceNo") Integer boardSpaceNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TBoardSpace]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TBoardSpace record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TBoardSpace]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TBoardSpace record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TBoardSpaceExample]自定义条件
	 * @return [List<TBoardSpace>]符合自定义条件的数据
	 */
	List<TBoardSpace> selectByExample(TBoardSpaceExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param boardSpaceNo [Integer](主键属性)看板空间编号
	 * @return [TBoardSpace]查询结果
	 */
	TBoardSpace selectByPrimaryKey(@Param("boardSpaceNo") Integer boardSpaceNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TBoardSpace]数据对象，用于指定修改属性
	 * @param example [TBoardSpaceExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TBoardSpace record, @Param("example") TBoardSpaceExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TBoardSpace]数据对象，用于指定修改属性
	 * @param example [TBoardSpaceExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TBoardSpace record, @Param("example") TBoardSpaceExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TBoardSpace]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TBoardSpace record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TBoardSpace]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TBoardSpace record);

}