package z_tknight.oa.model.entity;

import java.util.ArrayList;
import java.util.List;

public class TBoardOrderExample {

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
	public TBoardOrderExample() {
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
		 * order_no字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOrderNoIsNull() {
			addCriterion("order_no is null");
			return (Criteria) this;
		}

		/**
		 * order_no字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOrderNoIsNotNull() {
			addCriterion("order_no is not null");
			return (Criteria) this;
		}

		/**
		 * order_no等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOrderNoEqualTo(Integer value) {
			addCriterion("order_no =", value, "orderNo");
			return (Criteria) this;
		}

		/**
		 * order_no不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOrderNoNotEqualTo(Integer value) {
			addCriterion("order_no <>", value, "orderNo");
			return (Criteria) this;
		}

		/**
		 * order_no大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOrderNoGreaterThan(Integer value) {
			addCriterion("order_no >", value, "orderNo");
			return (Criteria) this;
		}

		/**
		 * order_no大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOrderNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_no >=", value, "orderNo");
			return (Criteria) this;
		}

		/**
		 * order_no小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOrderNoLessThan(Integer value) {
			addCriterion("order_no <", value, "orderNo");
			return (Criteria) this;
		}

		/**
		 * order_no小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOrderNoLessThanOrEqualTo(Integer value) {
			addCriterion("order_no <=", value, "orderNo");
			return (Criteria) this;
		}

		/**
		 * order_no在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOrderNoIn(List<Integer> values) {
			addCriterion("order_no in", values, "orderNo");
			return (Criteria) this;
		}

		/**
		 * order_no不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOrderNoNotIn(List<Integer> values) {
			addCriterion("order_no not in", values, "orderNo");
			return (Criteria) this;
		}

		/**
		 * order_no在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOrderNoBetween(Integer value1, Integer value2) {
			addCriterion("order_no between", value1, value2, "orderNo");
			return (Criteria) this;
		}

		/**
		 * order_no不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andOrderNoNotBetween(Integer value1, Integer value2) {
			addCriterion("order_no not between", value1, value2, "orderNo");
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
		 * board_order字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardOrderIsNull() {
			addCriterion("board_order is null");
			return (Criteria) this;
		}

		/**
		 * board_order字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardOrderIsNotNull() {
			addCriterion("board_order is not null");
			return (Criteria) this;
		}

		/**
		 * board_order等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardOrderEqualTo(String value) {
			addCriterion("board_order =", value, "boardOrder");
			return (Criteria) this;
		}

		/**
		 * board_order不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardOrderNotEqualTo(String value) {
			addCriterion("board_order <>", value, "boardOrder");
			return (Criteria) this;
		}

		/**
		 * board_order大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardOrderGreaterThan(String value) {
			addCriterion("board_order >", value, "boardOrder");
			return (Criteria) this;
		}

		/**
		 * board_order大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardOrderGreaterThanOrEqualTo(String value) {
			addCriterion("board_order >=", value, "boardOrder");
			return (Criteria) this;
		}

		/**
		 * board_order小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardOrderLessThan(String value) {
			addCriterion("board_order <", value, "boardOrder");
			return (Criteria) this;
		}

		/**
		 * board_order小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardOrderLessThanOrEqualTo(String value) {
			addCriterion("board_order <=", value, "boardOrder");
			return (Criteria) this;
		}

		/**
		 * board_order在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardOrderIn(List<String> values) {
			addCriterion("board_order in", values, "boardOrder");
			return (Criteria) this;
		}

		/**
		 * board_order不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardOrderNotIn(List<String> values) {
			addCriterion("board_order not in", values, "boardOrder");
			return (Criteria) this;
		}

		/**
		 * board_order在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardOrderBetween(String value1, String value2) {
			addCriterion("board_order between", value1, value2, "boardOrder");
			return (Criteria) this;
		}

		/**
		 * board_order不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBoardOrderNotBetween(String value1, String value2) {
			addCriterion("board_order not between", value1, value2, "boardOrder");
			return (Criteria) this;
		}

	}
}