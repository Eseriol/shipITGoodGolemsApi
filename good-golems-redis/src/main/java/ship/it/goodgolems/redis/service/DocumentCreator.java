package ship.it.goodgolems.redis.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.document.Document;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ship.it.goodgolems.domain.Employee;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentCreator {

    public static Document createDocument(Employee employee) {
        return new Document(employee.toString(), generateEmployeeMetadata(employee));
    }

    private static Map<String, Object> generateEmployeeMetadata(Employee employee) {
        var employeeMetadata = new HashMap<String, Object>();
        employeeMetadata.put("fullName", employee.fullName());
        employeeMetadata.put("position", employee.position());
        employee.experience().forEach(e -> employeeMetadata.put(e.stack().technologyName(), e.years()));
        return employeeMetadata;
    }

}
