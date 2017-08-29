package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TCard;
import z_tknight.oa.model.entity.TCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCardMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TCardExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TCardExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TCardExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TCardExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param cardNo [Integer](主键属性)卡片编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("cardNo") Integer cardNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TCard]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TCard record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TCard]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TCard record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TCardExample]自定义条件
	 * @return [List<TCard>]符合自定义条件的数据
	 */
	List<TCard> selectByExample(TCardExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param cardNo [Integer](主键属性)卡片编号
	 * @return [TCard]查询结果
	 */
	TCard selectByPrimaryKey(@Param("cardNo") Integer cardNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TCard]数据对象，用于指定修改属性
	 * @param example [TCardExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TCard record, @Param("example") TCardExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TCard]数据对象，用于指定修改属性
	 * @param example [TCardExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TCard record, @Param("example") TCardExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TCard]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TCard record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TCard]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TCard record);

}