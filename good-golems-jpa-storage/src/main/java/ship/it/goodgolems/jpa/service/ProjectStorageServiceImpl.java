package ship.it.goodgolems.jpa.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.jpa.mapper.ProjectMapper;
import ship.it.goodgolems.jpa.repository.ProjectRepository;
import ship.it.goodgolems.spi.storage.ProjectStorage;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectStorageServiceImpl implements ProjectStorage {

    private final ProjectRepository projectRepository;
    private final ProjectMapper mapper;

    @Override
    public Set<Project> getProjects() {
        return projectRepository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toSet());
    }
}
