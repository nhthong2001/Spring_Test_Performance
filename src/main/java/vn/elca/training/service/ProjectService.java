package vn.elca.training.service;

import vn.elca.training.model.entity.Project;

import java.util.List;

/**
 * @author vlp
 */
public interface ProjectService {
    List<Project> findAll();
}
