package com.yy.chen.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sun.print.resources.serviceui;

import com.yy.chen.dao.DepartmentDAO;
import com.yy.chen.dao.EmployyDAO;
import com.yy.chen.entities.Department;
import com.yy.chen.entities.Employy;

public class DepartmentIMPL implements DepartmentDAO {
private SessionFactory session;
	public void setSession(SessionFactory session) {
	this.session = session;
}

	@Override
	public List<Department> findAll() {
		Session currentSession = session.getCurrentSession();
		String sql="from Department e ";
		Query createQuery = currentSession.createQuery(sql);
		return createQuery.list();
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByID(int id) {
		// TODO Auto-generated method stub
		Session currentSession = session.getCurrentSession();
		String sql="delete  Department where id=?";
		Query query = currentSession.createQuery(sql);
		query.setInteger(0, id);
		query.executeUpdate();

	}


	

	@Override
	public void insert(Department em) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department em) {
		// TODO Auto-generated method stub
		
	}

}
