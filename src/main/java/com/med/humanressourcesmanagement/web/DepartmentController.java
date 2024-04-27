package com.med.humanressourcesmanagement.web;

import com.med.humanressourcesmanagement.dao.entities.Department;
import com.med.humanressourcesmanagement.service.DepartmentManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentManager departmentManager;

    @GetMapping("departmentsList")
    public String getDepartments(Model model, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "taille", defaultValue = "3") int taille, @RequestParam(name = "search", defaultValue = "") String keyword){
        Page<Department> departments = departmentManager.searchDepartments(keyword,page, taille);
        model.addAttribute("departments", departments.getContent());
        int[] pages = new int[departments.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "departmentsList";
    }

    @GetMapping("/addDepartment")
    public String addDepartmentGet(Model model) {
        model.addAttribute("department", new Department());
        return "addDepartment";
    }

    @PostMapping("/addDepartment")
    public String addDepartmentPost(Model model, @Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addDepartment";
        }
        departmentManager.addDepartment(department);
        return "redirect:/departmentsList";
    }

    @GetMapping("/deleteDepartment")
    public String deleteDepartmentAction(@RequestParam(name = "id") Integer id, Integer page, String search) {
        if (departmentManager.deleteDepartmentById(id)) {
            return "redirect:/departmentsList";
        } else {
            return "error";
        }
    }

    @GetMapping("/updateDepartment")
    public String updateDepartmentGet(Model model, @RequestParam(name = "id") Integer id) {
        Department department = departmentManager.findDepartmentById(id);
        if (department != null) {
            model.addAttribute("department", department);
            return "updateDepartment";
        } else {
            return "error";
        }
    }

    @PostMapping("/updateDepartment")
    public String updateDepartmentPost(Model model, @RequestParam(name = "id") Integer id, @RequestParam(name = "name") String name, @RequestParam(name = "description") String description) {
        Department department = departmentManager.findDepartmentById(id);
        department.setName(name);
        department.setDescription(description);
        if (department != null) {
            departmentManager.updateDepartment(department);
            return "redirect:/departmentsList";
        } else {
            return "error";
        }
    }
}
