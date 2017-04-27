package com.yy.chen.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sun.print.resources.serviceui;

import com.yy.chen.dao.EmployyDAO;
import com.yy.chen.entities.Department;
import com.yy.chen.entities.Employy;

public class EmployyIMPL implements EmployyDAO {
private SessionFactory session;
	public void setSession(SessionFactory session) {
	this.session = session;
}

	@Override
	public List<Employy> findAll() {
		Session currentSession = session.getCurrentSession();
		String sql="from Employy e left outer join fetch e.depart";
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
		String sql="delete  Employy e  where id=?";
		Query query = currentSession.createQuery(sql);
		query.setInteger(0, id);
		query.executeUpdate();

	}

	@Override
	public void insert(Employy em) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(em);

	}

	@Override
	public void update(Employy em) {
		// TODO Auto-generated method stub
		System.out.println("sql"+em.toString());
		String sql="update  Employy e set  email=?,birthTime=?,DEPART_ID=?,lastName=? where id=?";
//		session.getCurrentSession().saveOrUpdate(em);
		Query createQuery = session.getCurrentSession().createQuery(sql);
		createQuery.setString(0, em.getEmail());
		createQuery.setString(3, em.getLastName());
		createQuery.setDate(1, em.getBirthTime());
//		createQuery.setEntity(2, em.getDepart());
		createQuery.setInteger(4, em.getId());
		createQuery.setInteger(2, em.getDepart().getId());
		createQuery.executeUpdate();
	
	}

	@Override
	public Employy findById(int id) {
		// TODO Auto-generated method stub
		Session currentSession = session.getCurrentSession();
		System.out.println("id"+id);
		String sql="from Employy e left outer join fetch e.depart where e.id=?";
		Query createQuery = currentSession.createQuery(sql);
		createQuery.setInteger(0, id);
		return (Employy) createQuery.list().get(0);
		
	}



}
