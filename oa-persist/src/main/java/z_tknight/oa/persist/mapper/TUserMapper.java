package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TUser;
import z_tknight.oa.model.entity.TUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TUserExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TUserExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TUserExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TUserExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param userNo [Integer](主键属性)用户编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("userNo") Integer userNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TUser]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TUser record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TUser]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TUser record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TUserExample]自定义条件
	 * @return [List<TUser>]符合自定义条件的数据
	 */
	List<TUser> selectByExample(TUserExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param userNo [Integer](主键属性)用户编号
	 * @return [TUser]查询结果
	 */
	TUser selectByPrimaryKey(@Param("userNo") Integer userNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TUser]数据对象，用于指定修改属性
	 * @param example [TUserExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TUser]数据对象，用于指定修改属性
	 * @param example [TUserExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TUser]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TUser record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TUser]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TUser record);

}