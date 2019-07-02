/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.repository;

import java.util.List;
import metrodatamii.metrodatamii.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>{
    @Query(value = "SELECT * FROM employee e WHERE e.is_delete = 'false'", nativeQuery = true)
    List<Employee> getAll();
}
