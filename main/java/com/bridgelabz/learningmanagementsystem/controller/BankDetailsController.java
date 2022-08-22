package com.bridgelabz.learningmanagementsystem.controller;

import com.bridgelabz.learningmanagementsystem.dto.BankDetailsDTO;
import com.bridgelabz.learningmanagementsystem.model.BankDetailsModel;
import com.bridgelabz.learningmanagementsystem.service.IBankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bankDetailsApis")
public class BankDetailsController {

    @Autowired
    IBankDetailsService  iBankDetailsService;

    @PostMapping("/addBankDetails")
    public BankDetailsModel addBank (@RequestHeader String token, @RequestBody @Valid BankDetailsDTO bankDetailsDTO){
        return iBankDetailsService.addBankDetails(token,bankDetailsDTO);
    }

    @PutMapping("/updateBankDetails/{id}")
    public BankDetailsModel updateBank (@RequestHeader String token,@PathVariable Long id , @RequestBody @Valid BankDetailsDTO bankDetailsDTO){
        return iBankDetailsService.editBank(token,id,bankDetailsDTO);
    }

    @GetMapping("/getBankList")
    public List<BankDetailsModel> getList(@RequestHeader String token){
        return iBankDetailsService.viewList(token);
    }

    @DeleteMapping("/deleteBank/{id}")
    public BankDetailsModel deleteBank (@RequestHeader String token,@PathVariable Long id){
        return iBankDetailsService.removeBank(token,id);
    }

}
