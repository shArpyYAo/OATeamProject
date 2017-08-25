package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TRolePermissions;
import z_tknight.oa.model.entity.TRolePermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRolePermissionsMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TRolePermissionsExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TRolePermissionsExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TRolePermissionsExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TRolePermissionsExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param rolePermissionsNo [Integer](主键属性)角色权限关系编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("rolePermissionsNo") Integer rolePermissionsNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TRolePermissions]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TRolePermissions record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TRolePermissions]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TRolePermissions record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TRolePermissionsExample]自定义条件
	 * @return [List<TRolePermissions>]符合自定义条件的数据
	 */
	List<TRolePermissions> selectByExample(TRolePermissionsExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param rolePermissionsNo [Integer](主键属性)角色权限关系编号
	 * @return [TRolePermissions]查询结果
	 */
	TRolePermissions selectByPrimaryKey(@Param("rolePermissionsNo") Integer rolePermissionsNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TRolePermissions]数据对象，用于指定修改属性
	 * @param example [TRolePermissionsExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TRolePermissions record, @Param("example") TRolePermissionsExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TRolePermissions]数据对象，用于指定修改属性
	 * @param example [TRolePermissionsExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TRolePermissions record, @Param("example") TRolePermissionsExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TRolePermissions]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TRolePermissions record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TRolePermissions]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TRolePermissions record);

}