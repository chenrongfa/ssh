package com.yy.chen.dao;

import java.util.List;

import com.yy.chen.entities.Department;
import com.yy.chen.entities.Employy;

public interface EmployyDAO {
	public List<Employy> findAll();
	public Employy findById(int id);
	public void deleteAll();
	public void deleteByID(int id);
	public void insert(Employy em);
	public void update(Employy em);

}
