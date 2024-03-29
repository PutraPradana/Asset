/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.repository;

import java.util.List;
import metrodatamii.metrodatamii.entities.LoaningRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface LoanRepository extends CrudRepository<LoaningRequest, String> {

    @Query(value = "SELECT * FROM loaning_request WHERE id = ?1", nativeQuery = true)
    List<LoaningRequest> getLoanById(String id);

}
