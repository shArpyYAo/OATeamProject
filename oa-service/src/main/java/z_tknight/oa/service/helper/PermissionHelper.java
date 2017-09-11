package z_tknight.oa.service.helper;

/**
 * 操作权限许可认证助手类
 * 
 * @author 随心
 *
 */
public final class PermissionHelper {

	/**
	 * 判断用户是否有权限查询看板详细内容
	 * @param userNo [Integer]用户编号
	 * @param boardNo [Integer]看板空间编号
	 * @return [boolean]有权限操作返回true,无权限操作返回false
	 */
	public static boolean canSelectBoard(Integer userNo, Integer boardNo) {
		// TODO
		return true;
	}
}
