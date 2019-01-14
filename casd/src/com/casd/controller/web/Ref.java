package com.casd.controller.web;


/**
 * 分页基类
 * */

public class Ref<T extends Object> extends Object {
	private T obj;

	public T getValue() {
		return obj;
	}

	public void setValue(T obj) {
		this.obj = obj;
	}

	@Override
	public java.lang.String toString() {
		if (null != this.obj )
			return this.obj.toString();
		return null;
	}
	}
