package z_tknight.oa.web.aspect;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import z_tknight.oa.commons.util.JsonUtil;
import z_tknight.oa.commons.util.StringUtil;
import z_tknight.oa.model.entity.OperationLog;
import z_tknight.oa.service.baseService.OperationLogService;
import z_tknight.oa.web.annotation.LogInfo;

/**
 * 日志操作切面类
 * 
 * @author 随心
 *
 */
@Aspect // 声明这是一个切面类
@Order(1) // 设置切面优先级:如果多个切面,可通过优先级控制斜面的执行顺序(数值越小,优先级越高)
@Component // 把LoggerAspect注册成bean,放到IOC容器中
public class LoggerAspect {

	/**
	 * slf4j日志配置
	 */
	private static final Logger _LOG = LoggerFactory.getLogger(LoggerAspect.class);

	/**
	 * 切面切入点表达式
	 */
	private static final String ASPECT_POINTCUT_EXPRESSION = "execution(public * z_tknight.oa.web.*controller.*.*(..))";

	/**
	 * 操作日志服务
	 */
	@Autowired
	private OperationLogService logService = null;

	/**
	 * 定义一个方法用于声明切入点表达式,后面增强方法需要注解引用改方法名
	 */
	@Pointcut(ASPECT_POINTCUT_EXPRESSION)
	public void aspectMethod() {
	};

	/**
	 * 环绕增强
	 * 
	 * <pre>
	 * 记录web层控制器的操作日志信息,及相关异常信息.
	 * </pre>
	 * 
	 * @param joinPoint
	 *            [ProceedingJoinPoint]目标类连接点对象
	 * @throws Throwable
	 */
	@Around("aspectMethod()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		long beginTime = 0;
		long endTime = 0;
		boolean state = true;
		OperationLog log = null;
		try {
			_LOG.debug("==================================================【Begin】");
			log = new OperationLog();
			// 方法起始时间
			beginTime = new Date().getTime();
			log.setBeginTime(new Timestamp(beginTime));
			_LOG.debug("方法起始时间：" + log.getBeginTime().toString());
			Class<?>[] params = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
			// 从上下文中获取request
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			// 请求url
			log.setUrl(request.getRequestURI());
			_LOG.debug("url:" + request.getRequestURI() + "、" + request.getRequestURL());
			// ip
			log.setIp(this.getClientIP(request));
			_LOG.debug("ip：" + request.getRemoteAddr() + "、" + request.getHeader("x-forwarded-for") + "、"
					+ request.getHeader("Proxy-Client-IP") + "、" + request.getHeader("WL-Proxy-Client-IP"));
			// 代理方法信息
			String methodName = joinPoint.getSignature().getName();
			_LOG.debug("方法名：" + methodName);
			// 方法名
			log.setMethodName(methodName);
			_LOG.debug("方法参数：" + params.length);
			_LOG.debug("方法对象：" + joinPoint.getTarget());
			// 操作描述
			LogInfo logAnnotation = joinPoint.getTarget().getClass().getDeclaredMethod(methodName, params)
					.getAnnotation(LogInfo.class);
			log.setOperation(logAnnotation != null ? logAnnotation.value() : "无");
			_LOG.debug("操作描述：" + (logAnnotation != null ? logAnnotation.value() : "无"));
			// 传入参数
			StringBuffer buf = new StringBuffer("");
			for (Object param : joinPoint.getArgs()) {
				String arg = null;
				try {
					arg = JsonUtil.toJson(param);
					_LOG.debug(arg);
				} catch(Exception e) {
					_LOG.debug("参数转换JSON数据失败！" + e.getMessage());
					continue;
				}
				buf.append("/" + arg);
			}
			log.setParams(StringUtil.isNotEmpty(buf.toString()) ? buf.toString() : "无");
			// 执行方法
			result = joinPoint.proceed(joinPoint.getArgs());
			// 异常信息
			log.setException("正常");
		} catch (Throwable e) {
			state = false;
			// 异常信息
			log.setException(e + "");
//			_LOG.debug("异常信息:" + e);
			throw e;
		} finally {
			endTime = new Date().getTime();
			_LOG.debug("方法结束时间：" + new Timestamp(endTime).toString());
			// 执行状态
			log.setState(state);
			_LOG.debug("state：" + state);
			// 操作时间
			log.setOperationTime(endTime - beginTime);
			_LOG.debug("操作时间：" + log.getOperationTime());
			// 保存到数据库
			logService.insertOperationLog(log);
			_LOG.debug("==================================================【End】");
		}
		return result;
	}

	/**
	 * 获取客户端真实ip
	 * @param request [HttpServletRequest]请求头
	 * @return [String]客户端真实ip
	 */
	private String getClientIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(StringUtil.isEmpty(ip) || "unknown".equals(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(StringUtil.isEmpty(ip) || "unknown".equals(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(StringUtil.isEmpty(ip) || "unknown".equals(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
}
