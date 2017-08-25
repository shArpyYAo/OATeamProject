package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TPermission;
import z_tknight.oa.model.entity.TPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPermissionMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TPermissionExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TPermissionExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TPermissionExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TPermissionExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param permissionNo [Integer](主键属性)权限编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("permissionNo") Integer permissionNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TPermission]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TPermission record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TPermission]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TPermission record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TPermissionExample]自定义条件
	 * @return [List<TPermission>]符合自定义条件的数据
	 */
	List<TPermission> selectByExample(TPermissionExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param permissionNo [Integer](主键属性)权限编号
	 * @return [TPermission]查询结果
	 */
	TPermission selectByPrimaryKey(@Param("permissionNo") Integer permissionNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TPermission]数据对象，用于指定修改属性
	 * @param example [TPermissionExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TPermission record, @Param("example") TPermissionExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TPermission]数据对象，用于指定修改属性
	 * @param example [TPermissionExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TPermission record, @Param("example") TPermissionExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TPermission]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TPermission record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TPermission]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TPermission record);

}