package z_tknight.oa.model.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OperationLogExample {

	/**
	 * 排序从句
	 */
	protected String orderByClause;

	/**
	 * 是否使用distinct查询（去重查询）
	 */
	protected boolean distinct;

	/**
	 * example中包含多个criteria，
	 * criteria包含多个Criterion条件，条件中的内容是以and的形式加到where上的，
	 * criteria与criteria之间是以or的形式添加到where中的。
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * 构造方法，初始化criteria条件列表。
	 */
	public OperationLogExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
 		return oredCriteria;
	}

	/**
	 * or形式在条件语句criteria列表中拼接一个新的criteria。
	 * @param criteria [Criteria]自定义的条件
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * or形式在条件语句criteria列表中创建一个新的criteria，并返回。
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 创建一个条件语句criteria，
	 * 如果criteria列表中没有元素，则返回根节点。
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * 创建一个条件语句criteria（内部方法）。
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 清空criteria列表中。
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	 /**
	 * 每个crteria中都有一个criterion列表，子条件列表，用and语句相互连接。
	 */
	public static class Criterion {

		 /**
		 * 条件关键字，例如：>=、<=等等
		 */
		private String condition;

		/**
		 * 条件语句会用到的值1
		 */
		private Object value;

		/**
		 * 条件语句会用到的值2
		 */
		private Object secondValue;

		/**
		 * 条件关键字没有值，例如：not null、 null
		 */
		private boolean noValue;

		/**
		 * 条件关键字有且只有一个值，例如：>= 1、<= 1
		 */
		private boolean singleValue;

		/**
		 * 条件关键字有且只有两个值，例如：between 1 and 2
		 */
		private boolean betweenValue;

		/**
		 * 条件关键字有且只有一个列表的值，例如：in(1、2、3、4)
		 */
		private boolean listValue;

		/**
		 * 该条件针对的字段名
		 */
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		/**
		 * 无参数条件构造方法
		 * @param condition [String]条件关键字
		 */
		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		/**
		 * 单值参数或列表参数构造方法
		 * @param condition [String]条件关键字
		 * @param value [Object]条件语句会用到的值1
		 * @param typeHeader [String]该条件针对的字段名
		 */
		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		/**
		 * 单值参数或列表参数构造方法（不指定所属字段）
		 * @param condition [String]条件关键字
		 * @param value [Object]条件语句会用到的值1
		 */
		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		/**
		 * 双参数构造方法
		 * @param condition [String]条件关键字
		 * @param value [Object]条件语句会用到的值1
		 * @param secondValue [Object]条件语句会用到的值2
		 * @param typeHeader [String]该条件针对的字段名
		 */
		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		/**
		 * 双参数构造方法（不指定所属字段）
		 * @param condition [String]条件关键字
		 * @param value [Object]条件语句会用到的值1
		 * @param secondValue [Object]条件语句会用到的值2
		 */
		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
	 * criteria条件类，父类GeneratedCriteria是动态生成的。
	 */
	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	/**
	 * 动态生成的Criteria父类
	 */
	protected abstract static class GeneratedCriteria {

		/**
		 * 条件列表集合
		 */
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		/**
		 * 条件列表集合中是否有值
		 * @return [boolean]true : 有、 false : 没有
		 */
		public boolean isValid() {
			return criteria.size() > 0;
		}

		/**
		 * 获取条件列表集合
		 * @return [List<Criterion>]条件列表集合
		 */
		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		/**
		 * 获取条件列表集合
		 * @return [List<Criterion>]条件列表集合
		 */
		public List<Criterion> getCriteria() {
			return criteria;
		}

		/**
		 * 无参数添加条件
 		 * @param condition [String]条件语句
		 * @exception [RuntimeException]输入条件语句不能为null
		 */
		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		/**
		 * 单参数添加条件
 		 * @param condition [String]条件语句
 		 * @param value [Object]条件语句会用到的值1
 		 * @param property [String]该条件针对的属性名
		 * @exception [RuntimeException]输入条件语句不能为null
		 */
		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		/**
		 * 双参数添加条件
 		 * @param condition [String]条件语句
 		 * @param value [Object]条件语句会用到的值1
 		 * @param value2 [Object]条件语句会用到的值2
 		 * @param property [String]该条件针对的属性名
		 * @exception [RuntimeException]输入条件语句不能为null
		 */
		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}
		
		/**
		 * log_no字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andLogNoIsNull() {
			addCriterion("log_no is null");
			return (Criteria) this;
		}

		/**
		 * log_no字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andLogNoIsNotNull() {
			addCriterion("log_no is not null");
			return (Criteria) this;
		}

		/**
		 * log_no等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andLogNoEqualTo(Integer value) {
			addCriterion("log_no =", value, "logNo");
			return (Criteria) this;
		}

		/**
		 * log_no不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andLogNoNotEqualTo(Integer value) {
			addCriterion("log_no <>", value, "logNo");
			return (Criteria) this;
		}

		/**
		 * log_no大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andLogNoGreaterThan(Integer value) {
			addCriterion("log_no >", value, "logNo");
			return (Criteria) this;
		}

		/**
		 * log_no大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andLogNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("log_no >=", value, "logNo");
			return (Criteria) this;
		}

		/**
		 * log_no小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andLogNoLessThan(Integer value) {
			addCriterion("log_no <", value, "logNo");
			return (Criteria) this;
		}

		/**
		 * log_no小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andLogNoLessThanOrEqualTo(Integer value) {
			addCriterion("log_no <=", value, "logNo");
			return (Criteria) this;
		}

		/**
		 * log_no在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andLogNoIn(List<Integer> values) {
			addCriterion("log_no in", values, "logNo");
			return (Criteria) this;
		}

		/**
		 * log_no不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andLogNoNotIn(List<Integer> values) {
			addCriterion("log_no not in", values, "logNo");
			return (Criteria) this;
		}

		/**
		 * log_no在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andLogNoBetween(Integer value1, Integer value2) {
			addCriterion("log_no between", value1, value2, "logNo");
			return (Criteria) this;
		}

		/**
		 * log_no不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andLogNoNotBetween(Integer value1, Integer value2) {
			addCriterion("log_no not between", value1, value2, "logNo");
			return (Criteria) this;
		}
		/**
		 * user_no字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNoIsNull() {
			addCriterion("user_no is null");
			return (Criteria) this;
		}

		/**
		 * user_no字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNoIsNotNull() {
			addCriterion("user_no is not null");
			return (Criteria) this;
		}

		/**
		 * user_no等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNoEqualTo(Integer value) {
			addCriterion("user_no =", value, "userNo");
			return (Criteria) this;
		}

		/**
		 * user_no不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNoNotEqualTo(Integer value) {
			addCriterion("user_no <>", value, "userNo");
			return (Criteria) this;
		}

		/**
		 * user_no大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNoGreaterThan(Integer value) {
			addCriterion("user_no >", value, "userNo");
			return (Criteria) this;
		}

		/**
		 * user_no大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_no >=", value, "userNo");
			return (Criteria) this;
		}

		/**
		 * user_no小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNoLessThan(Integer value) {
			addCriterion("user_no <", value, "userNo");
			return (Criteria) this;
		}

		/**
		 * user_no小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNoLessThanOrEqualTo(Integer value) {
			addCriterion("user_no <=", value, "userNo");
			return (Criteria) this;
		}

		/**
		 * user_no在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNoIn(List<Integer> values) {
			addCriterion("user_no in", values, "userNo");
			return (Criteria) this;
		}

		/**
		 * user_no不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNoNotIn(List<Integer> values) {
			addCriterion("user_no not in", values, "userNo");
			return (Criteria) this;
		}

		/**
		 * user_no在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNoBetween(Integer value1, Integer value2) {
			addCriterion("user_no between", value1, value2, "userNo");
			return (Criteria) this;
		}

		/**
		 * user_no不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNoNotBetween(Integer value1, Integer value2) {
			addCriterion("user_no not between", value1, value2, "userNo");
			return (Criteria) this;
		}
		/**
		 * operation字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationIsNull() {
			addCriterion("operation is null");
			return (Criteria) this;
		}

		/**
		 * operation字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationIsNotNull() {
			addCriterion("operation is not null");
			return (Criteria) this;
		}

		/**
		 * operation等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationEqualTo(String value) {
			addCriterion("operation =", value, "operation");
			return (Criteria) this;
		}

		/**
		 * operation不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationNotEqualTo(String value) {
			addCriterion("operation <>", value, "operation");
			return (Criteria) this;
		}

		/**
		 * operation大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationGreaterThan(String value) {
			addCriterion("operation >", value, "operation");
			return (Criteria) this;
		}

		/**
		 * operation大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationGreaterThanOrEqualTo(String value) {
			addCriterion("operation >=", value, "operation");
			return (Criteria) this;
		}

		/**
		 * operation小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationLessThan(String value) {
			addCriterion("operation <", value, "operation");
			return (Criteria) this;
		}

		/**
		 * operation小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationLessThanOrEqualTo(String value) {
			addCriterion("operation <=", value, "operation");
			return (Criteria) this;
		}

		/**
		 * operation在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationIn(List<String> values) {
			addCriterion("operation in", values, "operation");
			return (Criteria) this;
		}

		/**
		 * operation不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationNotIn(List<String> values) {
			addCriterion("operation not in", values, "operation");
			return (Criteria) this;
		}

		/**
		 * operation在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationBetween(String value1, String value2) {
			addCriterion("operation between", value1, value2, "operation");
			return (Criteria) this;
		}

		/**
		 * operation不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationNotBetween(String value1, String value2) {
			addCriterion("operation not between", value1, value2, "operation");
			return (Criteria) this;
		}
		/**
		 * exception字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andExceptionIsNull() {
			addCriterion("exception is null");
			return (Criteria) this;
		}

		/**
		 * exception字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andExceptionIsNotNull() {
			addCriterion("exception is not null");
			return (Criteria) this;
		}

		/**
		 * exception等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andExceptionEqualTo(String value) {
			addCriterion("exception =", value, "exception");
			return (Criteria) this;
		}

		/**
		 * exception不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andExceptionNotEqualTo(String value) {
			addCriterion("exception <>", value, "exception");
			return (Criteria) this;
		}

		/**
		 * exception大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andExceptionGreaterThan(String value) {
			addCriterion("exception >", value, "exception");
			return (Criteria) this;
		}

		/**
		 * exception大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andExceptionGreaterThanOrEqualTo(String value) {
			addCriterion("exception >=", value, "exception");
			return (Criteria) this;
		}

		/**
		 * exception小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andExceptionLessThan(String value) {
			addCriterion("exception <", value, "exception");
			return (Criteria) this;
		}

		/**
		 * exception小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andExceptionLessThanOrEqualTo(String value) {
			addCriterion("exception <=", value, "exception");
			return (Criteria) this;
		}

		/**
		 * exception在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andExceptionIn(List<String> values) {
			addCriterion("exception in", values, "exception");
			return (Criteria) this;
		}

		/**
		 * exception不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andExceptionNotIn(List<String> values) {
			addCriterion("exception not in", values, "exception");
			return (Criteria) this;
		}

		/**
		 * exception在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andExceptionBetween(String value1, String value2) {
			addCriterion("exception between", value1, value2, "exception");
			return (Criteria) this;
		}

		/**
		 * exception不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andExceptionNotBetween(String value1, String value2) {
			addCriterion("exception not between", value1, value2, "exception");
			return (Criteria) this;
		}
		/**
		 * params字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andParamsIsNull() {
			addCriterion("params is null");
			return (Criteria) this;
		}

		/**
		 * params字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andParamsIsNotNull() {
			addCriterion("params is not null");
			return (Criteria) this;
		}

		/**
		 * params等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andParamsEqualTo(String value) {
			addCriterion("params =", value, "params");
			return (Criteria) this;
		}

		/**
		 * params不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andParamsNotEqualTo(String value) {
			addCriterion("params <>", value, "params");
			return (Criteria) this;
		}

		/**
		 * params大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andParamsGreaterThan(String value) {
			addCriterion("params >", value, "params");
			return (Criteria) this;
		}

		/**
		 * params大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andParamsGreaterThanOrEqualTo(String value) {
			addCriterion("params >=", value, "params");
			return (Criteria) this;
		}

		/**
		 * params小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andParamsLessThan(String value) {
			addCriterion("params <", value, "params");
			return (Criteria) this;
		}

		/**
		 * params小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andParamsLessThanOrEqualTo(String value) {
			addCriterion("params <=", value, "params");
			return (Criteria) this;
		}

		/**
		 * params在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andParamsIn(List<String> values) {
			addCriterion("params in", values, "params");
			return (Criteria) this;
		}

		/**
		 * params不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andParamsNotIn(List<String> values) {
			addCriterion("params not in", values, "params");
			return (Criteria) this;
		}

		/**
		 * params在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andParamsBetween(String value1, String value2) {
			addCriterion("params between", value1, value2, "params");
			return (Criteria) this;
		}

		/**
		 * params不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andParamsNotBetween(String value1, String value2) {
			addCriterion("params not between", value1, value2, "params");
			return (Criteria) this;
		}
		/**
		 * ip字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIpIsNull() {
			addCriterion("ip is null");
			return (Criteria) this;
		}

		/**
		 * ip字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIpIsNotNull() {
			addCriterion("ip is not null");
			return (Criteria) this;
		}

		/**
		 * ip等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIpEqualTo(String value) {
			addCriterion("ip =", value, "ip");
			return (Criteria) this;
		}

		/**
		 * ip不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIpNotEqualTo(String value) {
			addCriterion("ip <>", value, "ip");
			return (Criteria) this;
		}

		/**
		 * ip大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIpGreaterThan(String value) {
			addCriterion("ip >", value, "ip");
			return (Criteria) this;
		}

		/**
		 * ip大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIpGreaterThanOrEqualTo(String value) {
			addCriterion("ip >=", value, "ip");
			return (Criteria) this;
		}

		/**
		 * ip小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIpLessThan(String value) {
			addCriterion("ip <", value, "ip");
			return (Criteria) this;
		}

		/**
		 * ip小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIpLessThanOrEqualTo(String value) {
			addCriterion("ip <=", value, "ip");
			return (Criteria) this;
		}

		/**
		 * ip在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIpIn(List<String> values) {
			addCriterion("ip in", values, "ip");
			return (Criteria) this;
		}

		/**
		 * ip不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIpNotIn(List<String> values) {
			addCriterion("ip not in", values, "ip");
			return (Criteria) this;
		}

		/**
		 * ip在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIpBetween(String value1, String value2) {
			addCriterion("ip between", value1, value2, "ip");
			return (Criteria) this;
		}

		/**
		 * ip不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIpNotBetween(String value1, String value2) {
			addCriterion("ip not between", value1, value2, "ip");
			return (Criteria) this;
		}
		/**
		 * begin_time字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeginTimeIsNull() {
			addCriterion("begin_time is null");
			return (Criteria) this;
		}

		/**
		 * begin_time字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeginTimeIsNotNull() {
			addCriterion("begin_time is not null");
			return (Criteria) this;
		}

		/**
		 * begin_time等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeginTimeEqualTo(Timestamp value) {
			addCriterion("begin_time =", value, "beginTime");
			return (Criteria) this;
		}

		/**
		 * begin_time不等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeginTimeNotEqualTo(Timestamp value) {
			addCriterion("begin_time <>", value, "beginTime");
			return (Criteria) this;
		}

		/**
		 * begin_time大于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeginTimeGreaterThan(Timestamp value) {
			addCriterion("begin_time >", value, "beginTime");
			return (Criteria) this;
		}

		/**
		 * begin_time大于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeginTimeGreaterThanOrEqualTo(Timestamp value) {
			addCriterion("begin_time >=", value, "beginTime");
			return (Criteria) this;
		}

		/**
		 * begin_time小于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeginTimeLessThan(Timestamp value) {
			addCriterion("begin_time <", value, "beginTime");
			return (Criteria) this;
		}

		/**
		 * begin_time小于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeginTimeLessThanOrEqualTo(Timestamp value) {
			addCriterion("begin_time <=", value, "beginTime");
			return (Criteria) this;
		}

		/**
		 * begin_time在传入值之中
		 * @param value [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeginTimeIn(List<Timestamp> values) {
			addCriterion("begin_time in", values, "beginTime");
			return (Criteria) this;
		}

		/**
		 * begin_time不在传入值之中
		 * @param value [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeginTimeNotIn(List<Timestamp> values) {
			addCriterion("begin_time not in", values, "beginTime");
			return (Criteria) this;
		}

		/**
		 * begin_time在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeginTimeBetween(Timestamp value1, Timestamp value2) {
			addCriterion("begin_time between", value1, value2, "beginTime");
			return (Criteria) this;
		}

		/**
		 * begin_time不在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeginTimeNotBetween(Timestamp value1, Timestamp value2) {
			addCriterion("begin_time not between", value1, value2, "beginTime");
			return (Criteria) this;
		}
		/**
		 * operation_time字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationTimeIsNull() {
			addCriterion("operation_time is null");
			return (Criteria) this;
		}

		/**
		 * operation_time字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationTimeIsNotNull() {
			addCriterion("operation_time is not null");
			return (Criteria) this;
		}

		/**
		 * operation_time等于传入值
		 * @param value [Long]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationTimeEqualTo(Long value) {
			addCriterion("operation_time =", value, "operationTime");
			return (Criteria) this;
		}

		/**
		 * operation_time不等于传入值
		 * @param value [Long]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationTimeNotEqualTo(Long value) {
			addCriterion("operation_time <>", value, "operationTime");
			return (Criteria) this;
		}

		/**
		 * operation_time大于传入值
		 * @param value [Long]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationTimeGreaterThan(Long value) {
			addCriterion("operation_time >", value, "operationTime");
			return (Criteria) this;
		}

		/**
		 * operation_time大于等于传入值
		 * @param value [Long]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationTimeGreaterThanOrEqualTo(Long value) {
			addCriterion("operation_time >=", value, "operationTime");
			return (Criteria) this;
		}

		/**
		 * operation_time小于传入值
		 * @param value [Long]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationTimeLessThan(Long value) {
			addCriterion("operation_time <", value, "operationTime");
			return (Criteria) this;
		}

		/**
		 * operation_time小于等于传入值
		 * @param value [Long]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationTimeLessThanOrEqualTo(Long value) {
			addCriterion("operation_time <=", value, "operationTime");
			return (Criteria) this;
		}

		/**
		 * operation_time在传入值之中
		 * @param value [List<Long>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationTimeIn(List<Long> values) {
			addCriterion("operation_time in", values, "operationTime");
			return (Criteria) this;
		}

		/**
		 * operation_time不在传入值之中
		 * @param value [List<Long>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationTimeNotIn(List<Long> values) {
			addCriterion("operation_time not in", values, "operationTime");
			return (Criteria) this;
		}

		/**
		 * operation_time在传入值之间
		 * @param value1 [Long]传入值1
		 * @param value2 [Long]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationTimeBetween(Long value1, Long value2) {
			addCriterion("operation_time between", value1, value2, "operationTime");
			return (Criteria) this;
		}

		/**
		 * operation_time不在传入值之间
		 * @param value1 [Long]传入值1
		 * @param value2 [Long]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOperationTimeNotBetween(Long value1, Long value2) {
			addCriterion("operation_time not between", value1, value2, "operationTime");
			return (Criteria) this;
		}
		/**
		 * url字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUrlIsNull() {
			addCriterion("url is null");
			return (Criteria) this;
		}

		/**
		 * url字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUrlIsNotNull() {
			addCriterion("url is not null");
			return (Criteria) this;
		}

		/**
		 * url等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUrlEqualTo(String value) {
			addCriterion("url =", value, "url");
			return (Criteria) this;
		}

		/**
		 * url不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUrlNotEqualTo(String value) {
			addCriterion("url <>", value, "url");
			return (Criteria) this;
		}

		/**
		 * url大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUrlGreaterThan(String value) {
			addCriterion("url >", value, "url");
			return (Criteria) this;
		}

		/**
		 * url大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUrlGreaterThanOrEqualTo(String value) {
			addCriterion("url >=", value, "url");
			return (Criteria) this;
		}

		/**
		 * url小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUrlLessThan(String value) {
			addCriterion("url <", value, "url");
			return (Criteria) this;
		}

		/**
		 * url小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUrlLessThanOrEqualTo(String value) {
			addCriterion("url <=", value, "url");
			return (Criteria) this;
		}

		/**
		 * url在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUrlIn(List<String> values) {
			addCriterion("url in", values, "url");
			return (Criteria) this;
		}

		/**
		 * url不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUrlNotIn(List<String> values) {
			addCriterion("url not in", values, "url");
			return (Criteria) this;
		}

		/**
		 * url在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUrlBetween(String value1, String value2) {
			addCriterion("url between", value1, value2, "url");
			return (Criteria) this;
		}

		/**
		 * url不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUrlNotBetween(String value1, String value2) {
			addCriterion("url not between", value1, value2, "url");
			return (Criteria) this;
		}
		/**
		 * state字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStateIsNull() {
			addCriterion("state is null");
			return (Criteria) this;
		}

		/**
		 * state字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStateIsNotNull() {
			addCriterion("state is not null");
			return (Criteria) this;
		}

		/**
		 * state等于传入值
		 * @param value [Boolean]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStateEqualTo(Boolean value) {
			addCriterion("state =", value, "state");
			return (Criteria) this;
		}

		/**
		 * state不等于传入值
		 * @param value [Boolean]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStateNotEqualTo(Boolean value) {
			addCriterion("state <>", value, "state");
			return (Criteria) this;
		}

		/**
		 * state大于传入值
		 * @param value [Boolean]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStateGreaterThan(Boolean value) {
			addCriterion("state >", value, "state");
			return (Criteria) this;
		}

		/**
		 * state大于等于传入值
		 * @param value [Boolean]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStateGreaterThanOrEqualTo(Boolean value) {
			addCriterion("state >=", value, "state");
			return (Criteria) this;
		}

		/**
		 * state小于传入值
		 * @param value [Boolean]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStateLessThan(Boolean value) {
			addCriterion("state <", value, "state");
			return (Criteria) this;
		}

		/**
		 * state小于等于传入值
		 * @param value [Boolean]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStateLessThanOrEqualTo(Boolean value) {
			addCriterion("state <=", value, "state");
			return (Criteria) this;
		}

		/**
		 * state在传入值之中
		 * @param value [List<Boolean>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStateIn(List<Boolean> values) {
			addCriterion("state in", values, "state");
			return (Criteria) this;
		}

		/**
		 * state不在传入值之中
		 * @param value [List<Boolean>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStateNotIn(List<Boolean> values) {
			addCriterion("state not in", values, "state");
			return (Criteria) this;
		}

		/**
		 * state在传入值之间
		 * @param value1 [Boolean]传入值1
		 * @param value2 [Boolean]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStateBetween(Boolean value1, Boolean value2) {
			addCriterion("state between", value1, value2, "state");
			return (Criteria) this;
		}

		/**
		 * state不在传入值之间
		 * @param value1 [Boolean]传入值1
		 * @param value2 [Boolean]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStateNotBetween(Boolean value1, Boolean value2) {
			addCriterion("state not between", value1, value2, "state");
			return (Criteria) this;
		}
		/**
		 * method_name字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andMethodNameIsNull() {
			addCriterion("method_name is null");
			return (Criteria) this;
		}

		/**
		 * method_name字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andMethodNameIsNotNull() {
			addCriterion("method_name is not null");
			return (Criteria) this;
		}

		/**
		 * method_name等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andMethodNameEqualTo(String value) {
			addCriterion("method_name =", value, "methodName");
			return (Criteria) this;
		}

		/**
		 * method_name不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andMethodNameNotEqualTo(String value) {
			addCriterion("method_name <>", value, "methodName");
			return (Criteria) this;
		}

		/**
		 * method_name大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andMethodNameGreaterThan(String value) {
			addCriterion("method_name >", value, "methodName");
			return (Criteria) this;
		}

		/**
		 * method_name大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andMethodNameGreaterThanOrEqualTo(String value) {
			addCriterion("method_name >=", value, "methodName");
			return (Criteria) this;
		}

		/**
		 * method_name小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andMethodNameLessThan(String value) {
			addCriterion("method_name <", value, "methodName");
			return (Criteria) this;
		}

		/**
		 * method_name小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andMethodNameLessThanOrEqualTo(String value) {
			addCriterion("method_name <=", value, "methodName");
			return (Criteria) this;
		}

		/**
		 * method_name在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andMethodNameIn(List<String> values) {
			addCriterion("method_name in", values, "methodName");
			return (Criteria) this;
		}

		/**
		 * method_name不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andMethodNameNotIn(List<String> values) {
			addCriterion("method_name not in", values, "methodName");
			return (Criteria) this;
		}

		/**
		 * method_name在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andMethodNameBetween(String value1, String value2) {
			addCriterion("method_name between", value1, value2, "methodName");
			return (Criteria) this;
		}

		/**
		 * method_name不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andMethodNameNotBetween(String value1, String value2) {
			addCriterion("method_name not between", value1, value2, "methodName");
			return (Criteria) this;
		}

	}
}