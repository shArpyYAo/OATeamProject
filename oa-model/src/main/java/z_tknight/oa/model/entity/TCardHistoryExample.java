package z_tknight.oa.model.entity;

import java.util.ArrayList;
import java.util.List;

public class TCardHistoryExample {

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
	public TCardHistoryExample() {
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
		 * history_no字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andHistoryNoIsNull() {
			addCriterion("history_no is null");
			return (Criteria) this;
		}

		/**
		 * history_no字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andHistoryNoIsNotNull() {
			addCriterion("history_no is not null");
			return (Criteria) this;
		}

		/**
		 * history_no等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andHistoryNoEqualTo(Integer value) {
			addCriterion("history_no =", value, "historyNo");
			return (Criteria) this;
		}

		/**
		 * history_no不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andHistoryNoNotEqualTo(Integer value) {
			addCriterion("history_no <>", value, "historyNo");
			return (Criteria) this;
		}

		/**
		 * history_no大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andHistoryNoGreaterThan(Integer value) {
			addCriterion("history_no >", value, "historyNo");
			return (Criteria) this;
		}

		/**
		 * history_no大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andHistoryNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("history_no >=", value, "historyNo");
			return (Criteria) this;
		}

		/**
		 * history_no小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andHistoryNoLessThan(Integer value) {
			addCriterion("history_no <", value, "historyNo");
			return (Criteria) this;
		}

		/**
		 * history_no小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andHistoryNoLessThanOrEqualTo(Integer value) {
			addCriterion("history_no <=", value, "historyNo");
			return (Criteria) this;
		}

		/**
		 * history_no在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andHistoryNoIn(List<Integer> values) {
			addCriterion("history_no in", values, "historyNo");
			return (Criteria) this;
		}

		/**
		 * history_no不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andHistoryNoNotIn(List<Integer> values) {
			addCriterion("history_no not in", values, "historyNo");
			return (Criteria) this;
		}

		/**
		 * history_no在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andHistoryNoBetween(Integer value1, Integer value2) {
			addCriterion("history_no between", value1, value2, "historyNo");
			return (Criteria) this;
		}

		/**
		 * history_no不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andHistoryNoNotBetween(Integer value1, Integer value2) {
			addCriterion("history_no not between", value1, value2, "historyNo");
			return (Criteria) this;
		}
		/**
		 * from_user_id字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromUserIdIsNull() {
			addCriterion("from_user_id is null");
			return (Criteria) this;
		}

		/**
		 * from_user_id字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromUserIdIsNotNull() {
			addCriterion("from_user_id is not null");
			return (Criteria) this;
		}

		/**
		 * from_user_id等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromUserIdEqualTo(Integer value) {
			addCriterion("from_user_id =", value, "fromUserId");
			return (Criteria) this;
		}

		/**
		 * from_user_id不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromUserIdNotEqualTo(Integer value) {
			addCriterion("from_user_id <>", value, "fromUserId");
			return (Criteria) this;
		}

		/**
		 * from_user_id大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromUserIdGreaterThan(Integer value) {
			addCriterion("from_user_id >", value, "fromUserId");
			return (Criteria) this;
		}

		/**
		 * from_user_id大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("from_user_id >=", value, "fromUserId");
			return (Criteria) this;
		}

		/**
		 * from_user_id小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromUserIdLessThan(Integer value) {
			addCriterion("from_user_id <", value, "fromUserId");
			return (Criteria) this;
		}

		/**
		 * from_user_id小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("from_user_id <=", value, "fromUserId");
			return (Criteria) this;
		}

		/**
		 * from_user_id在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromUserIdIn(List<Integer> values) {
			addCriterion("from_user_id in", values, "fromUserId");
			return (Criteria) this;
		}

		/**
		 * from_user_id不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromUserIdNotIn(List<Integer> values) {
			addCriterion("from_user_id not in", values, "fromUserId");
			return (Criteria) this;
		}

		/**
		 * from_user_id在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromUserIdBetween(Integer value1, Integer value2) {
			addCriterion("from_user_id between", value1, value2, "fromUserId");
			return (Criteria) this;
		}

		/**
		 * from_user_id不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("from_user_id not between", value1, value2, "fromUserId");
			return (Criteria) this;
		}
		/**
		 * to_user_id字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToUserIdIsNull() {
			addCriterion("to_user_id is null");
			return (Criteria) this;
		}

		/**
		 * to_user_id字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToUserIdIsNotNull() {
			addCriterion("to_user_id is not null");
			return (Criteria) this;
		}

		/**
		 * to_user_id等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToUserIdEqualTo(Integer value) {
			addCriterion("to_user_id =", value, "toUserId");
			return (Criteria) this;
		}

		/**
		 * to_user_id不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToUserIdNotEqualTo(Integer value) {
			addCriterion("to_user_id <>", value, "toUserId");
			return (Criteria) this;
		}

		/**
		 * to_user_id大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToUserIdGreaterThan(Integer value) {
			addCriterion("to_user_id >", value, "toUserId");
			return (Criteria) this;
		}

		/**
		 * to_user_id大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("to_user_id >=", value, "toUserId");
			return (Criteria) this;
		}

		/**
		 * to_user_id小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToUserIdLessThan(Integer value) {
			addCriterion("to_user_id <", value, "toUserId");
			return (Criteria) this;
		}

		/**
		 * to_user_id小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("to_user_id <=", value, "toUserId");
			return (Criteria) this;
		}

		/**
		 * to_user_id在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToUserIdIn(List<Integer> values) {
			addCriterion("to_user_id in", values, "toUserId");
			return (Criteria) this;
		}

		/**
		 * to_user_id不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToUserIdNotIn(List<Integer> values) {
			addCriterion("to_user_id not in", values, "toUserId");
			return (Criteria) this;
		}

		/**
		 * to_user_id在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToUserIdBetween(Integer value1, Integer value2) {
			addCriterion("to_user_id between", value1, value2, "toUserId");
			return (Criteria) this;
		}

		/**
		 * to_user_id不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("to_user_id not between", value1, value2, "toUserId");
			return (Criteria) this;
		}
		/**
		 * from_list_name字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromListNameIsNull() {
			addCriterion("from_list_name is null");
			return (Criteria) this;
		}

		/**
		 * from_list_name字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromListNameIsNotNull() {
			addCriterion("from_list_name is not null");
			return (Criteria) this;
		}

		/**
		 * from_list_name等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromListNameEqualTo(String value) {
			addCriterion("from_list_name =", value, "fromListName");
			return (Criteria) this;
		}

		/**
		 * from_list_name不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromListNameNotEqualTo(String value) {
			addCriterion("from_list_name <>", value, "fromListName");
			return (Criteria) this;
		}

		/**
		 * from_list_name大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromListNameGreaterThan(String value) {
			addCriterion("from_list_name >", value, "fromListName");
			return (Criteria) this;
		}

		/**
		 * from_list_name大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromListNameGreaterThanOrEqualTo(String value) {
			addCriterion("from_list_name >=", value, "fromListName");
			return (Criteria) this;
		}

		/**
		 * from_list_name小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromListNameLessThan(String value) {
			addCriterion("from_list_name <", value, "fromListName");
			return (Criteria) this;
		}

		/**
		 * from_list_name小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromListNameLessThanOrEqualTo(String value) {
			addCriterion("from_list_name <=", value, "fromListName");
			return (Criteria) this;
		}

		/**
		 * from_list_name在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromListNameIn(List<String> values) {
			addCriterion("from_list_name in", values, "fromListName");
			return (Criteria) this;
		}

		/**
		 * from_list_name不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromListNameNotIn(List<String> values) {
			addCriterion("from_list_name not in", values, "fromListName");
			return (Criteria) this;
		}

		/**
		 * from_list_name在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromListNameBetween(String value1, String value2) {
			addCriterion("from_list_name between", value1, value2, "fromListName");
			return (Criteria) this;
		}

		/**
		 * from_list_name不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromListNameNotBetween(String value1, String value2) {
			addCriterion("from_list_name not between", value1, value2, "fromListName");
			return (Criteria) this;
		}
		/**
		 * to_list_name字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToListNameIsNull() {
			addCriterion("to_list_name is null");
			return (Criteria) this;
		}

		/**
		 * to_list_name字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToListNameIsNotNull() {
			addCriterion("to_list_name is not null");
			return (Criteria) this;
		}

		/**
		 * to_list_name等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToListNameEqualTo(String value) {
			addCriterion("to_list_name =", value, "toListName");
			return (Criteria) this;
		}

		/**
		 * to_list_name不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToListNameNotEqualTo(String value) {
			addCriterion("to_list_name <>", value, "toListName");
			return (Criteria) this;
		}

		/**
		 * to_list_name大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToListNameGreaterThan(String value) {
			addCriterion("to_list_name >", value, "toListName");
			return (Criteria) this;
		}

		/**
		 * to_list_name大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToListNameGreaterThanOrEqualTo(String value) {
			addCriterion("to_list_name >=", value, "toListName");
			return (Criteria) this;
		}

		/**
		 * to_list_name小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToListNameLessThan(String value) {
			addCriterion("to_list_name <", value, "toListName");
			return (Criteria) this;
		}

		/**
		 * to_list_name小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToListNameLessThanOrEqualTo(String value) {
			addCriterion("to_list_name <=", value, "toListName");
			return (Criteria) this;
		}

		/**
		 * to_list_name在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToListNameIn(List<String> values) {
			addCriterion("to_list_name in", values, "toListName");
			return (Criteria) this;
		}

		/**
		 * to_list_name不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToListNameNotIn(List<String> values) {
			addCriterion("to_list_name not in", values, "toListName");
			return (Criteria) this;
		}

		/**
		 * to_list_name在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToListNameBetween(String value1, String value2) {
			addCriterion("to_list_name between", value1, value2, "toListName");
			return (Criteria) this;
		}

		/**
		 * to_list_name不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToListNameNotBetween(String value1, String value2) {
			addCriterion("to_list_name not between", value1, value2, "toListName");
			return (Criteria) this;
		}
		/**
		 * from_card_title字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromCardTitleIsNull() {
			addCriterion("from_card_title is null");
			return (Criteria) this;
		}

		/**
		 * from_card_title字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromCardTitleIsNotNull() {
			addCriterion("from_card_title is not null");
			return (Criteria) this;
		}

		/**
		 * from_card_title等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromCardTitleEqualTo(String value) {
			addCriterion("from_card_title =", value, "fromCardTitle");
			return (Criteria) this;
		}

		/**
		 * from_card_title不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromCardTitleNotEqualTo(String value) {
			addCriterion("from_card_title <>", value, "fromCardTitle");
			return (Criteria) this;
		}

		/**
		 * from_card_title大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromCardTitleGreaterThan(String value) {
			addCriterion("from_card_title >", value, "fromCardTitle");
			return (Criteria) this;
		}

		/**
		 * from_card_title大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromCardTitleGreaterThanOrEqualTo(String value) {
			addCriterion("from_card_title >=", value, "fromCardTitle");
			return (Criteria) this;
		}

		/**
		 * from_card_title小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromCardTitleLessThan(String value) {
			addCriterion("from_card_title <", value, "fromCardTitle");
			return (Criteria) this;
		}

		/**
		 * from_card_title小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromCardTitleLessThanOrEqualTo(String value) {
			addCriterion("from_card_title <=", value, "fromCardTitle");
			return (Criteria) this;
		}

		/**
		 * from_card_title在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromCardTitleIn(List<String> values) {
			addCriterion("from_card_title in", values, "fromCardTitle");
			return (Criteria) this;
		}

		/**
		 * from_card_title不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromCardTitleNotIn(List<String> values) {
			addCriterion("from_card_title not in", values, "fromCardTitle");
			return (Criteria) this;
		}

		/**
		 * from_card_title在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromCardTitleBetween(String value1, String value2) {
			addCriterion("from_card_title between", value1, value2, "fromCardTitle");
			return (Criteria) this;
		}

		/**
		 * from_card_title不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFromCardTitleNotBetween(String value1, String value2) {
			addCriterion("from_card_title not between", value1, value2, "fromCardTitle");
			return (Criteria) this;
		}
		/**
		 * to_card_title字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToCardTitleIsNull() {
			addCriterion("to_card_title is null");
			return (Criteria) this;
		}

		/**
		 * to_card_title字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToCardTitleIsNotNull() {
			addCriterion("to_card_title is not null");
			return (Criteria) this;
		}

		/**
		 * to_card_title等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToCardTitleEqualTo(String value) {
			addCriterion("to_card_title =", value, "toCardTitle");
			return (Criteria) this;
		}

		/**
		 * to_card_title不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToCardTitleNotEqualTo(String value) {
			addCriterion("to_card_title <>", value, "toCardTitle");
			return (Criteria) this;
		}

		/**
		 * to_card_title大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToCardTitleGreaterThan(String value) {
			addCriterion("to_card_title >", value, "toCardTitle");
			return (Criteria) this;
		}

		/**
		 * to_card_title大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToCardTitleGreaterThanOrEqualTo(String value) {
			addCriterion("to_card_title >=", value, "toCardTitle");
			return (Criteria) this;
		}

		/**
		 * to_card_title小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToCardTitleLessThan(String value) {
			addCriterion("to_card_title <", value, "toCardTitle");
			return (Criteria) this;
		}

		/**
		 * to_card_title小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToCardTitleLessThanOrEqualTo(String value) {
			addCriterion("to_card_title <=", value, "toCardTitle");
			return (Criteria) this;
		}

		/**
		 * to_card_title在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToCardTitleIn(List<String> values) {
			addCriterion("to_card_title in", values, "toCardTitle");
			return (Criteria) this;
		}

		/**
		 * to_card_title不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToCardTitleNotIn(List<String> values) {
			addCriterion("to_card_title not in", values, "toCardTitle");
			return (Criteria) this;
		}

		/**
		 * to_card_title在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToCardTitleBetween(String value1, String value2) {
			addCriterion("to_card_title between", value1, value2, "toCardTitle");
			return (Criteria) this;
		}

		/**
		 * to_card_title不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andToCardTitleNotBetween(String value1, String value2) {
			addCriterion("to_card_title not between", value1, value2, "toCardTitle");
			return (Criteria) this;
		}
		/**
		 * board_space_no字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNoIsNull() {
			addCriterion("board_space_no is null");
			return (Criteria) this;
		}

		/**
		 * board_space_no字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNoIsNotNull() {
			addCriterion("board_space_no is not null");
			return (Criteria) this;
		}

		/**
		 * board_space_no等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNoEqualTo(Integer value) {
			addCriterion("board_space_no =", value, "boardSpaceNo");
			return (Criteria) this;
		}

		/**
		 * board_space_no不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNoNotEqualTo(Integer value) {
			addCriterion("board_space_no <>", value, "boardSpaceNo");
			return (Criteria) this;
		}

		/**
		 * board_space_no大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNoGreaterThan(Integer value) {
			addCriterion("board_space_no >", value, "boardSpaceNo");
			return (Criteria) this;
		}

		/**
		 * board_space_no大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("board_space_no >=", value, "boardSpaceNo");
			return (Criteria) this;
		}

		/**
		 * board_space_no小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNoLessThan(Integer value) {
			addCriterion("board_space_no <", value, "boardSpaceNo");
			return (Criteria) this;
		}

		/**
		 * board_space_no小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNoLessThanOrEqualTo(Integer value) {
			addCriterion("board_space_no <=", value, "boardSpaceNo");
			return (Criteria) this;
		}

		/**
		 * board_space_no在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNoIn(List<Integer> values) {
			addCriterion("board_space_no in", values, "boardSpaceNo");
			return (Criteria) this;
		}

		/**
		 * board_space_no不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNoNotIn(List<Integer> values) {
			addCriterion("board_space_no not in", values, "boardSpaceNo");
			return (Criteria) this;
		}

		/**
		 * board_space_no在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNoBetween(Integer value1, Integer value2) {
			addCriterion("board_space_no between", value1, value2, "boardSpaceNo");
			return (Criteria) this;
		}

		/**
		 * board_space_no不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNoNotBetween(Integer value1, Integer value2) {
			addCriterion("board_space_no not between", value1, value2, "boardSpaceNo");
			return (Criteria) this;
		}
		/**
		 * board_no字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNoIsNull() {
			addCriterion("board_no is null");
			return (Criteria) this;
		}

		/**
		 * board_no字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNoIsNotNull() {
			addCriterion("board_no is not null");
			return (Criteria) this;
		}

		/**
		 * board_no等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNoEqualTo(Integer value) {
			addCriterion("board_no =", value, "boardNo");
			return (Criteria) this;
		}

		/**
		 * board_no不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNoNotEqualTo(Integer value) {
			addCriterion("board_no <>", value, "boardNo");
			return (Criteria) this;
		}

		/**
		 * board_no大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNoGreaterThan(Integer value) {
			addCriterion("board_no >", value, "boardNo");
			return (Criteria) this;
		}

		/**
		 * board_no大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("board_no >=", value, "boardNo");
			return (Criteria) this;
		}

		/**
		 * board_no小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNoLessThan(Integer value) {
			addCriterion("board_no <", value, "boardNo");
			return (Criteria) this;
		}

		/**
		 * board_no小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNoLessThanOrEqualTo(Integer value) {
			addCriterion("board_no <=", value, "boardNo");
			return (Criteria) this;
		}

		/**
		 * board_no在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNoIn(List<Integer> values) {
			addCriterion("board_no in", values, "boardNo");
			return (Criteria) this;
		}

		/**
		 * board_no不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNoNotIn(List<Integer> values) {
			addCriterion("board_no not in", values, "boardNo");
			return (Criteria) this;
		}

		/**
		 * board_no在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNoBetween(Integer value1, Integer value2) {
			addCriterion("board_no between", value1, value2, "boardNo");
			return (Criteria) this;
		}

		/**
		 * board_no不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNoNotBetween(Integer value1, Integer value2) {
			addCriterion("board_no not between", value1, value2, "boardNo");
			return (Criteria) this;
		}

	}
}