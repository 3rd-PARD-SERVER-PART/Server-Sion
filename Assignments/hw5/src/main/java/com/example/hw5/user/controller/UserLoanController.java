package com.example.hw5.user.controller;


import com.example.hw5.user.dto.UserLoanDto;
import com.example.hw5.user.service.UserLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan")
public class UserLoanController {
    private final UserLoanService userLoanService;

    @GetMapping("/list")
    public List<UserLoanDto.Read> findAll(){
        return userLoanService.findAll();
    }

    @PostMapping("/request")
    public String requestLoan(@RequestBody UserLoanDto.Create dto){
        return userLoanService.requestLoan(dto);
    }

    @PostMapping("/return/{loanId}")
    public String requestReturn(@PathVariable Long loanId) {
        return userLoanService.requestReturn(loanId);
    }
    @PostMapping("/findById")
    public UserLoanDto.Read findById(@RequestParam Long id){
        return userLoanService.findById(id);
    }
}
