package ship.it.goodgolems.jpa.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.jpa.repository.ProjectRepository;
import ship.it.goodgolems.spi.storage.ProjectStorage;

@Service
@Transactional(readOnly = true)
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
