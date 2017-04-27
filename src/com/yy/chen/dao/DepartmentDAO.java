package com.yy.chen.dao;

import java.util.List;

import com.yy.chen.entities.Department;
import com.yy.chen.entities.Employy;

public interface DepartmentDAO {
	public List<Department> findAll();
	public void deleteAll();
	public void deleteByID(int id);
	public void insert(Department em);
	public void update(Department em);

}
