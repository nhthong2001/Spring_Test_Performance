package vn.elca.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.elca.training.model.entity.Group;
import vn.elca.training.model.entity.Project;
import vn.elca.training.repository.ProjectRepository;
import vn.elca.training.service.ProjectService;

import java.util.List;

/**
 * @author vlp
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public List<Project> findAll() {
        long start = System.currentTimeMillis();
        List<Project> projects = projectRepository.findAll();
        long end = System.currentTimeMillis();
        System.out.println("Get all Projects: " + (end - start) + "ms");
        return projects;
    }
}
