package z_tknight.oa.service.baseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import z_tknight.oa.model.entity.OperationLog;
import z_tknight.oa.persist.mapper.OperationLogMapper;
import z_tknight.oa.service.baseService.OperationLogService;

/**
 * 操作日志服务实现类
 * 
 * @author 随心
 *
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

	/**
	 * OperationLog表dao接口
	 */
	@Autowired
	private OperationLogMapper logMapper = null;
	
	/**
	 * 新增操作日志
	 * @param log [OperationLog]待新增操作日志对象
	 * @return [boolean]新增成功返回true,否则返回false
	 */
	@Override
	public boolean insertOperationLog(OperationLog log) {
		int result = logMapper.insert(log);
		return result >= 1;
	}

}
