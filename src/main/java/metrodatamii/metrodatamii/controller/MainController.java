/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.controller;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import metrodatamii.metrodatamii.entities.Asset;
import metrodatamii.metrodatamii.entities.DetailAsset;
import metrodatamii.metrodatamii.entities.Employee;
import metrodatamii.metrodatamii.entities.Job;
import metrodatamii.metrodatamii.entities.LoaningRequest;
import metrodatamii.metrodatamii.entities.RepairRequest;
import metrodatamii.metrodatamii.entities.Role;
import metrodatamii.metrodatamii.entities.Status;
import metrodatamii.metrodatamii.entities.Upload;
import metrodatamii.metrodatamii.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import metrodatamii.metrodatamii.repository.AssetRepository;
import metrodatamii.metrodatamii.repository.DetailAssetRepository;
import metrodatamii.metrodatamii.repository.EmployeeRepository;
import metrodatamii.metrodatamii.repository.JobRepository;
import metrodatamii.metrodatamii.repository.LoanRepository;
import metrodatamii.metrodatamii.repository.RepairRepository;
import metrodatamii.metrodatamii.repository.RoleRepository;
import metrodatamii.metrodatamii.repository.UploadRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 *
 * @author WIN7
 */
@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UploadRepository uploadRepository;
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private RepairRepository repairRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DetailAssetRepository dassetRepository;

    @GetMapping("/")
    public String index(Model model) {
        String id = "2";
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        String id = "2";
        return "about";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        String id = "2";
        return "profile";
    }

    @GetMapping("/employee")
    public String index2(Model model) {
        model.addAttribute("dataEmp", employeeRepository.getAll());
        model.addAttribute("dataAcc", mainService.findAllAccount());
        return "employee";
    }

    @GetMapping("/job&role")
    public String job(Model model) {
        model.addAttribute("dataJob", mainService.findAllJob());
        model.addAttribute("dataRole", mainService.findAllRole());
        return "job";
    }

    @GetMapping("/request")
    public String loaning(Model model) {
        model.addAttribute("dataLoaning", mainService.findAllLoan());
        model.addAttribute("dataRepair", mainService.findAllRepair());
        return "request";
    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("dataLoaning", mainService.findAllLoan());
        model.addAttribute("dataRepair", mainService.findAllRepair());
        return "history";
    }

    @GetMapping("/asset")
    public String cat(Model model) {
        model.addAttribute("dataAsset", mainService.findAllAssets());
        model.addAttribute("dataCategory", mainService.findAllCategory());
        return "asset";
    }

    @GetMapping("/detailasset")
    public String detail(Model model) {
        model.addAttribute("dataDAsset", mainService.findAllDetailAsset());
        model.addAttribute("dataAsset", mainService.findAllAssets());
        return "detailasset";
    }

    @PostMapping("/detailasset/addData")
    public String addData(DetailAsset dasset) {
        dasset.setId("0");
        dassetRepository.save(dasset);
        return "redirect:/detailasset";
    }

    @PostMapping("/assetController/addData")
    public String addData(Asset asset) {
        asset.setId("0");
        asset.setIsDelete("false");
        assetRepository.save(asset);
        return "redirect:/asset";
    }
//    @RequestMapping(value = "/update", method = RequestMethod.GET)
//    @PostMapping("/updateAsset/{id}")
//    public String updateData(@PathVariable("id") String id, @Valid Asset asset) {
//        asset.setIsDelete(false);
//        assetRepository.save(asset);
//        return "redirect:/asset";
//    }

//    @RequestMapping(value = "/appel/edit/{id}", method = RequestMethod.GET)
//    public String editapl(@PathVariable("id") String id, ModelMap model) {
//        model.put("editappel", mainService.findById(id));
//        return "edit";
//    }
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String saveAppel(@ModelAttribute("editappel") Asset editappel, BindingResult result, ModelMap model) {
//        if (result.hasErrors()) {
//            return "edit";
//        }
//        assetRepository.save(editappel);
//        return "index";
//    }
    @GetMapping("/user_home")
    public String user(Model model) {
        String id = "2";
        return "user_home";
    }

    @GetMapping("/loaning")
    public String loan(Model model) {
        model.addAttribute("dataDetail", mainService.findAllDetailAsset());
        model.addAttribute("dataEmployee", mainService.findAllEmployee());
        model.addAttribute("dataAsset", mainService.findAllAssets());
        return "loaning";
    }

    @PostMapping("/loaningController/addData")
    public String addLoan(LoaningRequest loan) {
        loan.setId("0");
        Status status = new Status();
        status.setId("ST1");
        loan.setStatus(status);
        loanRepository.save(loan);
        return "redirect:/loaning";
    }

    @GetMapping("/repair")
    public String repair(Model model) {
        model.addAttribute("dataDetail", mainService.findAllDetailAsset());
        model.addAttribute("dataEmployee", mainService.findAllEmployee());
        model.addAttribute("dataAsset", mainService.findAllAssets());
        return "repair";
    }

    @PostMapping("/repair/addData")
    public String addRepair(RepairRequest repair) {
        repair.setId("0");
        Status status = new Status();
        status.setId("ST1");
        repair.setStatus(status);
        repairRepository.save(repair);
        return "redirect:/repair";
    }

    @PostMapping("/addJob")
    public String addJob(Job job) {
        job.setId("0");
        job.setIsDelete("false");
        jobRepository.save(job);
        return "redirect:/job";
    }

    @PostMapping("/editJob/{id}")
    public String updateJob(@PathVariable("id") String id, @Valid Job job) {
        job.setIsDelete("false");
        jobRepository.save(job);
        return "redirect:/job";
    }

    @PostMapping("/addRole")
    public String addRole(Role role) {
        role.setId("0");
        role.setIsDelete("false");
        roleRepository.save(role);
        return "redirect:/role";
    }

    @PostMapping("/editRole/{id}")
    public String updateRole(@PathVariable("id") String id, @Valid Role role) {
        role.setIsDelete("false");
        roleRepository.save(role);
        return "redirect:/role";
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {

        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload) {
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                Upload uploadFile = new Upload();
                uploadFile.setName(aFile.getOriginalFilename());
                uploadFile.setData(aFile.getBytes());
                uploadRepository.save(uploadFile);
            }
        }

        return "Success";
    }

    @GetMapping("/findEmp")
    @ResponseBody
    public Employee employee(String id) {
        Employee emp = new Employee(
                employeeRepository.getEmployeeById(id).get(0).getId(),
                employeeRepository.getEmployeeById(id).get(0).getFirstName(),
                employeeRepository.getEmployeeById(id).get(0).getLastName(),
                employeeRepository.getEmployeeById(id).get(0).getEmail(),
                employeeRepository.getEmployeeById(id).get(0).getSalary(),
                employeeRepository.getEmployeeById(id).get(0).getPhoneNumber(),
                employeeRepository.getEmployeeById(id).get(0).getManager().getId()
        );
        return emp;
    }

    @PostMapping("/employeeEdit/id")
    public String updateEmp(Employee employee) {
        employee.setId("E0000");
        employee.setIsDelete("false");
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

//    @RequestMapping(value = "date", method = RequestMethod.POST)
//    public void processDate(@RequestParam("date")
//            @DateTimeFormat(pattern = "yyyy.MM.dd") LocalDate date) {
//        //Do stuff
//    }
    @PostMapping("/EmpController/softdelete/{id}")
    public String softDelete(Employee employee) {
        employee.setIsDelete("true");
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/findLoan")
    @ResponseBody
    public LoaningRequest loan(String id) {
        LoaningRequest loan = new LoaningRequest(
                loanRepository.getLoanById(id).get(0).getId(),
                loanRepository.getLoanById(id).get(0).getLoaningDate(),
                loanRepository.getLoanById(id).get(0).getReturnDate(),
                loanRepository.getLoanById(id).get(0).getLoaningTotal(),
                loanRepository.getLoanById(id).get(0).getNote(),
                loanRepository.getLoanById(id).get(0).getQuantity());
                loanRe
        return loan;
    }

    @PostMapping("/loanEdit/id")
    public String updateLoan(LoaningRequest loaning) {
        loaning.setId("LR0000");
        loaning.setStatus(new Status("ST2"));
        loanRepository.save(loaning);
        return "redirect:/loaning";
    }
}
