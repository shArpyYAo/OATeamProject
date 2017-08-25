package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.OperationLog;
import z_tknight.oa.model.entity.OperationLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationLogMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [OperationLogExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(OperationLogExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [OperationLogExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(OperationLogExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param logNo [Integer](主键属性)操作日志编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("logNo") Integer logNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [OperationLog]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(OperationLog record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [OperationLog]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(OperationLog record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [OperationLogExample]自定义条件
	 * @return [List<OperationLog>]符合自定义条件的数据
	 */
	List<OperationLog> selectByExample(OperationLogExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param logNo [Integer](主键属性)操作日志编号
	 * @return [OperationLog]查询结果
	 */
	OperationLog selectByPrimaryKey(@Param("logNo") Integer logNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [OperationLog]数据对象，用于指定修改属性
	 * @param example [OperationLogExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") OperationLog record, @Param("example") OperationLogExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [OperationLog]数据对象，用于指定修改属性
	 * @param example [OperationLogExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") OperationLog record, @Param("example") OperationLogExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [OperationLog]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(OperationLog record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [OperationLog]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(OperationLog record);

}