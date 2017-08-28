package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TCompany;
import z_tknight.oa.model.entity.TCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCompanyMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TCompanyExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TCompanyExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TCompanyExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TCompanyExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param companyNo [Integer](主键属性)公司编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("companyNo") Integer companyNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TCompany]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TCompany record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TCompany]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TCompany record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TCompanyExample]自定义条件
	 * @return [List<TCompany>]符合自定义条件的数据
	 */
	List<TCompany> selectByExample(TCompanyExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param companyNo [Integer](主键属性)公司编号
	 * @return [TCompany]查询结果
	 */
	TCompany selectByPrimaryKey(@Param("companyNo") Integer companyNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TCompany]数据对象，用于指定修改属性
	 * @param example [TCompanyExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TCompany record, @Param("example") TCompanyExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TCompany]数据对象，用于指定修改属性
	 * @param example [TCompanyExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TCompany record, @Param("example") TCompanyExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TCompany]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TCompany record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TCompany]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TCompany record);

}