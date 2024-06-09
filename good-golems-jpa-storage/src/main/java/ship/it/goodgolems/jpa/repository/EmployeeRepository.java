package ship.it.goodgolems.jpa.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.jpa.model.EmployeeEntity;

@Repository
public interface EmployeeRepository extends ListCrudRepository<EmployeeEntity, Long> {

    default Set<Employee> findAvailableEmployees() {
        return findEmployeesByCurrentProject_Id(null, Employee.class);
    }

    <T> Set<T> findEmployeesByCurrentProject_Id(Long id, Class<T> type);

    List<EmployeeEntity> findAllByPosition(String position);

    @Query("SELECT e FROM Employee e JOIN e.experience exp JOIN exp.stack s WHERE s.technologyName = :technologyName")
    List<EmployeeEntity> findAllByTechnologyName(@Param("technologyName") String technologyName);

    @Query("SELECT e FROM Employee e WHERE e.currentProject.name = :projectName")
    List<EmployeeEntity> findAllByProjectName(@Param("projectName") String projectName);

    @Query("SELECT e FROM Employee e JOIN e.currentProject p WHERE p.id = :projectId")
    List<EmployeeEntity> findAllByProjectId(@Param("projectId") Long projectId);

    List<EmployeeEntity> findAllByFullName(String fullName);

    @Query("SELECT DISTINCT e FROM Employee e JOIN e.experience exp JOIN exp.stack s WHERE s.technologyName IN :technologyNames")
    List<EmployeeEntity> findAllByTechnologyNames(@Param("technologyNames") List<String> technologyNames);

    @Query("SELECT e FROM Employee e JOIN e.currentProject p JOIN p.requirements req JOIN req.stack s WHERE s.technologyName = :technologyName")
    List<EmployeeEntity> findAllByProjectRequirement(@Param("technologyName") String technologyName);

    @Query("SELECT e FROM Employee e WHERE e.position LIKE %:seniorityLevel%")
    List<EmployeeEntity> findAllBySeniorityLevel(@Param("seniorityLevel") String seniorityLevel);

    @Query("SELECT e FROM Employee e JOIN e.experience exp JOIN exp.stack s WHERE s.technologyName = :technologyName AND exp.years >= :years")
    List<EmployeeEntity> findAllByStackAndMinYears(@Param("technologyName") String technologyName, @Param("years") int years);

    @Query("SELECT e FROM Employee e WHERE SIZE(e.experience) > :numberOfProjects")
    List<EmployeeEntity> findAllByNumberOfProjectsGreaterThan(@Param("numberOfProjects") int numberOfProjects);

    @Query("SELECT e FROM Employee e JOIN e.experience exp JOIN exp.stack s WHERE s.technologyName = :technologyName AND exp.years >= :years")
    List<EmployeeEntity> findAllByTechnologyAndMinYears(@Param("technologyName") String technologyName, @Param("years") int years);

}
