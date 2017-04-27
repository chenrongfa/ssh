package com.yy.chen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.web.context.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yy.chen.dao.DepartmentDAO;
import com.yy.chen.dao.EmployyDAO;
import com.yy.chen.entities.Department;
import com.yy.chen.entities.Employy;

public class DpartmnetAction extends ActionSupport implements RequestAware{

	/**
	 * 
	 */
	private DepartmentDAO employyDAO;
	private int id;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setEmployyDAO(DepartmentDAO employyDAO) {
		this.employyDAO = employyDAO;
	}


	private Map<String, Object> request;
	private static final long serialVersionUID = 1L;

	
	public String findAll(){
		List<Department> findAll = employyDAO.findAll();
		if(findAll==null||findAll.size()==0){
			return "none";

		}
		request.put("findAll", findAll);
		return "input";
	}

private ServletContext servlet;
private PrintWriter writer;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		request=arg0;
		
	}
	public String delete(){
		
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			employyDAO.deleteByID(id);
			writer = response.getWriter();
			writer.println("1");
			writer.flush();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			writer.println("0");
			writer.flush();
		}
		return "delete";
	}



}
