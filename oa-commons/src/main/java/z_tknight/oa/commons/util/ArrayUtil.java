package z_tknight.oa.commons.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组工具类
 * 
 * @author 随心
 *
 */
public final class ArrayUtil {

	/**
	 * 判断数组是否为空
	 * @param objs [Object[]]数组
	 * @return
	 */
	public static boolean isEmpty(Object[] objs) {
		return objs == null || objs.length <= 0;
	}
	
	/**
	 * 判断数组是否非空
	 * @param objs
	 * @return
	 */
	public static boolean isNotEmpty(Object[] objs) {
		return !isEmpty(objs);
	}
	
	/**
	 * 把数组转换成元素为Integer类型的list
	 * @param array [Object[]]待转换数组
	 * @return [List<Integer>]整型列表
	 */
	public static List<Integer> getIntList(Object[] array) {
		if(isNotEmpty(array)) {
			List<Integer> list = new ArrayList<Integer>(array.length);
			for(Object obj : array) {
				list.add(CaseUtil.caseInt(obj));
			}
			return list;
		} else {
			return null;
		}
	}
	
}
