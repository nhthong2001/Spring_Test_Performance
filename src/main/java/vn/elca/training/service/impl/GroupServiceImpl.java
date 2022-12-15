package vn.elca.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.elca.training.model.entity.Employee;
import vn.elca.training.model.entity.Group;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.entity.Role;
import vn.elca.training.repository.EmployeeRepository;
import vn.elca.training.repository.GroupRepository;
import vn.elca.training.repository.ProjectRepository;
import vn.elca.training.service.GroupService;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Group> findAll() {
        long start = System.currentTimeMillis();
        List<Group> groups = groupRepository.findAll();
        long end = System.currentTimeMillis();
        System.out.println("Get all Groups: " + (end - start) + "ms");
        return groups;
    }

    private static final int NUMBER_OF_GROUP = 300000;

    @Override
    public void init() {
        Employee grLeader, pjLeader1, pjLeader2, dev1, dev2, qa1, qa2;
        Project project1, project2;
        int pjId = 1;
        for (int i = 1; i <= NUMBER_OF_GROUP; i++) {
            grLeader = new Employee("GL" + i, Set.of(Role.GROUP_LEADER));
            grLeader = employeeRepository.save(grLeader);

            pjLeader1 = new Employee("PL" + pjId, Set.of(Role.PROJECT_LEADER));
            pjLeader1 = employeeRepository.save(pjLeader1);

            dev1 = new Employee("DEV_PJ_" + pjId, Set.of(Role.DEVELOPER));
            dev1 = employeeRepository.save(dev1);

            qa1 = new Employee("QA_PJ_" + pjId, Set.of(Role.QUALITY_AGENT));
            qa1 = employeeRepository.save(qa1);

            pjLeader2 = new Employee("PL" + pjId + 1, Set.of(Role.PROJECT_LEADER));
            pjLeader2 = employeeRepository.save(pjLeader2);

            dev2 = new Employee("DEV_PJ_" + pjId + 1, Set.of(Role.DEVELOPER));
            dev2 = employeeRepository.save(dev2);

            qa2 = new Employee("QA_PJ_" + pjId + 1, Set.of(Role.QUALITY_AGENT));
            qa2 = employeeRepository.save(qa2);


            project1 = new Project("Project " + pjId, pjLeader1, Set.of(pjLeader1, dev1, qa1));
            project1 = projectRepository.save(project1);

            project2 = new Project("Project " + pjId + 1, pjLeader2, Set.of(pjLeader2, dev2, qa2));
            project2 = projectRepository.save(project2);

            pjId += 2;

            Group g = new Group(Set.of(project1, project2), grLeader);
            groupRepository.save(g);
        }

    }
}


