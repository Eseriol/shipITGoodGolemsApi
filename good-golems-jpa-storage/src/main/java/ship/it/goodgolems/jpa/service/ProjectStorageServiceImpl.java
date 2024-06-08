package ship.it.goodgolems.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.jpa.repository.ProjectRepository;
import ship.it.goodgolems.spi.storage.ProjectStorage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ProjectStorageServiceImpl implements ProjectStorage {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Set<Project> getProjects() {
        Iterator<Project> iterator = projectRepository.findAll().iterator();
        Set<Project> projects = new HashSet<>();
        while (iterator.hasNext()){
            projects.add(iterator.next());
        }
        return projects;
    }
}
