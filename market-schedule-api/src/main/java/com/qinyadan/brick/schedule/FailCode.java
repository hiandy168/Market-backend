package com.qinyadan.brick.schedule;

import java.util.Date;
import java.util.List;

import com.qinyadan.brick.schedule.model.v1.FailDesc;


/*
 * 错误编码的处理
 */
public class FailCode {

	/**系统异常*/
	public static FailDesc SYSTEM_EXCEPTION;
	/**用户ID为空*/
	public static FailDesc USERID_IS_EMPTY;
	/**sql语句为空*/
	public static FailDesc SQLSTR_IS_EMPTY;
	/**业务类型为空*/
	public static FailDesc BUSINESSTYPE_IS_EMPTY;
	/**idList为空*/
	public static FailDesc ID_LIST_IS_EMPTY;
	/**两次相同查询间隔时间太短*/
	public static FailDesc INTERVAL_TIME_CHECK_FAIL;
	/**插入数据失败*/
	public static FailDesc INSERT_RECORD_FAIL;
	/**查询条件为空*/
	public static FailDesc CONDITION_JSON_IS_EMPTY;
	
	static {
		SYSTEM_EXCEPTION = new FailDesc("system", "1235800", "系统异常");
		USERID_IS_EMPTY = new FailDesc("downupload", "1235801", "用户ID为空");
		SQLSTR_IS_EMPTY = new FailDesc("downupload", "1235802", "sql语句为空");
		BUSINESSTYPE_IS_EMPTY = new FailDesc("downupload", "1235803", "业务类型为空");
		ID_LIST_IS_EMPTY = new FailDesc("downupload", "1235804", "id为空");
		INTERVAL_TIME_CHECK_FAIL = new FailDesc("downupload", "1235805", "两次导出时间间隔请保持在seconds以上");
		INSERT_RECORD_FAIL = new FailDesc("downupload", "1235806", "插入数据失败");
		CONDITION_JSON_IS_EMPTY = new FailDesc("downupload", "1235807", "查询条件为空");
	}

	/**
	 * 判断字段是否为空
	 * 
	 * @param field
	 *            需要验证的字段
	 * @return
	 */
	public static boolean isEmpty(String field) {
		if (field == null || field.trim().equals("")) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字段是否不为空
	 * 
	 * @param field
	 * @return
	 */
	public static boolean isNotEmpty(String field) {
		if (field == null || field.trim().equals("")) {
			return false;
		}
		return true;
	}

	/**
	 * 判断字段是否为空
	 * 
	 * @param field
	 *            需要验证的字段
	 * @return
	 */
	public static boolean isEmpty(int field) {
		if (field == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字段是否为空
	 * 
	 * @param field
	 *            需要验证的字段
	 * @return
	 */
	public static boolean isEmpty(long field) {
		if (field == 0l) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字段是不是为空
	 * 
	 * @param field
	 *            需要验证的字段
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List field) {
		if (field == null || field.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字段是不是为空
	 * 
	 * @param field
	 *            需要验证的字段
	 * @return
	 */
	public static boolean isEmpty(Object field) {
		if (field == null) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是不是大于0
	 * 
	 * @param field
	 *            需要验证的字段
	 * @return
	 */
	public static boolean isOver0(int field) {
		if (field <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * 判断是不是大于0
	 * 
	 * @param field
	 *            需要验证的字段
	 * @return
	 */
	public static boolean isOver0(String field) {
		if (PriceUtils.strToInt(field) <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * 判断是否是数字
	 * 
	 * @param field
	 *            需要验证的字段
	 * @return
	 */
	public static boolean isDigital(String field) {
		// 如果是负数,先去掉负号
		if (field.trim().substring(0, 1).equals("-")) {
			field = field.substring(1, field.length());
		}
		// 替换小数点,再模式匹配数字
		if (!field.replace(".", "").matches("\\d*")) {
			return false;
		}
		return true;
	}

	/**
	 * 判断起始日期是否大于结束日期
	 * 
	 * @param startDate
	 *            起始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	public static boolean startDateOverEndDate(String startDate, String endDate) {
		// 将时间字符串 转成 时间类型("yyyy-MM-dd")
		Date start = DateUtils.str2Date(startDate);
		Date end = DateUtils.str2Date(endDate);
		if (start.after(end)) {
			return true;
		}
		return false;
	}
}
