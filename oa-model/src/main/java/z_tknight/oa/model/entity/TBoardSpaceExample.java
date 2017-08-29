package z_tknight.oa.model.entity;

import java.util.ArrayList;
import java.util.List;

public class TBoardSpaceExample {

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
	public TBoardSpaceExample() {
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
		 * board_space_name字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNameIsNull() {
			addCriterion("board_space_name is null");
			return (Criteria) this;
		}

		/**
		 * board_space_name字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNameIsNotNull() {
			addCriterion("board_space_name is not null");
			return (Criteria) this;
		}

		/**
		 * board_space_name等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNameEqualTo(String value) {
			addCriterion("board_space_name =", value, "boardSpaceName");
			return (Criteria) this;
		}

		/**
		 * board_space_name不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNameNotEqualTo(String value) {
			addCriterion("board_space_name <>", value, "boardSpaceName");
			return (Criteria) this;
		}

		/**
		 * board_space_name大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNameGreaterThan(String value) {
			addCriterion("board_space_name >", value, "boardSpaceName");
			return (Criteria) this;
		}

		/**
		 * board_space_name大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNameGreaterThanOrEqualTo(String value) {
			addCriterion("board_space_name >=", value, "boardSpaceName");
			return (Criteria) this;
		}

		/**
		 * board_space_name小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNameLessThan(String value) {
			addCriterion("board_space_name <", value, "boardSpaceName");
			return (Criteria) this;
		}

		/**
		 * board_space_name小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNameLessThanOrEqualTo(String value) {
			addCriterion("board_space_name <=", value, "boardSpaceName");
			return (Criteria) this;
		}

		/**
		 * board_space_name在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNameIn(List<String> values) {
			addCriterion("board_space_name in", values, "boardSpaceName");
			return (Criteria) this;
		}

		/**
		 * board_space_name不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNameNotIn(List<String> values) {
			addCriterion("board_space_name not in", values, "boardSpaceName");
			return (Criteria) this;
		}

		/**
		 * board_space_name在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNameBetween(String value1, String value2) {
			addCriterion("board_space_name between", value1, value2, "boardSpaceName");
			return (Criteria) this;
		}

		/**
		 * board_space_name不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardSpaceNameNotBetween(String value1, String value2) {
			addCriterion("board_space_name not between", value1, value2, "boardSpaceName");
			return (Criteria) this;
		}
		/**
		 * summary字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andSummaryIsNull() {
			addCriterion("summary is null");
			return (Criteria) this;
		}

		/**
		 * summary字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andSummaryIsNotNull() {
			addCriterion("summary is not null");
			return (Criteria) this;
		}

		/**
		 * summary等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andSummaryEqualTo(String value) {
			addCriterion("summary =", value, "summary");
			return (Criteria) this;
		}

		/**
		 * summary不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andSummaryNotEqualTo(String value) {
			addCriterion("summary <>", value, "summary");
			return (Criteria) this;
		}

		/**
		 * summary大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andSummaryGreaterThan(String value) {
			addCriterion("summary >", value, "summary");
			return (Criteria) this;
		}

		/**
		 * summary大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andSummaryGreaterThanOrEqualTo(String value) {
			addCriterion("summary >=", value, "summary");
			return (Criteria) this;
		}

		/**
		 * summary小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andSummaryLessThan(String value) {
			addCriterion("summary <", value, "summary");
			return (Criteria) this;
		}

		/**
		 * summary小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andSummaryLessThanOrEqualTo(String value) {
			addCriterion("summary <=", value, "summary");
			return (Criteria) this;
		}

		/**
		 * summary在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andSummaryIn(List<String> values) {
			addCriterion("summary in", values, "summary");
			return (Criteria) this;
		}

		/**
		 * summary不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andSummaryNotIn(List<String> values) {
			addCriterion("summary not in", values, "summary");
			return (Criteria) this;
		}

		/**
		 * summary在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andSummaryBetween(String value1, String value2) {
			addCriterion("summary between", value1, value2, "summary");
			return (Criteria) this;
		}

		/**
		 * summary不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andSummaryNotBetween(String value1, String value2) {
			addCriterion("summary not between", value1, value2, "summary");
			return (Criteria) this;
		}
		/**
		 * category_no字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCategoryNoIsNull() {
			addCriterion("category_no is null");
			return (Criteria) this;
		}

		/**
		 * category_no字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCategoryNoIsNotNull() {
			addCriterion("category_no is not null");
			return (Criteria) this;
		}

		/**
		 * category_no等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCategoryNoEqualTo(Integer value) {
			addCriterion("category_no =", value, "categoryNo");
			return (Criteria) this;
		}

		/**
		 * category_no不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCategoryNoNotEqualTo(Integer value) {
			addCriterion("category_no <>", value, "categoryNo");
			return (Criteria) this;
		}

		/**
		 * category_no大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCategoryNoGreaterThan(Integer value) {
			addCriterion("category_no >", value, "categoryNo");
			return (Criteria) this;
		}

		/**
		 * category_no大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCategoryNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("category_no >=", value, "categoryNo");
			return (Criteria) this;
		}

		/**
		 * category_no小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCategoryNoLessThan(Integer value) {
			addCriterion("category_no <", value, "categoryNo");
			return (Criteria) this;
		}

		/**
		 * category_no小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCategoryNoLessThanOrEqualTo(Integer value) {
			addCriterion("category_no <=", value, "categoryNo");
			return (Criteria) this;
		}

		/**
		 * category_no在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCategoryNoIn(List<Integer> values) {
			addCriterion("category_no in", values, "categoryNo");
			return (Criteria) this;
		}

		/**
		 * category_no不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCategoryNoNotIn(List<Integer> values) {
			addCriterion("category_no not in", values, "categoryNo");
			return (Criteria) this;
		}

		/**
		 * category_no在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCategoryNoBetween(Integer value1, Integer value2) {
			addCriterion("category_no between", value1, value2, "categoryNo");
			return (Criteria) this;
		}

		/**
		 * category_no不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCategoryNoNotBetween(Integer value1, Integer value2) {
			addCriterion("category_no not between", value1, value2, "categoryNo");
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
		 * company_no字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCompanyNoIsNull() {
			addCriterion("company_no is null");
			return (Criteria) this;
		}

		/**
		 * company_no字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCompanyNoIsNotNull() {
			addCriterion("company_no is not null");
			return (Criteria) this;
		}

		/**
		 * company_no等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCompanyNoEqualTo(Integer value) {
			addCriterion("company_no =", value, "companyNo");
			return (Criteria) this;
		}

		/**
		 * company_no不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCompanyNoNotEqualTo(Integer value) {
			addCriterion("company_no <>", value, "companyNo");
			return (Criteria) this;
		}

		/**
		 * company_no大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCompanyNoGreaterThan(Integer value) {
			addCriterion("company_no >", value, "companyNo");
			return (Criteria) this;
		}

		/**
		 * company_no大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCompanyNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("company_no >=", value, "companyNo");
			return (Criteria) this;
		}

		/**
		 * company_no小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCompanyNoLessThan(Integer value) {
			addCriterion("company_no <", value, "companyNo");
			return (Criteria) this;
		}

		/**
		 * company_no小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCompanyNoLessThanOrEqualTo(Integer value) {
			addCriterion("company_no <=", value, "companyNo");
			return (Criteria) this;
		}

		/**
		 * company_no在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCompanyNoIn(List<Integer> values) {
			addCriterion("company_no in", values, "companyNo");
			return (Criteria) this;
		}

		/**
		 * company_no不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCompanyNoNotIn(List<Integer> values) {
			addCriterion("company_no not in", values, "companyNo");
			return (Criteria) this;
		}

		/**
		 * company_no在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCompanyNoBetween(Integer value1, Integer value2) {
			addCriterion("company_no between", value1, value2, "companyNo");
			return (Criteria) this;
		}

		/**
		 * company_no不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCompanyNoNotBetween(Integer value1, Integer value2) {
			addCriterion("company_no not between", value1, value2, "companyNo");
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

	}
}