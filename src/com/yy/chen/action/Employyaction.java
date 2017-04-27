package com.yy.chen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;



import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.yy.chen.dao.DepartmentDAO;
import com.yy.chen.dao.EmployyDAO;
import com.yy.chen.entities.Employy;

public class Employyaction extends ActionSupport implements RequestAware
,ModelDriven<Employy>{

	/**
	 * 
	 */
	private EmployyDAO employyDAO;
	private DepartmentDAO departmentDAO;
	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}


	private Employy model=new Employy();


	private int id;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setEmployyDAO(EmployyDAO employyDAO) {
		this.employyDAO = employyDAO;
	}


	private Map<String, Object> request;
	private static final long serialVersionUID = 1L;

	
	public String findAll(){
		List<Employy> findAll = employyDAO.findAll();
		if(findAll==null||findAll.size()==0){
			return "none";

		}
		request.put("findAll", findAll);
		return "list";
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
			System.out.println(id);
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

public String add(){
	
	
	System.out.println(id);
	model.setCreateTime(new Date());
	employyDAO.insert(model);
	return "add";
}


@Override
public Employy getModel() {
	// TODO Auto-generated method stub
	return model;
}
//public void prepareAdd(){
//	model=new Employy();
//}
public String update(){
	Employy findById = employyDAO.findById(id);

	request.put("findById", findById);
	request.put("findAll", departmentDAO.findAll());
	System.out.println(findById.toString());
	return "update";
}
//@Override
//public void prepare() throws Exception {
//	// TODO Auto-generated method stub
//	
//}
public String updateById(){
	System.out.println(model.toString());
	employyDAO.update(model);
	return "add";
}
}
