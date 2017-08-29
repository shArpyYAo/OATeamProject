package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TBoardOrder;
import z_tknight.oa.model.entity.TBoardOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBoardOrderMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TBoardOrderExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TBoardOrderExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TBoardOrderExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TBoardOrderExample example);

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
	 * @param record [TBoardOrder]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TBoardOrder record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TBoardOrder]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TBoardOrder record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TBoardOrderExample]自定义条件
	 * @return [List<TBoardOrder>]符合自定义条件的数据
	 */
	List<TBoardOrder> selectByExample(TBoardOrderExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param orderNo [Integer](主键属性)顺序编号
	 * @return [TBoardOrder]查询结果
	 */
	TBoardOrder selectByPrimaryKey(@Param("orderNo") Integer orderNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TBoardOrder]数据对象，用于指定修改属性
	 * @param example [TBoardOrderExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TBoardOrder record, @Param("example") TBoardOrderExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TBoardOrder]数据对象，用于指定修改属性
	 * @param example [TBoardOrderExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TBoardOrder record, @Param("example") TBoardOrderExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TBoardOrder]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TBoardOrder record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TBoardOrder]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TBoardOrder record);

}