package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TListOrder;
import z_tknight.oa.model.entity.TListOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TListOrderMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TListOrderExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TListOrderExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TListOrderExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TListOrderExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param orderNo [Integer](主键属性)顺序编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("orderNo") Integer orderNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TListOrder]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TListOrder record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TListOrder]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TListOrder record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TListOrderExample]自定义条件
	 * @return [List<TListOrder>]符合自定义条件的数据
	 */
	List<TListOrder> selectByExample(TListOrderExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param orderNo [Integer](主键属性)顺序编号
	 * @return [TListOrder]查询结果
	 */
	TListOrder selectByPrimaryKey(@Param("orderNo") Integer orderNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TListOrder]数据对象，用于指定修改属性
	 * @param example [TListOrderExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TListOrder record, @Param("example") TListOrderExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TListOrder]数据对象，用于指定修改属性
	 * @param example [TListOrderExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TListOrder record, @Param("example") TListOrderExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TListOrder]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TListOrder record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TListOrder]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TListOrder record);

}