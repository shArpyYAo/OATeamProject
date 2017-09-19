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
}
