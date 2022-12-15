package vn.elca.training.model.entity;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.util.Set;

@Entity
public class Employee extends AbstractEntity{
    @Column(nullable = false)
    private String visa;

    @Column
    @Enumerated
    @ElementCollection(targetClass = Role.class)
    private Set<Role> roles;

    public Employee(String visa, Set<Role> roles) {
        this.visa = visa;
        this.roles = roles;
    }

    public Employee() {

    }

    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
