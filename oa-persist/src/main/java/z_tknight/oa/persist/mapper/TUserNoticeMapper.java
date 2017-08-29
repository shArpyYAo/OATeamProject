package z_tknight.oa.persist.mapper;

import z_tknight.oa.model.entity.TUserNotice;
import z_tknight.oa.model.entity.TUserNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserNoticeMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TUserNoticeExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TUserNoticeExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TUserNoticeExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TUserNoticeExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param noticeNo [Integer](主键属性)通知记录编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("noticeNo") Integer noticeNo);

	/**
	 * 插入单条数据
	 *
	 * @param record [TUserNotice]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(TUserNotice record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [TUserNotice]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(TUserNotice record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TUserNoticeExample]自定义条件
	 * @return [List<TUserNotice>]符合自定义条件的数据
	 */
	List<TUserNotice> selectByExample(TUserNoticeExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param noticeNo [Integer](主键属性)通知记录编号
	 * @return [TUserNotice]查询结果
	 */
	TUserNotice selectByPrimaryKey(@Param("noticeNo") Integer noticeNo);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [TUserNotice]数据对象，用于指定修改属性
	 * @param example [TUserNoticeExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") TUserNotice record, @Param("example") TUserNoticeExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [TUserNotice]数据对象，用于指定修改属性
	 * @param example [TUserNoticeExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") TUserNotice record, @Param("example") TUserNoticeExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [TUserNotice]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(TUserNotice record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [TUserNotice]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(TUserNotice record);

}