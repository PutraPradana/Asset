/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.service;

import java.util.Optional;
import metrodatamii.metrodatamii.entities.Account;
import metrodatamii.metrodatamii.entities.Asset;
import static metrodatamii.metrodatamii.entities.Asset_.id;
import metrodatamii.metrodatamii.entities.Category;
import metrodatamii.metrodatamii.entities.DetailAsset;
import metrodatamii.metrodatamii.entities.Employee;
import metrodatamii.metrodatamii.entities.EmployeeJob;
import metrodatamii.metrodatamii.entities.Job;
import metrodatamii.metrodatamii.entities.LoaningRequest;
import metrodatamii.metrodatamii.entities.RepairRequest;
import metrodatamii.metrodatamii.entities.Role;
import metrodatamii.metrodatamii.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import metrodatamii.metrodatamii.repository.AssetRepository;
import metrodatamii.metrodatamii.repository.CategoryRepository;
import metrodatamii.metrodatamii.repository.EmployeeRepository;
import metrodatamii.metrodatamii.repository.DetailAssetRepository;
import metrodatamii.metrodatamii.repository.EmployeeJobRepository;
import metrodatamii.metrodatamii.repository.JobRepository;
import metrodatamii.metrodatamii.repository.LoanRepository;
import metrodatamii.metrodatamii.repository.RepairRepository;
import metrodatamii.metrodatamii.repository.RoleRepository;

/**
 *
 * @author WIN7
 */
@Service
public class MainService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private DetailAssetRepository detailRepository;
    @Autowired
    private EmployeeJobRepository employeejobRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private RepairRepository repairRepository;
    @Autowired
    private RoleRepository roleRepository;

    public Iterable<Account> findAllAccount() {
        return accountRepository.findAll();
    }

    public Iterable<Asset> findAllAssets() {
        return assetRepository.findAll();
    }

    public Optional<Asset> findById(String id) {
        return assetRepository.findById(id);
    }

    public Iterable<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    public Iterable<DetailAsset> findAllDetailAsset() {
        return detailRepository.findAll();
    }

    public Iterable<EmployeeJob> findAllEmployeeJob() {
        return employeejobRepository.findAll();
    }

    public Iterable<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public Iterable<Job> findAllJob() {
        return jobRepository.findAll();
    }

    public Iterable<LoaningRequest> findAllLoan() {
        return loanRepository.findAll();
    }

    public Iterable<RepairRequest> findAllRepair() {
        return repairRepository.findAll();
    }

    public Iterable<Role> findAllRole() {
        return roleRepository.findAll();
    }
}
