package com.Jogmedia.Jogmedia.controller;

import com.Jogmedia.Jogmedia.model.Employee;
import com.Jogmedia.Jogmedia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/tampilemp")
    public String EmployeeList(Model model){
        model.addAttribute("employee",employeeService.showAllEmployee());
        return "tampilemp";
    }
    @RequestMapping(value = "/tampilemp/createEmployee", method = RequestMethod.GET)
    public String tampilFormCreateEmployee(Model model)
    {
        model.addAttribute("employee",new Employee());
        return "createEmployee";
    }
    @RequestMapping(value = "/tampilemp/createEmployee", method = RequestMethod.POST)
    public String simpanDataEmployee(Employee employee){
        employeeService.save(employee);
        return "redirect:/tampilemp";
    }
    @RequestMapping(value = "/tampilemp/edit/{id}", method = RequestMethod.GET)
    public String editData(@PathVariable Integer id, Model model){
        model.addAttribute("employee",employeeService.getIdEmployee(id));
        return "createEmployee";
    }
    @RequestMapping(value = "/tampilemp/hapus/{id}", method = RequestMethod.GET)
    public String hapusData(@PathVariable Integer id,Model model) {
        employeeService.deleteEmployee(id);
        return "redirect:/tampilemp";

    }
}
