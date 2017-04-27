package com.yy.chen.entities;

import java.util.Date;

public class Employy {
private int id;
private String lastName;
private String email;
private Date createTime;
private Date birthTime;
private Department depart;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
public Date getBirthTime() {
	return birthTime;
}
public void setBirthTime(Date birthTime) {
	this.birthTime = birthTime;
}
public Department getDepart() {
	return depart;
}
public void setDepart(Department depart) {
	this.depart = depart;
}
@Override
public String toString() {
	return "Employy [id=" + id + ", lastName=" + lastName + ", email=" + email
			+ ", createTime=" + createTime + ", birthTime=" + birthTime
			+ ", depart=" + depart + "]";
}

}
