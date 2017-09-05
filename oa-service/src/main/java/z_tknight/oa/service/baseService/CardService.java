package z_tknight.oa.service.baseService;

import z_tknight.oa.commons.util.ResponeResult;

public interface CardService {

	public ResponeResult addCard(String cardName, Integer userNo, Integer listNo);
	public ResponeResult deleteCard(Integer cardNo, Integer userNo);
	public ResponeResult updateCardName(Integer userNo, String newCardName, Integer cardNo);
	public ResponeResult updateCardOrder(Integer listNoFrom, Integer listNoTo, String cardOrderFrom, String cardOrderTo, 
			String newcardOrderFrom, String newcardOrderTo, Integer userNo);
}
