package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TRole;
import z_tknight.oa.model.entity.TRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TRoleExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TRoleExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TRoleExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TRoleExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param roleNo [Integer](主键属性)角色编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("roleNo") Integer roleNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TRole]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TRole record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TRole]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TRole record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TRoleExample]自定义条件
	 * @return [List<TRole>]符合自定义条件的数据
	 */
	List<TRole> selectByExample(TRoleExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param roleNo [Integer](主键属性)角色编号
	 * @return [TRole]查询结果
	 */
	TRole selectByPrimaryKey(@Param("roleNo") Integer roleNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TRole]数据对象，用于指定修改属性
	 * @param example [TRoleExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TRole]数据对象，用于指定修改属性
	 * @param example [TRoleExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TRole record, @Param("example") TRoleExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TRole]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TRole record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TRole]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TRole record);

}