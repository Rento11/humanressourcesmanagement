package com.med.humanressourcesmanagement.web;

import com.med.humanressourcesmanagement.dao.entities.Employee;
import com.med.humanressourcesmanagement.service.DepartmentManager;
import com.med.humanressourcesmanagement.service.EmployeeManager;
import com.med.humanressourcesmanagement.service.PositionManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeManager employeeManager;
    @Autowired
    private PositionManager positionManager;
    @Autowired
    private DepartmentManager departmentManager;

    @GetMapping("/")
    public String index_(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("employeesList")
    public String getEmployees(Model model, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "taille", defaultValue = "3") int taille, @RequestParam(name = "search", defaultValue = "") String keyword){
        Page<Employee> employees = employeeManager.searchEmployees(keyword,page, taille);
        model.addAttribute("employees", employees.getContent());
        int[] pages = new int[employees.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "employeesList";
    }

    @GetMapping("/addEmployee")
    public String addEmployeeGet(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("positions", positionManager.getAllPositions());
        model.addAttribute("departments", departmentManager.getAllDepartments());
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployeePost(@Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addEmployee";
        }
        employeeManager.addEmployee(employee);
        return "redirect:/employeesList";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployeeAction(@RequestParam(name = "id") Integer id, Integer page, String search) {
        if (employeeManager.deleteEmployeeById(id)) {
            return "redirect:/employeesList";
        } else {
            return "error";
        }
    }

    @GetMapping("/updateEmployee")
    public String updateEmployeeGet(Model model, @RequestParam(name = "id") Integer id) {
        Employee employee = employeeManager.findEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "updateEmployee";
        } else {
            return "error";
        }
    }

    @GetMapping("/employeeDetails")
    public String employeeDetails(Model model, @RequestParam(name = "id") Integer id) {
        Employee employee = employeeManager.findEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employeeDetails";
        } else {
            return "error";
        }
    }


    @PostMapping("/updateEmployee")
    public String updateEmployeePost(Model model, @RequestParam(name = "id") Integer id, @RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName, @RequestParam(name="email") String email, @RequestParam(name ="phoneNumber") String phoneNumber, @RequestParam(name = "hireDate") LocalDate hireDate, @RequestParam(name="salary") double salary) {
        Employee employee = employeeManager.findEmployeeById(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setHireDate(hireDate);
        employee.setSalary(salary);
        employeeManager.updateEmployee(employee);
        if (employee != null) {
            employeeManager.updateEmployee(employee);
            return "redirect:/employeesList";
        } else {
            return "error";
        }
    }
}
