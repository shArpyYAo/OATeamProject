package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TTag;
import z_tknight.oa.model.entity.TTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTagMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TTagExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TTagExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TTagExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TTagExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param tagNo [Integer](主键属性)标签编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("tagNo") Integer tagNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TTag]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TTag record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TTag]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TTag record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TTagExample]自定义条件
	 * @return [List<TTag>]符合自定义条件的数据
	 */
	List<TTag> selectByExample(TTagExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param tagNo [Integer](主键属性)标签编号
	 * @return [TTag]查询结果
	 */
	TTag selectByPrimaryKey(@Param("tagNo") Integer tagNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TTag]数据对象，用于指定修改属性
	 * @param example [TTagExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TTag record, @Param("example") TTagExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TTag]数据对象，用于指定修改属性
	 * @param example [TTagExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TTag record, @Param("example") TTagExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TTag]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TTag record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TTag]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TTag record);

}