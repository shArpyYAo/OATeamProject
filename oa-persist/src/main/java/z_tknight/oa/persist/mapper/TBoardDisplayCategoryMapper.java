package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TBoardDisplayCategory;
import z_tknight.oa.model.entity.TBoardDisplayCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBoardDisplayCategoryMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TBoardDisplayCategoryExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TBoardDisplayCategoryExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TBoardDisplayCategoryExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TBoardDisplayCategoryExample example);

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
	 * @param record [TBoardDisplayCategory]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TBoardDisplayCategory record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TBoardDisplayCategory]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TBoardDisplayCategory record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TBoardDisplayCategoryExample]自定义条件
	 * @return [List<TBoardDisplayCategory>]符合自定义条件的数据
	 */
	List<TBoardDisplayCategory> selectByExample(TBoardDisplayCategoryExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param categoryNo [Integer](主键属性)看板空间类别编号
	 * @return [TBoardDisplayCategory]查询结果
	 */
	TBoardDisplayCategory selectByPrimaryKey(@Param("categoryNo") Integer categoryNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TBoardDisplayCategory]数据对象，用于指定修改属性
	 * @param example [TBoardDisplayCategoryExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TBoardDisplayCategory record, @Param("example") TBoardDisplayCategoryExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TBoardDisplayCategory]数据对象，用于指定修改属性
	 * @param example [TBoardDisplayCategoryExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TBoardDisplayCategory record, @Param("example") TBoardDisplayCategoryExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TBoardDisplayCategory]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TBoardDisplayCategory record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TBoardDisplayCategory]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TBoardDisplayCategory record);

}