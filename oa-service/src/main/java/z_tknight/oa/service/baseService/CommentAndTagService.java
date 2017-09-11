package z_tknight.oa.service.baseService;

import z_tknight.oa.commons.util.ResponeResult;

public interface CommentAndTagService {

	public ResponeResult addComment(Integer userNo, Integer cardNo, String comment);
	public ResponeResult deleteComment(Integer userNo, Integer cardNo, Integer commentNo);
	public ResponeResult cardAddTag(Integer userNo, Integer cardNo, Integer tagNo, String tagName);
	public ResponeResult cardDeleteTag(Integer userNo, Integer cardNo, Integer tagNo);
	//public ResponeResult cardAddUser()
}
