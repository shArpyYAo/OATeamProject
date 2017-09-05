package z_tknight.oa.service.baseService;

import z_tknight.oa.commons.util.ResponeResult;

public interface ListService {

	public ResponeResult addList(Integer userNo, String listName, Integer boardNo);
	public ResponeResult updateListName(Integer userNo, String newListName, Integer listNo);
	public ResponeResult deleteList(Integer listNo, Integer userNo);
	public ResponeResult updateListOrder(String listOrder, String newListOrder, Integer boardNo, Integer userNo);
}
