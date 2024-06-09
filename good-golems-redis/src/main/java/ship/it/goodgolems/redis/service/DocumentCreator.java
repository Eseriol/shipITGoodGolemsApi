package ship.it.goodgolems.redis.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.document.Document;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ship.it.goodgolems.domain.Employee;

/**
 * The DocumentCreator class is responsible for creating Document objects based on an Employee object.
 * It provides a static method to create a Document with the employee's information and metadata.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class DocumentCreator {

    /**
     * Creates a Document object based on an Employee object.
     *
     * @param employee The Employee object for creating the Document.
     * @return The created Document object.
     */
    static Document createDocument(Employee employee) {
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
