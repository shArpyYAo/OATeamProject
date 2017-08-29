package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TCardOrder;
import z_tknight.oa.model.entity.TCardOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCardOrderMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TCardOrderExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TCardOrderExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TCardOrderExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TCardOrderExample example);

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
	 * @param record [TCardOrder]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TCardOrder record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TCardOrder]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TCardOrder record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TCardOrderExample]自定义条件
	 * @return [List<TCardOrder>]符合自定义条件的数据
	 */
	List<TCardOrder> selectByExample(TCardOrderExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param orderNo [Integer](主键属性)顺序编号
	 * @return [TCardOrder]查询结果
	 */
	TCardOrder selectByPrimaryKey(@Param("orderNo") Integer orderNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TCardOrder]数据对象，用于指定修改属性
	 * @param example [TCardOrderExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TCardOrder record, @Param("example") TCardOrderExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TCardOrder]数据对象，用于指定修改属性
	 * @param example [TCardOrderExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TCardOrder record, @Param("example") TCardOrderExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TCardOrder]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TCardOrder record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TCardOrder]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TCardOrder record);

}