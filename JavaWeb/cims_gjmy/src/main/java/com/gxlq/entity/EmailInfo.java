package com.gxlq.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 邮件信息实体类
 * @author johny
 * 实体类通常要实现 “序列化接口”，这样可以在java对象和字节序列之间进行转换
 */
public class EmailInfo implements Serializable{
	//属性：编号、接收号码、发送时间、邮件地址、内容
	private int id;
	private String receivenumber;
	private Timestamp sendtime;
	private String emailaddress;
	private String content;
	
	//get/set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReceivenumber() {
		return receivenumber;
	}
	public void setReceivenumber(String receivenumber) {
		this.receivenumber = receivenumber;
	}
	public Timestamp getSendtime() {
		return sendtime;
	}
	public void setSendtime(Timestamp sendtime) {
		this.sendtime = sendtime;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	//构造方法
	public EmailInfo(int id, String receivenumber, Timestamp sendtime, String emailaddress, String content) {
		super();
		this.id = id;
		this.receivenumber = receivenumber;
		this.sendtime = sendtime;
		this.emailaddress = emailaddress;
		this.content = content;
	}
	public EmailInfo(String receivenumber, Timestamp sendtime, String emailaddress, String content) {
		super();
		this.receivenumber = receivenumber;
		this.sendtime = sendtime;
		this.emailaddress = emailaddress;
		this.content = content;
	}
	public EmailInfo() {
		super();
	}
	@Override
	public String toString() {
		return "EmailInfo [id=" + id + ", receivenumber=" + receivenumber + ", sendtime=" + sendtime + ", emailaddress="
				+ emailaddress + ", content=" + content + "]";
	}
}
