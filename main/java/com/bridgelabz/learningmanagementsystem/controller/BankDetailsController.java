package com.bridgelabz.learningmanagementsystem.controller;

import com.bridgelabz.learningmanagementsystem.dto.BankDetailsDTO;
import com.bridgelabz.learningmanagementsystem.model.BankDetailsModel;
import com.bridgelabz.learningmanagementsystem.service.IBankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose:Creating apis for Bank Controller
 * @author Manoj
 * @Param Http METHODS
 * Version 1.0
 */
@RestController
@RequestMapping("/bankDetailsApis")
public class BankDetailsController {

    @Autowired
    IBankDetailsService  iBankDetailsService;

    /**
     * Purpose:Creating method to add bank
     * @author Manoj
     * @Param bankDto,token
     */
    @PostMapping("/addBankDetails")
    public BankDetailsModel addBank (@RequestHeader String token, @RequestBody @Valid BankDetailsDTO bankDetailsDTO){
        return iBankDetailsService.addBankDetails(token,bankDetailsDTO);
    }

    /**
     * Purpose:Creating method to Update Bank
     * @author Manoj
     * @Param BankDto ,id ,token
     */
    @PutMapping("/updateBankDetails/{id}")
    public BankDetailsModel updateBank (@RequestHeader String token,@PathVariable Long id , @RequestBody @Valid BankDetailsDTO bankDetailsDTO){
        return iBankDetailsService.editBank(token,id,bankDetailsDTO);
    }

    /**
     * Purpose:Creating method to get List of Bank
     * @author Manoj
     * @Param  token
     */
    @GetMapping("/getBankList")
    public List<BankDetailsModel> getList(@RequestHeader String token){
        return iBankDetailsService.viewList(token);
    }

    /**
     * Purpose:Creating method to Delete Bank
     * @author Manoj
     * @Param  token,id
     */
    @DeleteMapping("/deleteBank/{id}")
    public BankDetailsModel deleteBank (@RequestHeader String token,@PathVariable Long id){
        return iBankDetailsService.removeBank(token,id);
    }

}
