package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TDepartment;
import z_tknight.oa.model.entity.TDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDepartmentMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TDepartmentExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TDepartmentExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TDepartmentExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TDepartmentExample example);

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
	 * @param record [TDepartment]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TDepartment record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TDepartment]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TDepartment record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TDepartmentExample]自定义条件
	 * @return [List<TDepartment>]符合自定义条件的数据
	 */
	List<TDepartment> selectByExample(TDepartmentExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param deptNo [Integer](主键属性)部门编号
	 * @return [TDepartment]查询结果
	 */
	TDepartment selectByPrimaryKey(@Param("deptNo") Integer deptNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TDepartment]数据对象，用于指定修改属性
	 * @param example [TDepartmentExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TDepartment record, @Param("example") TDepartmentExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TDepartment]数据对象，用于指定修改属性
	 * @param example [TDepartmentExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TDepartment record, @Param("example") TDepartmentExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TDepartment]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TDepartment record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TDepartment]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TDepartment record);

}