package com.lingyun.controller;

import com.lingyun.bean.Account;
import com.lingyun.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("test")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("控制层...");
        List<Account> all = accountService.findAll();
        for(Account account:all){
            System.out.println(account);
        }
        model.addAttribute("list",all);

        return "success";
    }

    @RequestMapping("/save")
    public String save(Account account){
        System.out.println(account);
        accountService.save(account);
        return "success";
    }
}
