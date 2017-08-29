package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TComment;
import z_tknight.oa.model.entity.TCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCommentMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TCommentExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TCommentExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TCommentExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TCommentExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param commentNo [Integer](主键属性)评论编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("commentNo") Integer commentNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TComment]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TComment record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TComment]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TComment record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TCommentExample]自定义条件
	 * @return [List<TComment>]符合自定义条件的数据
	 */
	List<TComment> selectByExample(TCommentExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param commentNo [Integer](主键属性)评论编号
	 * @return [TComment]查询结果
	 */
	TComment selectByPrimaryKey(@Param("commentNo") Integer commentNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TComment]数据对象，用于指定修改属性
	 * @param example [TCommentExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TComment record, @Param("example") TCommentExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TComment]数据对象，用于指定修改属性
	 * @param example [TCommentExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TComment record, @Param("example") TCommentExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TComment]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TComment record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TComment]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TComment record);

}