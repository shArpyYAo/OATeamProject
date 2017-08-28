package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.Department;
import z_tknight.oa.model.entity.DepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [DepartmentExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(DepartmentExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [DepartmentExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(DepartmentExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param deptNo [Integer](主键属性)部门编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("deptNo") Integer deptNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [Department]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(Department record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [Department]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(Department record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [DepartmentExample]自定义条件
	 * @return [List<Department>]符合自定义条件的数据
	 */
	List<Department> selectByExample(DepartmentExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param deptNo [Integer](主键属性)部门编号
	 * @return [Department]查询结果
	 */
	Department selectByPrimaryKey(@Param("deptNo") Integer deptNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [Department]数据对象，用于指定修改属性
	 * @param example [DepartmentExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [Department]数据对象，用于指定修改属性
	 * @param example [DepartmentExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [Department]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(Department record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [Department]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(Department record);

}