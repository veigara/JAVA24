package com.web.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public MenuExample() {
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

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andMenuIdIsNull() {
            addCriterion("menuId is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menuId is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Integer value) {
            addCriterion("menuId =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("menuId <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Integer value) {
            addCriterion("menuId >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menuId >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Integer value) {
            addCriterion("menuId <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menuId <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Integer> values) {
            addCriterion("menuId in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("menuId not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menuId between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menuId not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menuName is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menuName is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menuName =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menuName <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menuName >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menuName >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menuName <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menuName <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menuName like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menuName not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menuName in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menuName not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menuName between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menuName not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("menuUrl is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("menuUrl is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("menuUrl =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("menuUrl <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("menuUrl >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("menuUrl >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("menuUrl <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("menuUrl <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("menuUrl like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("menuUrl not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("menuUrl in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("menuUrl not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("menuUrl between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("menuUrl not between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuImageIsNull() {
            addCriterion("menuImage is null");
            return (Criteria) this;
        }

        public Criteria andMenuImageIsNotNull() {
            addCriterion("menuImage is not null");
            return (Criteria) this;
        }

        public Criteria andMenuImageEqualTo(String value) {
            addCriterion("menuImage =", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageNotEqualTo(String value) {
            addCriterion("menuImage <>", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageGreaterThan(String value) {
            addCriterion("menuImage >", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageGreaterThanOrEqualTo(String value) {
            addCriterion("menuImage >=", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageLessThan(String value) {
            addCriterion("menuImage <", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageLessThanOrEqualTo(String value) {
            addCriterion("menuImage <=", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageLike(String value) {
            addCriterion("menuImage like", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageNotLike(String value) {
            addCriterion("menuImage not like", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageIn(List<String> values) {
            addCriterion("menuImage in", values, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageNotIn(List<String> values) {
            addCriterion("menuImage not in", values, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageBetween(String value1, String value2) {
            addCriterion("menuImage between", value1, value2, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageNotBetween(String value1, String value2) {
            addCriterion("menuImage not between", value1, value2, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIsNull() {
            addCriterion("menuOrder is null");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIsNotNull() {
            addCriterion("menuOrder is not null");
            return (Criteria) this;
        }

        public Criteria andMenuOrderEqualTo(Integer value) {
            addCriterion("menuOrder =", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotEqualTo(Integer value) {
            addCriterion("menuOrder <>", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderGreaterThan(Integer value) {
            addCriterion("menuOrder >", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("menuOrder >=", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderLessThan(Integer value) {
            addCriterion("menuOrder <", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderLessThanOrEqualTo(Integer value) {
            addCriterion("menuOrder <=", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIn(List<Integer> values) {
            addCriterion("menuOrder in", values, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotIn(List<Integer> values) {
            addCriterion("menuOrder not in", values, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderBetween(Integer value1, Integer value2) {
            addCriterion("menuOrder between", value1, value2, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("menuOrder not between", value1, value2, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuStateIsNull() {
            addCriterion("menuState is null");
            return (Criteria) this;
        }

        public Criteria andMenuStateIsNotNull() {
            addCriterion("menuState is not null");
            return (Criteria) this;
        }

        public Criteria andMenuStateEqualTo(Integer value) {
            addCriterion("menuState =", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateNotEqualTo(Integer value) {
            addCriterion("menuState <>", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateGreaterThan(Integer value) {
            addCriterion("menuState >", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("menuState >=", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateLessThan(Integer value) {
            addCriterion("menuState <", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateLessThanOrEqualTo(Integer value) {
            addCriterion("menuState <=", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateIn(List<Integer> values) {
            addCriterion("menuState in", values, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateNotIn(List<Integer> values) {
            addCriterion("menuState not in", values, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateBetween(Integer value1, Integer value2) {
            addCriterion("menuState between", value1, value2, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateNotBetween(Integer value1, Integer value2) {
            addCriterion("menuState not between", value1, value2, "menuState");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parentId is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parentId is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parentId =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parentId <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parentId >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentId >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parentId <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parentId <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parentId in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parentId not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parentId between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parentId not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andMenuClickIsNull() {
            addCriterion("menuClick is null");
            return (Criteria) this;
        }

        public Criteria andMenuClickIsNotNull() {
            addCriterion("menuClick is not null");
            return (Criteria) this;
        }

        public Criteria andMenuClickEqualTo(Integer value) {
            addCriterion("menuClick =", value, "menuClick");
            return (Criteria) this;
        }

        public Criteria andMenuClickNotEqualTo(Integer value) {
            addCriterion("menuClick <>", value, "menuClick");
            return (Criteria) this;
        }

        public Criteria andMenuClickGreaterThan(Integer value) {
            addCriterion("menuClick >", value, "menuClick");
            return (Criteria) this;
        }

        public Criteria andMenuClickGreaterThanOrEqualTo(Integer value) {
            addCriterion("menuClick >=", value, "menuClick");
            return (Criteria) this;
        }

        public Criteria andMenuClickLessThan(Integer value) {
            addCriterion("menuClick <", value, "menuClick");
            return (Criteria) this;
        }

        public Criteria andMenuClickLessThanOrEqualTo(Integer value) {
            addCriterion("menuClick <=", value, "menuClick");
            return (Criteria) this;
        }

        public Criteria andMenuClickIn(List<Integer> values) {
            addCriterion("menuClick in", values, "menuClick");
            return (Criteria) this;
        }

        public Criteria andMenuClickNotIn(List<Integer> values) {
            addCriterion("menuClick not in", values, "menuClick");
            return (Criteria) this;
        }

        public Criteria andMenuClickBetween(Integer value1, Integer value2) {
            addCriterion("menuClick between", value1, value2, "menuClick");
            return (Criteria) this;
        }

        public Criteria andMenuClickNotBetween(Integer value1, Integer value2) {
            addCriterion("menuClick not between", value1, value2, "menuClick");
            return (Criteria) this;
        }

        public Criteria andMenuTimeIsNull() {
            addCriterion("menuTime is null");
            return (Criteria) this;
        }

        public Criteria andMenuTimeIsNotNull() {
            addCriterion("menuTime is not null");
            return (Criteria) this;
        }

        public Criteria andMenuTimeEqualTo(Date value) {
            addCriterionForJDBCDate("menuTime =", value, "menuTime");
            return (Criteria) this;
        }

        public Criteria andMenuTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("menuTime <>", value, "menuTime");
            return (Criteria) this;
        }

        public Criteria andMenuTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("menuTime >", value, "menuTime");
            return (Criteria) this;
        }

        public Criteria andMenuTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("menuTime >=", value, "menuTime");
            return (Criteria) this;
        }

        public Criteria andMenuTimeLessThan(Date value) {
            addCriterionForJDBCDate("menuTime <", value, "menuTime");
            return (Criteria) this;
        }

        public Criteria andMenuTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("menuTime <=", value, "menuTime");
            return (Criteria) this;
        }

        public Criteria andMenuTimeIn(List<Date> values) {
            addCriterionForJDBCDate("menuTime in", values, "menuTime");
            return (Criteria) this;
        }

        public Criteria andMenuTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("menuTime not in", values, "menuTime");
            return (Criteria) this;
        }

        public Criteria andMenuTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("menuTime between", value1, value2, "menuTime");
            return (Criteria) this;
        }

        public Criteria andMenuTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("menuTime not between", value1, value2, "menuTime");
            return (Criteria) this;
        }

        public Criteria andMenuLevelIsNull() {
            addCriterion("menuLevel is null");
            return (Criteria) this;
        }

        public Criteria andMenuLevelIsNotNull() {
            addCriterion("menuLevel is not null");
            return (Criteria) this;
        }

        public Criteria andMenuLevelEqualTo(Integer value) {
            addCriterion("menuLevel =", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelNotEqualTo(Integer value) {
            addCriterion("menuLevel <>", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelGreaterThan(Integer value) {
            addCriterion("menuLevel >", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("menuLevel >=", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelLessThan(Integer value) {
            addCriterion("menuLevel <", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelLessThanOrEqualTo(Integer value) {
            addCriterion("menuLevel <=", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelIn(List<Integer> values) {
            addCriterion("menuLevel in", values, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelNotIn(List<Integer> values) {
            addCriterion("menuLevel not in", values, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelBetween(Integer value1, Integer value2) {
            addCriterion("menuLevel between", value1, value2, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("menuLevel not between", value1, value2, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenud1IsNull() {
            addCriterion("menud1 is null");
            return (Criteria) this;
        }

        public Criteria andMenud1IsNotNull() {
            addCriterion("menud1 is not null");
            return (Criteria) this;
        }

        public Criteria andMenud1EqualTo(String value) {
            addCriterion("menud1 =", value, "menud1");
            return (Criteria) this;
        }

        public Criteria andMenud1NotEqualTo(String value) {
            addCriterion("menud1 <>", value, "menud1");
            return (Criteria) this;
        }

        public Criteria andMenud1GreaterThan(String value) {
            addCriterion("menud1 >", value, "menud1");
            return (Criteria) this;
        }

        public Criteria andMenud1GreaterThanOrEqualTo(String value) {
            addCriterion("menud1 >=", value, "menud1");
            return (Criteria) this;
        }

        public Criteria andMenud1LessThan(String value) {
            addCriterion("menud1 <", value, "menud1");
            return (Criteria) this;
        }

        public Criteria andMenud1LessThanOrEqualTo(String value) {
            addCriterion("menud1 <=", value, "menud1");
            return (Criteria) this;
        }

        public Criteria andMenud1Like(String value) {
            addCriterion("menud1 like", value, "menud1");
            return (Criteria) this;
        }

        public Criteria andMenud1NotLike(String value) {
            addCriterion("menud1 not like", value, "menud1");
            return (Criteria) this;
        }

        public Criteria andMenud1In(List<String> values) {
            addCriterion("menud1 in", values, "menud1");
            return (Criteria) this;
        }

        public Criteria andMenud1NotIn(List<String> values) {
            addCriterion("menud1 not in", values, "menud1");
            return (Criteria) this;
        }

        public Criteria andMenud1Between(String value1, String value2) {
            addCriterion("menud1 between", value1, value2, "menud1");
            return (Criteria) this;
        }

        public Criteria andMenud1NotBetween(String value1, String value2) {
            addCriterion("menud1 not between", value1, value2, "menud1");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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