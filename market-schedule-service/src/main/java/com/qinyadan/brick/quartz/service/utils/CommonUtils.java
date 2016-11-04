package com.qinyadan.brick.quartz.service.utils;


public class CommonUtils {
	
	/**
	 * 处理分页数据
	 * @param total   总记录条数
	 * @param curPage 当前第几页
	 * @param perPage 每页多少条记录
	 * @return int[] 
	 * 		       [0]:当前第几页
	 * 			   [1]:每页多少条记录
	 * 		       [2]:一个多少页
	 */
	public static int[] dealPaginate(int total, int curPage, int perPage) {
		int[] result = new int[3];
		/**
         * 如果查询条件没有限制每页多少数量，则默认返回10个
         */
		if (perPage <= 0) {
            perPage = 10;
        }
		/**
         * 如果查询条件没有限制返回第几页数据，则默认返回第一页
         */
		if (curPage <= 0) {
			curPage = 1;
		}
		//每页多少条记录
		int pageCount = 0;
		if (total % perPage == 0) {
            pageCount = (total) / perPage;
        } else {
            pageCount = (total) / perPage + 1;
        }
		result[0] = curPage;
		result[1] = perPage;
		result[2] = pageCount;
		
		return result;
	}
}
