package z_tknight.oa.service.helper;

import z_tknight.oa.commons.util.ResponeResult;

/**
 * 响应结果助手类
 * 
 * @author 随心
 *
 */
public final class ResponseResultHelper {

	/**
	 * 返回状态码403,用户没有权限进行此操作
	 * @param result [ResponeResult]响应结果对象
	 * @return
	 */
	public static ResponeResult forbidden() {
		return ResponeResult.build(403, "当前用户没有权限进行此操作!", null);
	}
	
	/**
	 * 返回状态码400,请求格式错误
	 * @param msg [String]错误信息
	 * @return
	 */
	public static ResponeResult badRequest(String msg) {
		if(msg == null) {
			msg = "请求格式错误";
		}
		return ResponeResult.build(403, msg, null);
	}
	
}
