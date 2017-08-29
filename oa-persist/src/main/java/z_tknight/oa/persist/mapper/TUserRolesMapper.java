package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TUserRoles;
import z_tknight.oa.model.entity.TUserRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserRolesMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TUserRolesExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TUserRolesExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TUserRolesExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TUserRolesExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param userRolesNo [Integer](主键属性)用户角色关系编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("userRolesNo") Integer userRolesNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TUserRoles]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TUserRoles record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TUserRoles]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TUserRoles record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TUserRolesExample]自定义条件
	 * @return [List<TUserRoles>]符合自定义条件的数据
	 */
	List<TUserRoles> selectByExample(TUserRolesExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param userRolesNo [Integer](主键属性)用户角色关系编号
	 * @return [TUserRoles]查询结果
	 */
	TUserRoles selectByPrimaryKey(@Param("userRolesNo") Integer userRolesNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TUserRoles]数据对象，用于指定修改属性
	 * @param example [TUserRolesExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TUserRoles record, @Param("example") TUserRolesExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TUserRoles]数据对象，用于指定修改属性
	 * @param example [TUserRolesExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TUserRoles record, @Param("example") TUserRolesExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TUserRoles]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TUserRoles record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TUserRoles]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TUserRoles record);

}