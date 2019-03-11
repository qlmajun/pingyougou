package com.pinyougou.entity;

import java.io.Serializable;
import java.util.List;

/****
 * 分页对象封装
 * 
 * @author warrior
 *
 * @param <T>
 */
public class PageResult<T> implements Serializable {

	private static final long serialVersionUID = 4073718344958512825L;

	/** 总记录数 **/
	private long total;

	/** 当前页结果集 **/
	private List<T> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
