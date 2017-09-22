package z_tknight.oa.service.baseService;

import z_tknight.oa.commons.util.ResponeResult;

public interface CardService {

	public ResponeResult selectCardInfoByCardNo(Integer userNo, Integer cardNo);
	public ResponeResult addCard(String cardName, Integer userNo, Integer listNo);
	public ResponeResult deleteCard(Integer cardNo, Integer userNo);
	public ResponeResult updateCardInfo(Integer userNo, String newCardName, 
			Double workLoad, Long endTime, Integer cardNo);
	public ResponeResult updateCardOrder(Integer cardNo, Integer listNoFrom, 
			Integer listNoTo, String cardOrderFrom, String cardOrderTo, 
			String newcardOrderFrom, String newcardOrderTo, Integer userNo);
	
	/**
	 * 添加卡片用户
	 * @param userNo [Integer]发起操作用户编号
	 * @param targetUserNo [Integer]待添加用户编号
	 * @param cardNo [Integer]卡片编号
	 * @return
	 */
	public ResponeResult addUser(Integer userNo, Integer targetUserNo, Integer cardNo);

	/**
	 * 删除卡片用户
	 * @param userNo [Integer]发起操作用户编号
	 * @param targetUserNo [Integer]待删除用户编号
	 * @param cardNo [Integer]卡片编号
	 * @return
	 */
	public ResponeResult deleteUser(Integer userNo, Integer targetUserNo, Integer cardNo);
	
}
