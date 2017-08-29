package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TCardHistory;
import z_tknight.oa.model.entity.TCardHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCardHistoryMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TCardHistoryExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TCardHistoryExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TCardHistoryExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TCardHistoryExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param historyNo [Integer](主键属性)卡片操作记录编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("historyNo") Integer historyNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TCardHistory]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TCardHistory record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TCardHistory]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TCardHistory record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TCardHistoryExample]自定义条件
	 * @return [List<TCardHistory>]符合自定义条件的数据
	 */
	List<TCardHistory> selectByExample(TCardHistoryExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param historyNo [Integer](主键属性)卡片操作记录编号
	 * @return [TCardHistory]查询结果
	 */
	TCardHistory selectByPrimaryKey(@Param("historyNo") Integer historyNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TCardHistory]数据对象，用于指定修改属性
	 * @param example [TCardHistoryExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TCardHistory record, @Param("example") TCardHistoryExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TCardHistory]数据对象，用于指定修改属性
	 * @param example [TCardHistoryExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TCardHistory record, @Param("example") TCardHistoryExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TCardHistory]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TCardHistory record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TCardHistory]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TCardHistory record);

}