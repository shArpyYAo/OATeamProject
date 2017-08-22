package z_tknight.oa.service.baseService;

import z_tknight.oa.model.entity.OperationLog;

/**
 * 操作日志服务接口
 * 
 * @author 随心
 *
 */
public interface OperationLogService {

	/**
	 * 新增操作日志
	 * @param log [OperationLog]待新增操作日志对象
	 * @return [boolean]新增成功返回true,否则返回false
	 */
	public boolean insertOperationLog(OperationLog log);
}
