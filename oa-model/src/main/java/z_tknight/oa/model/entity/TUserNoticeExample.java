package z_tknight.oa.model.entity;

import java.util.ArrayList;
import java.util.List;

public class TUserNoticeExample {

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
	public TUserNoticeExample() {
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
		 * notice_no字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNoticeNoIsNull() {
			addCriterion("notice_no is null");
			return (Criteria) this;
		}

		/**
		 * notice_no字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNoticeNoIsNotNull() {
			addCriterion("notice_no is not null");
			return (Criteria) this;
		}

		/**
		 * notice_no等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNoticeNoEqualTo(Integer value) {
			addCriterion("notice_no =", value, "noticeNo");
			return (Criteria) this;
		}

		/**
		 * notice_no不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNoticeNoNotEqualTo(Integer value) {
			addCriterion("notice_no <>", value, "noticeNo");
			return (Criteria) this;
		}

		/**
		 * notice_no大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNoticeNoGreaterThan(Integer value) {
			addCriterion("notice_no >", value, "noticeNo");
			return (Criteria) this;
		}

		/**
		 * notice_no大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNoticeNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("notice_no >=", value, "noticeNo");
			return (Criteria) this;
		}

		/**
		 * notice_no小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNoticeNoLessThan(Integer value) {
			addCriterion("notice_no <", value, "noticeNo");
			return (Criteria) this;
		}

		/**
		 * notice_no小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNoticeNoLessThanOrEqualTo(Integer value) {
			addCriterion("notice_no <=", value, "noticeNo");
			return (Criteria) this;
		}

		/**
		 * notice_no在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNoticeNoIn(List<Integer> values) {
			addCriterion("notice_no in", values, "noticeNo");
			return (Criteria) this;
		}

		/**
		 * notice_no不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNoticeNoNotIn(List<Integer> values) {
			addCriterion("notice_no not in", values, "noticeNo");
			return (Criteria) this;
		}

		/**
		 * notice_no在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNoticeNoBetween(Integer value1, Integer value2) {
			addCriterion("notice_no between", value1, value2, "noticeNo");
			return (Criteria) this;
		}

		/**
		 * notice_no不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andNoticeNoNotBetween(Integer value1, Integer value2) {
			addCriterion("notice_no not between", value1, value2, "noticeNo");
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
		 * list_name字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andListNameIsNull() {
			addCriterion("list_name is null");
			return (Criteria) this;
		}

		/**
		 * list_name字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andListNameIsNotNull() {
			addCriterion("list_name is not null");
			return (Criteria) this;
		}

		/**
		 * list_name等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andListNameEqualTo(String value) {
			addCriterion("list_name =", value, "listName");
			return (Criteria) this;
		}

		/**
		 * list_name不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andListNameNotEqualTo(String value) {
			addCriterion("list_name <>", value, "listName");
			return (Criteria) this;
		}

		/**
		 * list_name大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andListNameGreaterThan(String value) {
			addCriterion("list_name >", value, "listName");
			return (Criteria) this;
		}

		/**
		 * list_name大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andListNameGreaterThanOrEqualTo(String value) {
			addCriterion("list_name >=", value, "listName");
			return (Criteria) this;
		}

		/**
		 * list_name小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andListNameLessThan(String value) {
			addCriterion("list_name <", value, "listName");
			return (Criteria) this;
		}

		/**
		 * list_name小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andListNameLessThanOrEqualTo(String value) {
			addCriterion("list_name <=", value, "listName");
			return (Criteria) this;
		}

		/**
		 * list_name在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andListNameIn(List<String> values) {
			addCriterion("list_name in", values, "listName");
			return (Criteria) this;
		}

		/**
		 * list_name不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andListNameNotIn(List<String> values) {
			addCriterion("list_name not in", values, "listName");
			return (Criteria) this;
		}

		/**
		 * list_name在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andListNameBetween(String value1, String value2) {
			addCriterion("list_name between", value1, value2, "listName");
			return (Criteria) this;
		}

		/**
		 * list_name不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andListNameNotBetween(String value1, String value2) {
			addCriterion("list_name not between", value1, value2, "listName");
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
		 * card_no字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardNoIsNull() {
			addCriterion("card_no is null");
			return (Criteria) this;
		}

		/**
		 * card_no字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardNoIsNotNull() {
			addCriterion("card_no is not null");
			return (Criteria) this;
		}

		/**
		 * card_no等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardNoEqualTo(Integer value) {
			addCriterion("card_no =", value, "cardNo");
			return (Criteria) this;
		}

		/**
		 * card_no不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardNoNotEqualTo(Integer value) {
			addCriterion("card_no <>", value, "cardNo");
			return (Criteria) this;
		}

		/**
		 * card_no大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardNoGreaterThan(Integer value) {
			addCriterion("card_no >", value, "cardNo");
			return (Criteria) this;
		}

		/**
		 * card_no大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("card_no >=", value, "cardNo");
			return (Criteria) this;
		}

		/**
		 * card_no小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardNoLessThan(Integer value) {
			addCriterion("card_no <", value, "cardNo");
			return (Criteria) this;
		}

		/**
		 * card_no小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardNoLessThanOrEqualTo(Integer value) {
			addCriterion("card_no <=", value, "cardNo");
			return (Criteria) this;
		}

		/**
		 * card_no在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardNoIn(List<Integer> values) {
			addCriterion("card_no in", values, "cardNo");
			return (Criteria) this;
		}

		/**
		 * card_no不在传入值之中
		 * @param value [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardNoNotIn(List<Integer> values) {
			addCriterion("card_no not in", values, "cardNo");
			return (Criteria) this;
		}

		/**
		 * card_no在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardNoBetween(Integer value1, Integer value2) {
			addCriterion("card_no between", value1, value2, "cardNo");
			return (Criteria) this;
		}

		/**
		 * card_no不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardNoNotBetween(Integer value1, Integer value2) {
			addCriterion("card_no not between", value1, value2, "cardNo");
			return (Criteria) this;
		}
		/**
		 * card_title字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardTitleIsNull() {
			addCriterion("card_title is null");
			return (Criteria) this;
		}

		/**
		 * card_title字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardTitleIsNotNull() {
			addCriterion("card_title is not null");
			return (Criteria) this;
		}

		/**
		 * card_title等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardTitleEqualTo(String value) {
			addCriterion("card_title =", value, "cardTitle");
			return (Criteria) this;
		}

		/**
		 * card_title不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardTitleNotEqualTo(String value) {
			addCriterion("card_title <>", value, "cardTitle");
			return (Criteria) this;
		}

		/**
		 * card_title大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardTitleGreaterThan(String value) {
			addCriterion("card_title >", value, "cardTitle");
			return (Criteria) this;
		}

		/**
		 * card_title大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardTitleGreaterThanOrEqualTo(String value) {
			addCriterion("card_title >=", value, "cardTitle");
			return (Criteria) this;
		}

		/**
		 * card_title小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardTitleLessThan(String value) {
			addCriterion("card_title <", value, "cardTitle");
			return (Criteria) this;
		}

		/**
		 * card_title小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardTitleLessThanOrEqualTo(String value) {
			addCriterion("card_title <=", value, "cardTitle");
			return (Criteria) this;
		}

		/**
		 * card_title在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardTitleIn(List<String> values) {
			addCriterion("card_title in", values, "cardTitle");
			return (Criteria) this;
		}

		/**
		 * card_title不在传入值之中
		 * @param value [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardTitleNotIn(List<String> values) {
			addCriterion("card_title not in", values, "cardTitle");
			return (Criteria) this;
		}

		/**
		 * card_title在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardTitleBetween(String value1, String value2) {
			addCriterion("card_title between", value1, value2, "cardTitle");
			return (Criteria) this;
		}

		/**
		 * card_title不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCardTitleNotBetween(String value1, String value2) {
			addCriterion("card_title not between", value1, value2, "cardTitle");
			return (Criteria) this;
		}

	}
}