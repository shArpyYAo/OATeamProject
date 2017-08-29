package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TCardUser;
import z_tknight.oa.model.entity.TCardUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCardUserMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TCardUserExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TCardUserExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TCardUserExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TCardUserExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param relationNo [Integer](主键属性)关系编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("relationNo") Integer relationNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TCardUser]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TCardUser record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TCardUser]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TCardUser record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TCardUserExample]自定义条件
	 * @return [List<TCardUser>]符合自定义条件的数据
	 */
	List<TCardUser> selectByExample(TCardUserExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param relationNo [Integer](主键属性)关系编号
	 * @return [TCardUser]查询结果
	 */
	TCardUser selectByPrimaryKey(@Param("relationNo") Integer relationNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TCardUser]数据对象，用于指定修改属性
	 * @param example [TCardUserExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TCardUser record, @Param("example") TCardUserExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TCardUser]数据对象，用于指定修改属性
	 * @param example [TCardUserExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TCardUser record, @Param("example") TCardUserExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TCardUser]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TCardUser record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TCardUser]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TCardUser record);

}