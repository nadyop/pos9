package com.blibli.services;

import com.blibli.dao_api.EmployeeDaoInterface;
import com.blibli.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    EmployeeDaoInterface employeeDaoInterface;
    public List<Employee> showAllEmployee(){
        List<Employee> temp=employeeDaoInterface.getAllEmployee();
        return temp;
    }
    public void save(Employee e){
        employeeDaoInterface.insertCategory(e);

    }
    public Employee getIdEmployee(Integer id){
        Employee idEmp= employeeDaoInterface.getIdEmployee(id);
        return idEmp;
    }
    public void deleteEmployee(Integer id){
        employeeDaoInterface.delete(id);
    }
}