/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.controller;

import java.time.LocalDate;
import javax.validation.Valid;
import metrodatamii.metrodatamii.entities.Asset;
import metrodatamii.metrodatamii.entities.DetailAsset;
import metrodatamii.metrodatamii.entities.Employee;
import metrodatamii.metrodatamii.entities.LoaningRequest;
import metrodatamii.metrodatamii.entities.Status;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    private LoanRepository loanRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DetailAssetRepository dassetRepository;

    @GetMapping("/")
    public String index(Model model) {
        String id = "2";
        return "home";
    }

    @GetMapping("/employee")
    public String index2(Model model) {
        model.addAttribute("dataEmp", employeeRepository.getAll());
        model.addAttribute("dataAcc", mainService.findAllEmployee());
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
        asset.setIsDelete(true);
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

//    @RequestMapping(value = "date", method = RequestMethod.POST)
//    public void processDate(@RequestParam("date")
//            @DateTimeFormat(pattern = "yyyy.MM.dd") LocalDate date) {
//        //Do stuff
//    }

//    @GetMapping("/EmpController/softdelete/{id}")
//    public String softDelete(@PathVariable("id") String id, Employee employee) {
//        employee.setIsDelete("true");
//        EmployeeRepository.save(employee);
//        return "redirect:/employee";
//    }
}
