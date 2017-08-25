package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TList;
import z_tknight.oa.model.entity.TListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TListMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TListExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TListExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TListExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TListExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param listNo [Integer](主键属性)列表编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("listNo") Integer listNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TList]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TList record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TList]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TList record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TListExample]自定义条件
	 * @return [List<TList>]符合自定义条件的数据
	 */
	List<TList> selectByExample(TListExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param listNo [Integer](主键属性)列表编号
	 * @return [TList]查询结果
	 */
	TList selectByPrimaryKey(@Param("listNo") Integer listNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TList]数据对象，用于指定修改属性
	 * @param example [TListExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TList record, @Param("example") TListExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TList]数据对象，用于指定修改属性
	 * @param example [TListExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TList record, @Param("example") TListExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TList]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TList record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TList]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TList record);

}