package vn.elca.training.model.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project extends AbstractEntity {
    @Column
    private String projectName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="project_leader")
    private Employee projectLeader;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public Project() {
    }

    public Project(String projectName, Employee projectLeader, Set<Employee> employees) {
        this.projectName = projectName;
        this.projectLeader = projectLeader;
        this.employees = employees;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Employee getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(Employee projectLeader) {
        this.projectLeader = projectLeader;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}