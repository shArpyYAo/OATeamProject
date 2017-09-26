package z_tknight.oa.persist.complex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import z_tknight.oa.model.entity.TUser;
import z_tknight.oa.model.vo.CommentDetail;
import z_tknight.oa.model.vo.TagDetail;

/**
 * 卡片和标签复杂SQL操作
 * 
 * @author 随心
 *
 */
public interface CardDetailMapper {

	/**
	 * 通过卡片编号集合获取详细标签对象
	 * @param cards [List<Integer>]卡片编号集合
	 * @return
	 */
	List<TagDetail> selectTagsByCards(@Param("cardNos") List<Integer> cardNos);
	
	/**
	 * 通过卡片编号查询指定卡片的评论详情
	 * @param cardNo [Integer]卡片编号
	 * @return
	 */
	List<CommentDetail> selectCommentsByCardNo(@Param("cardNo") Integer cardNo);
	
	/**
	 * 查询卡片
	 * @param cardNo [Integer]看板编号
	 * @return
	 */
	List<TUser> selectCardMember(@Param("cardNo") Integer cardNo);
	
}
