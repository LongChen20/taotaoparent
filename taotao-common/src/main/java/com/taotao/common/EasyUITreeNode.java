package com.taotao.common;

import java.io.Serializable;
/**
 * tree 控件的节点的pojo
 * @title EasyUITreeNode.java
 * description
 * company: www.itheima.com
 * @author ljh 
 * @version 1.0
 */
public class EasyUITreeNode implements Serializable {
	/**
	 * 节点的id
	 */
	private Long id;
	/**
	 *
	 */
	private String text;
	/**
	 * 节点名称
	 */
	private String state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
