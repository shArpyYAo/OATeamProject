package z_tknight.oa.model.entity;

import java.util.ArrayList;
import java.util.List;

public class TUserExample {

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
	public TUserExample() {
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
		 * user_name字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		/**
		 * user_name字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		/**
		 * user_name等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_name =", value, "userName");
			return (Criteria) this;
		}

		/**
		 * user_name不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "userName");
			return (Criteria) this;
		}

		/**
		 * user_name大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_name >", value, "userName");
			return (Criteria) this;
		}

		/**
		 * user_name大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "userName");
			return (Criteria) this;
		}

		/**
		 * user_name小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_name <", value, "userName");
			return (Criteria) this;
		}

		/**
		 * user_name小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "userName");
			return (Criteria) this;
		}

		/**
		 * user_name在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_name in", values, "userName");
			return (Criteria) this;
		}

		/**
		 * user_name不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "userName");
			return (Criteria) this;
		}

		/**
		 * user_name在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "userName");
			return (Criteria) this;
		}

		/**
		 * user_name不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "userName");
			return (Criteria) this;
		}
		/**
		 * password字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		/**
		 * password字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		/**
		 * password等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		/**
		 * password不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		/**
		 * password大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		/**
		 * password大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		/**
		 * password小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		/**
		 * password小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		/**
		 * password在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		/**
		 * password不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		/**
		 * password在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		/**
		 * password不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}
		/**
		 * nick_name字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNickNameIsNull() {
			addCriterion("nick_name is null");
			return (Criteria) this;
		}

		/**
		 * nick_name字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNickNameIsNotNull() {
			addCriterion("nick_name is not null");
			return (Criteria) this;
		}

		/**
		 * nick_name等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNickNameEqualTo(String value) {
			addCriterion("nick_name =", value, "nickName");
			return (Criteria) this;
		}

		/**
		 * nick_name不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNickNameNotEqualTo(String value) {
			addCriterion("nick_name <>", value, "nickName");
			return (Criteria) this;
		}

		/**
		 * nick_name大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNickNameGreaterThan(String value) {
			addCriterion("nick_name >", value, "nickName");
			return (Criteria) this;
		}

		/**
		 * nick_name大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNickNameGreaterThanOrEqualTo(String value) {
			addCriterion("nick_name >=", value, "nickName");
			return (Criteria) this;
		}

		/**
		 * nick_name小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNickNameLessThan(String value) {
			addCriterion("nick_name <", value, "nickName");
			return (Criteria) this;
		}

		/**
		 * nick_name小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNickNameLessThanOrEqualTo(String value) {
			addCriterion("nick_name <=", value, "nickName");
			return (Criteria) this;
		}

		/**
		 * nick_name在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNickNameIn(List<String> values) {
			addCriterion("nick_name in", values, "nickName");
			return (Criteria) this;
		}

		/**
		 * nick_name不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNickNameNotIn(List<String> values) {
			addCriterion("nick_name not in", values, "nickName");
			return (Criteria) this;
		}

		/**
		 * nick_name在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNickNameBetween(String value1, String value2) {
			addCriterion("nick_name between", value1, value2, "nickName");
			return (Criteria) this;
		}

		/**
		 * nick_name不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNickNameNotBetween(String value1, String value2) {
			addCriterion("nick_name not between", value1, value2, "nickName");
			return (Criteria) this;
		}
		/**
		 * introduction字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIntroductionIsNull() {
			addCriterion("introduction is null");
			return (Criteria) this;
		}

		/**
		 * introduction字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIntroductionIsNotNull() {
			addCriterion("introduction is not null");
			return (Criteria) this;
		}

		/**
		 * introduction等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIntroductionEqualTo(String value) {
			addCriterion("introduction =", value, "introduction");
			return (Criteria) this;
		}

		/**
		 * introduction不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIntroductionNotEqualTo(String value) {
			addCriterion("introduction <>", value, "introduction");
			return (Criteria) this;
		}

		/**
		 * introduction大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIntroductionGreaterThan(String value) {
			addCriterion("introduction >", value, "introduction");
			return (Criteria) this;
		}

		/**
		 * introduction大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
			addCriterion("introduction >=", value, "introduction");
			return (Criteria) this;
		}

		/**
		 * introduction小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIntroductionLessThan(String value) {
			addCriterion("introduction <", value, "introduction");
			return (Criteria) this;
		}

		/**
		 * introduction小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIntroductionLessThanOrEqualTo(String value) {
			addCriterion("introduction <=", value, "introduction");
			return (Criteria) this;
		}

		/**
		 * introduction在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIntroductionIn(List<String> values) {
			addCriterion("introduction in", values, "introduction");
			return (Criteria) this;
		}

		/**
		 * introduction不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIntroductionNotIn(List<String> values) {
			addCriterion("introduction not in", values, "introduction");
			return (Criteria) this;
		}

		/**
		 * introduction在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIntroductionBetween(String value1, String value2) {
			addCriterion("introduction between", value1, value2, "introduction");
			return (Criteria) this;
		}

		/**
		 * introduction不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIntroductionNotBetween(String value1, String value2) {
			addCriterion("introduction not between", value1, value2, "introduction");
			return (Criteria) this;
		}
		/**
		 * dept_no字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDeptNoIsNull() {
			addCriterion("dept_no is null");
			return (Criteria) this;
		}

		/**
		 * dept_no字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDeptNoIsNotNull() {
			addCriterion("dept_no is not null");
			return (Criteria) this;
		}

		/**
		 * dept_no等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDeptNoEqualTo(Integer value) {
			addCriterion("dept_no =", value, "deptNo");
			return (Criteria) this;
		}

		/**
		 * dept_no不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDeptNoNotEqualTo(Integer value) {
			addCriterion("dept_no <>", value, "deptNo");
			return (Criteria) this;
		}

		/**
		 * dept_no大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDeptNoGreaterThan(Integer value) {
			addCriterion("dept_no >", value, "deptNo");
			return (Criteria) this;
		}

		/**
		 * dept_no大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDeptNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("dept_no >=", value, "deptNo");
			return (Criteria) this;
		}

		/**
		 * dept_no小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDeptNoLessThan(Integer value) {
			addCriterion("dept_no <", value, "deptNo");
			return (Criteria) this;
		}

		/**
		 * dept_no小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDeptNoLessThanOrEqualTo(Integer value) {
			addCriterion("dept_no <=", value, "deptNo");
			return (Criteria) this;
		}

		/**
		 * dept_no在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDeptNoIn(List<Integer> values) {
			addCriterion("dept_no in", values, "deptNo");
			return (Criteria) this;
		}

		/**
		 * dept_no不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDeptNoNotIn(List<Integer> values) {
			addCriterion("dept_no not in", values, "deptNo");
			return (Criteria) this;
		}

		/**
		 * dept_no在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDeptNoBetween(Integer value1, Integer value2) {
			addCriterion("dept_no between", value1, value2, "deptNo");
			return (Criteria) this;
		}

		/**
		 * dept_no不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDeptNoNotBetween(Integer value1, Integer value2) {
			addCriterion("dept_no not between", value1, value2, "deptNo");
			return (Criteria) this;
		}
		/**
		 * back_up字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBackUpIsNull() {
			addCriterion("back_up is null");
			return (Criteria) this;
		}

		/**
		 * back_up字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBackUpIsNotNull() {
			addCriterion("back_up is not null");
			return (Criteria) this;
		}

		/**
		 * back_up等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBackUpEqualTo(Integer value) {
			addCriterion("back_up =", value, "backUp");
			return (Criteria) this;
		}

		/**
		 * back_up不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBackUpNotEqualTo(Integer value) {
			addCriterion("back_up <>", value, "backUp");
			return (Criteria) this;
		}

		/**
		 * back_up大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBackUpGreaterThan(Integer value) {
			addCriterion("back_up >", value, "backUp");
			return (Criteria) this;
		}

		/**
		 * back_up大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBackUpGreaterThanOrEqualTo(Integer value) {
			addCriterion("back_up >=", value, "backUp");
			return (Criteria) this;
		}

		/**
		 * back_up小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBackUpLessThan(Integer value) {
			addCriterion("back_up <", value, "backUp");
			return (Criteria) this;
		}

		/**
		 * back_up小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBackUpLessThanOrEqualTo(Integer value) {
			addCriterion("back_up <=", value, "backUp");
			return (Criteria) this;
		}

		/**
		 * back_up在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBackUpIn(List<Integer> values) {
			addCriterion("back_up in", values, "backUp");
			return (Criteria) this;
		}

		/**
		 * back_up不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBackUpNotIn(List<Integer> values) {
			addCriterion("back_up not in", values, "backUp");
			return (Criteria) this;
		}

		/**
		 * back_up在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBackUpBetween(Integer value1, Integer value2) {
			addCriterion("back_up between", value1, value2, "backUp");
			return (Criteria) this;
		}

		/**
		 * back_up不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBackUpNotBetween(Integer value1, Integer value2) {
			addCriterion("back_up not between", value1, value2, "backUp");
			return (Criteria) this;
		}

	}
}