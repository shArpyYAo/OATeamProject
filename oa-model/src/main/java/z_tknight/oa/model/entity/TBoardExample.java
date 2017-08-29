package z_tknight.oa.model.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TBoardExample {

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
	public TBoardExample() {
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
		/**
		 * board_name字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNameIsNull() {
			addCriterion("board_name is null");
			return (Criteria) this;
		}

		/**
		 * board_name字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNameIsNotNull() {
			addCriterion("board_name is not null");
			return (Criteria) this;
		}

		/**
		 * board_name等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNameEqualTo(String value) {
			addCriterion("board_name =", value, "boardName");
			return (Criteria) this;
		}

		/**
		 * board_name不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNameNotEqualTo(String value) {
			addCriterion("board_name <>", value, "boardName");
			return (Criteria) this;
		}

		/**
		 * board_name大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNameGreaterThan(String value) {
			addCriterion("board_name >", value, "boardName");
			return (Criteria) this;
		}

		/**
		 * board_name大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNameGreaterThanOrEqualTo(String value) {
			addCriterion("board_name >=", value, "boardName");
			return (Criteria) this;
		}

		/**
		 * board_name小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNameLessThan(String value) {
			addCriterion("board_name <", value, "boardName");
			return (Criteria) this;
		}

		/**
		 * board_name小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNameLessThanOrEqualTo(String value) {
			addCriterion("board_name <=", value, "boardName");
			return (Criteria) this;
		}

		/**
		 * board_name在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNameIn(List<String> values) {
			addCriterion("board_name in", values, "boardName");
			return (Criteria) this;
		}

		/**
		 * board_name不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNameNotIn(List<String> values) {
			addCriterion("board_name not in", values, "boardName");
			return (Criteria) this;
		}

		/**
		 * board_name在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNameBetween(String value1, String value2) {
			addCriterion("board_name between", value1, value2, "boardName");
			return (Criteria) this;
		}

		/**
		 * board_name不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardNameNotBetween(String value1, String value2) {
			addCriterion("board_name not between", value1, value2, "boardName");
			return (Criteria) this;
		}
		/**
		 * display_no字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDisplayNoIsNull() {
			addCriterion("display_no is null");
			return (Criteria) this;
		}

		/**
		 * display_no字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDisplayNoIsNotNull() {
			addCriterion("display_no is not null");
			return (Criteria) this;
		}

		/**
		 * display_no等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDisplayNoEqualTo(Integer value) {
			addCriterion("display_no =", value, "displayNo");
			return (Criteria) this;
		}

		/**
		 * display_no不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDisplayNoNotEqualTo(Integer value) {
			addCriterion("display_no <>", value, "displayNo");
			return (Criteria) this;
		}

		/**
		 * display_no大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDisplayNoGreaterThan(Integer value) {
			addCriterion("display_no >", value, "displayNo");
			return (Criteria) this;
		}

		/**
		 * display_no大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDisplayNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("display_no >=", value, "displayNo");
			return (Criteria) this;
		}

		/**
		 * display_no小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDisplayNoLessThan(Integer value) {
			addCriterion("display_no <", value, "displayNo");
			return (Criteria) this;
		}

		/**
		 * display_no小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDisplayNoLessThanOrEqualTo(Integer value) {
			addCriterion("display_no <=", value, "displayNo");
			return (Criteria) this;
		}

		/**
		 * display_no在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDisplayNoIn(List<Integer> values) {
			addCriterion("display_no in", values, "displayNo");
			return (Criteria) this;
		}

		/**
		 * display_no不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDisplayNoNotIn(List<Integer> values) {
			addCriterion("display_no not in", values, "displayNo");
			return (Criteria) this;
		}

		/**
		 * display_no在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDisplayNoBetween(Integer value1, Integer value2) {
			addCriterion("display_no between", value1, value2, "displayNo");
			return (Criteria) this;
		}

		/**
		 * display_no不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDisplayNoNotBetween(Integer value1, Integer value2) {
			addCriterion("display_no not between", value1, value2, "displayNo");
			return (Criteria) this;
		}
		/**
		 * start_time字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStartTimeIsNull() {
			addCriterion("start_time is null");
			return (Criteria) this;
		}

		/**
		 * start_time字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStartTimeIsNotNull() {
			addCriterion("start_time is not null");
			return (Criteria) this;
		}

		/**
		 * start_time等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStartTimeEqualTo(Timestamp value) {
			addCriterion("start_time =", value, "startTime");
			return (Criteria) this;
		}

		/**
		 * start_time不等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStartTimeNotEqualTo(Timestamp value) {
			addCriterion("start_time <>", value, "startTime");
			return (Criteria) this;
		}

		/**
		 * start_time大于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStartTimeGreaterThan(Timestamp value) {
			addCriterion("start_time >", value, "startTime");
			return (Criteria) this;
		}

		/**
		 * start_time大于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStartTimeGreaterThanOrEqualTo(Timestamp value) {
			addCriterion("start_time >=", value, "startTime");
			return (Criteria) this;
		}

		/**
		 * start_time小于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStartTimeLessThan(Timestamp value) {
			addCriterion("start_time <", value, "startTime");
			return (Criteria) this;
		}

		/**
		 * start_time小于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStartTimeLessThanOrEqualTo(Timestamp value) {
			addCriterion("start_time <=", value, "startTime");
			return (Criteria) this;
		}

		/**
		 * start_time在传入值之中
		 * @param value [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStartTimeIn(List<Timestamp> values) {
			addCriterion("start_time in", values, "startTime");
			return (Criteria) this;
		}

		/**
		 * start_time不在传入值之中
		 * @param value [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStartTimeNotIn(List<Timestamp> values) {
			addCriterion("start_time not in", values, "startTime");
			return (Criteria) this;
		}

		/**
		 * start_time在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStartTimeBetween(Timestamp value1, Timestamp value2) {
			addCriterion("start_time between", value1, value2, "startTime");
			return (Criteria) this;
		}

		/**
		 * start_time不在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStartTimeNotBetween(Timestamp value1, Timestamp value2) {
			addCriterion("start_time not between", value1, value2, "startTime");
			return (Criteria) this;
		}
		/**
		 * end_time字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andEndTimeIsNull() {
			addCriterion("end_time is null");
			return (Criteria) this;
		}

		/**
		 * end_time字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andEndTimeIsNotNull() {
			addCriterion("end_time is not null");
			return (Criteria) this;
		}

		/**
		 * end_time等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andEndTimeEqualTo(Timestamp value) {
			addCriterion("end_time =", value, "endTime");
			return (Criteria) this;
		}

		/**
		 * end_time不等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andEndTimeNotEqualTo(Timestamp value) {
			addCriterion("end_time <>", value, "endTime");
			return (Criteria) this;
		}

		/**
		 * end_time大于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andEndTimeGreaterThan(Timestamp value) {
			addCriterion("end_time >", value, "endTime");
			return (Criteria) this;
		}

		/**
		 * end_time大于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andEndTimeGreaterThanOrEqualTo(Timestamp value) {
			addCriterion("end_time >=", value, "endTime");
			return (Criteria) this;
		}

		/**
		 * end_time小于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andEndTimeLessThan(Timestamp value) {
			addCriterion("end_time <", value, "endTime");
			return (Criteria) this;
		}

		/**
		 * end_time小于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andEndTimeLessThanOrEqualTo(Timestamp value) {
			addCriterion("end_time <=", value, "endTime");
			return (Criteria) this;
		}

		/**
		 * end_time在传入值之中
		 * @param value [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andEndTimeIn(List<Timestamp> values) {
			addCriterion("end_time in", values, "endTime");
			return (Criteria) this;
		}

		/**
		 * end_time不在传入值之中
		 * @param value [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andEndTimeNotIn(List<Timestamp> values) {
			addCriterion("end_time not in", values, "endTime");
			return (Criteria) this;
		}

		/**
		 * end_time在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andEndTimeBetween(Timestamp value1, Timestamp value2) {
			addCriterion("end_time between", value1, value2, "endTime");
			return (Criteria) this;
		}

		/**
		 * end_time不在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andEndTimeNotBetween(Timestamp value1, Timestamp value2) {
			addCriterion("end_time not between", value1, value2, "endTime");
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
		 * is_delete字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIsDeleteIsNull() {
			addCriterion("is_delete is null");
			return (Criteria) this;
		}

		/**
		 * is_delete字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIsDeleteIsNotNull() {
			addCriterion("is_delete is not null");
			return (Criteria) this;
		}

		/**
		 * is_delete等于传入值
		 * @param value [Boolean]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIsDeleteEqualTo(Boolean value) {
			addCriterion("is_delete =", value, "isDelete");
			return (Criteria) this;
		}

		/**
		 * is_delete不等于传入值
		 * @param value [Boolean]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIsDeleteNotEqualTo(Boolean value) {
			addCriterion("is_delete <>", value, "isDelete");
			return (Criteria) this;
		}

		/**
		 * is_delete大于传入值
		 * @param value [Boolean]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIsDeleteGreaterThan(Boolean value) {
			addCriterion("is_delete >", value, "isDelete");
			return (Criteria) this;
		}

		/**
		 * is_delete大于等于传入值
		 * @param value [Boolean]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_delete >=", value, "isDelete");
			return (Criteria) this;
		}

		/**
		 * is_delete小于传入值
		 * @param value [Boolean]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIsDeleteLessThan(Boolean value) {
			addCriterion("is_delete <", value, "isDelete");
			return (Criteria) this;
		}

		/**
		 * is_delete小于等于传入值
		 * @param value [Boolean]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
			addCriterion("is_delete <=", value, "isDelete");
			return (Criteria) this;
		}

		/**
		 * is_delete在传入值之中
		 * @param value [List<Boolean>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIsDeleteIn(List<Boolean> values) {
			addCriterion("is_delete in", values, "isDelete");
			return (Criteria) this;
		}

		/**
		 * is_delete不在传入值之中
		 * @param value [List<Boolean>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIsDeleteNotIn(List<Boolean> values) {
			addCriterion("is_delete not in", values, "isDelete");
			return (Criteria) this;
		}

		/**
		 * is_delete在传入值之间
		 * @param value1 [Boolean]传入值1
		 * @param value2 [Boolean]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
			addCriterion("is_delete between", value1, value2, "isDelete");
			return (Criteria) this;
		}

		/**
		 * is_delete不在传入值之间
		 * @param value1 [Boolean]传入值1
		 * @param value2 [Boolean]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_delete not between", value1, value2, "isDelete");
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

	}
}