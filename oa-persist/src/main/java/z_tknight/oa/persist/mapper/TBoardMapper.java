package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TBoard;
import z_tknight.oa.model.entity.TBoardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBoardMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TBoardExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TBoardExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TBoardExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TBoardExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param boardNo [Integer](主键属性)看板空间编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("boardNo") Integer boardNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TBoard]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TBoard record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TBoard]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TBoard record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TBoardExample]自定义条件
	 * @return [List<TBoard>]符合自定义条件的数据
	 */
	List<TBoard> selectByExample(TBoardExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param boardNo [Integer](主键属性)看板空间编号
	 * @return [TBoard]查询结果
	 */
	TBoard selectByPrimaryKey(@Param("boardNo") Integer boardNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TBoard]数据对象，用于指定修改属性
	 * @param example [TBoardExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TBoard record, @Param("example") TBoardExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TBoard]数据对象，用于指定修改属性
	 * @param example [TBoardExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TBoard record, @Param("example") TBoardExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TBoard]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TBoard record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TBoard]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TBoard record);

}