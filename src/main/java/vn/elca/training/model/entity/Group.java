package vn.elca.training.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "_group")
public class Group extends AbstractEntity{
    @ManyToOne(fetch = FetchType.EAGER)
    private Employee groupLeader;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Project> projects;


    public Group() {
    }

    public Group(Set<Project> projects, Employee groupLeader) {
        this.groupLeader = groupLeader;
        this.projects = projects;
    }

    public Employee getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(Employee groupLeader) {
        this.groupLeader = groupLeader;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projectList) {
        this.projects = projectList;
    }
}
