package vn.elca.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.elca.training.service.EmployeeService;
import vn.elca.training.service.GroupService;
import vn.elca.training.service.ProjectService;

@RestController
@RequestMapping
public class TestController{
    @Autowired
    private GroupService groupService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/init")
    public Boolean initGroup() {
        groupService.init();
        return true;
    }

    @GetMapping("/test")
    public Boolean test() {
        groupService.findAll();
        projectService.findAll();
        employeeService.findAll();
        return true;
    }



}
