package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TBoardSpaceCategory;
import z_tknight.oa.model.entity.TBoardSpaceCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBoardSpaceCategoryMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TBoardSpaceCategoryExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TBoardSpaceCategoryExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TBoardSpaceCategoryExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TBoardSpaceCategoryExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param categoryNo [Integer](主键属性)看板空间类别编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("categoryNo") Integer categoryNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TBoardSpaceCategory]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TBoardSpaceCategory record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TBoardSpaceCategory]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TBoardSpaceCategory record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TBoardSpaceCategoryExample]自定义条件
	 * @return [List<TBoardSpaceCategory>]符合自定义条件的数据
	 */
	List<TBoardSpaceCategory> selectByExample(TBoardSpaceCategoryExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param categoryNo [Integer](主键属性)看板空间类别编号
	 * @return [TBoardSpaceCategory]查询结果
	 */
	TBoardSpaceCategory selectByPrimaryKey(@Param("categoryNo") Integer categoryNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TBoardSpaceCategory]数据对象，用于指定修改属性
	 * @param example [TBoardSpaceCategoryExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TBoardSpaceCategory record, @Param("example") TBoardSpaceCategoryExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TBoardSpaceCategory]数据对象，用于指定修改属性
	 * @param example [TBoardSpaceCategoryExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TBoardSpaceCategory record, @Param("example") TBoardSpaceCategoryExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TBoardSpaceCategory]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TBoardSpaceCategory record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TBoardSpaceCategory]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TBoardSpaceCategory record);

}