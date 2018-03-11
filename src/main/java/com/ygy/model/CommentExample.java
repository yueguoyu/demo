package com.ygy.model;

import java.util.ArrayList;
import java.util.List;

public class CommentExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    public CommentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCommidIsNull() {
            addCriterion("commId is null");
            return (Criteria) this;
        }

        public Criteria andCommidIsNotNull() {
            addCriterion("commId is not null");
            return (Criteria) this;
        }

        public Criteria andCommidEqualTo(Integer value) {
            addCriterion("commId =", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidNotEqualTo(Integer value) {
            addCriterion("commId <>", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidGreaterThan(Integer value) {
            addCriterion("commId >", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidGreaterThanOrEqualTo(Integer value) {
            addCriterion("commId >=", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidLessThan(Integer value) {
            addCriterion("commId <", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidLessThanOrEqualTo(Integer value) {
            addCriterion("commId <=", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidIn(List<Integer> values) {
            addCriterion("commId in", values, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidNotIn(List<Integer> values) {
            addCriterion("commId not in", values, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidBetween(Integer value1, Integer value2) {
            addCriterion("commId between", value1, value2, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidNotBetween(Integer value1, Integer value2) {
            addCriterion("commId not between", value1, value2, "commid");
            return (Criteria) this;
        }

        public Criteria andEidIsNull() {
            addCriterion("eid is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("eid is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Integer value) {
            addCriterion("eid =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Integer value) {
            addCriterion("eid <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Integer value) {
            addCriterion("eid >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Integer value) {
            addCriterion("eid >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Integer value) {
            addCriterion("eid <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Integer value) {
            addCriterion("eid <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Integer> values) {
            addCriterion("eid in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Integer> values) {
            addCriterion("eid not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Integer value1, Integer value2) {
            addCriterion("eid between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Integer value1, Integer value2) {
            addCriterion("eid not between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andCommnameIsNull() {
            addCriterion("commName is null");
            return (Criteria) this;
        }

        public Criteria andCommnameIsNotNull() {
            addCriterion("commName is not null");
            return (Criteria) this;
        }

        public Criteria andCommnameEqualTo(String value) {
            addCriterion("commName =", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameNotEqualTo(String value) {
            addCriterion("commName <>", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameGreaterThan(String value) {
            addCriterion("commName >", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameGreaterThanOrEqualTo(String value) {
            addCriterion("commName >=", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameLessThan(String value) {
            addCriterion("commName <", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameLessThanOrEqualTo(String value) {
            addCriterion("commName <=", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameLike(String value) {
            addCriterion("commName like", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameNotLike(String value) {
            addCriterion("commName not like", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameIn(List<String> values) {
            addCriterion("commName in", values, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameNotIn(List<String> values) {
            addCriterion("commName not in", values, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameBetween(String value1, String value2) {
            addCriterion("commName between", value1, value2, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameNotBetween(String value1, String value2) {
            addCriterion("commName not between", value1, value2, "commname");
            return (Criteria) this;
        }

        public Criteria andCommtextIsNull() {
            addCriterion("commText is null");
            return (Criteria) this;
        }

        public Criteria andCommtextIsNotNull() {
            addCriterion("commText is not null");
            return (Criteria) this;
        }

        public Criteria andCommtextEqualTo(String value) {
            addCriterion("commText =", value, "commtext");
            return (Criteria) this;
        }

        public Criteria andCommtextNotEqualTo(String value) {
            addCriterion("commText <>", value, "commtext");
            return (Criteria) this;
        }

        public Criteria andCommtextGreaterThan(String value) {
            addCriterion("commText >", value, "commtext");
            return (Criteria) this;
        }

        public Criteria andCommtextGreaterThanOrEqualTo(String value) {
            addCriterion("commText >=", value, "commtext");
            return (Criteria) this;
        }

        public Criteria andCommtextLessThan(String value) {
            addCriterion("commText <", value, "commtext");
            return (Criteria) this;
        }

        public Criteria andCommtextLessThanOrEqualTo(String value) {
            addCriterion("commText <=", value, "commtext");
            return (Criteria) this;
        }

        public Criteria andCommtextLike(String value) {
            addCriterion("commText like", value, "commtext");
            return (Criteria) this;
        }

        public Criteria andCommtextNotLike(String value) {
            addCriterion("commText not like", value, "commtext");
            return (Criteria) this;
        }

        public Criteria andCommtextIn(List<String> values) {
            addCriterion("commText in", values, "commtext");
            return (Criteria) this;
        }

        public Criteria andCommtextNotIn(List<String> values) {
            addCriterion("commText not in", values, "commtext");
            return (Criteria) this;
        }

        public Criteria andCommtextBetween(String value1, String value2) {
            addCriterion("commText between", value1, value2, "commtext");
            return (Criteria) this;
        }

        public Criteria andCommtextNotBetween(String value1, String value2) {
            addCriterion("commText not between", value1, value2, "commtext");
            return (Criteria) this;
        }

        public Criteria andReplyIsNull() {
            addCriterion("reply is null");
            return (Criteria) this;
        }

        public Criteria andReplyIsNotNull() {
            addCriterion("reply is not null");
            return (Criteria) this;
        }

        public Criteria andReplyEqualTo(String value) {
            addCriterion("reply =", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotEqualTo(String value) {
            addCriterion("reply <>", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyGreaterThan(String value) {
            addCriterion("reply >", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyGreaterThanOrEqualTo(String value) {
            addCriterion("reply >=", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyLessThan(String value) {
            addCriterion("reply <", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyLessThanOrEqualTo(String value) {
            addCriterion("reply <=", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyLike(String value) {
            addCriterion("reply like", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotLike(String value) {
            addCriterion("reply not like", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyIn(List<String> values) {
            addCriterion("reply in", values, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotIn(List<String> values) {
            addCriterion("reply not in", values, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyBetween(String value1, String value2) {
            addCriterion("reply between", value1, value2, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotBetween(String value1, String value2) {
            addCriterion("reply not between", value1, value2, "reply");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table comment
     *
     * @mbggenerated do_not_delete_during_merge Thu Feb 01 13:09:43 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table comment
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

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

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

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

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}