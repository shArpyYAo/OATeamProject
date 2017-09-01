package z_tknight.oa.service.baseService;

import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.model.entity.TUser;

public interface UserService {

	public ResponeResult userLogin(String userName,String password);
	public ResponeResult userCheckEmail(String email);
	public ResponeResult userRegister(TUser user);
}
