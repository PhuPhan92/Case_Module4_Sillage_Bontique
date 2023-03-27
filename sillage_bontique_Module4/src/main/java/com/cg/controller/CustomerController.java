package com.cg.controller;


import com.cg.exception.UnauthorizedException;
import com.cg.model.Customer;

import com.cg.model.dto.StaffInfoDTO;
import com.cg.service.customer.ICustomerService;

import com.cg.service.staff.IStaffService;
import com.cg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AppUtils appUtils;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IStaffService staffService;




    @GetMapping
    public String showListPage(Model model) {

        String username = appUtils.getPrincipalUsername();

        Optional<StaffInfoDTO> staffInfoDTO = staffService.getStaffInfoByUsername(username);

        if (!staffInfoDTO.isPresent()) {
            throw new UnauthorizedException("Staff is not exists");
        }

        String fullName = staffInfoDTO.get().getFullName();

//        List<Customer> customers = customerService.findAll();
//
        model.addAttribute("fullName", fullName);

        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @GetMapping("/update/{customerId}")
    public String showUpdatePage(@PathVariable Long customerId, Model model) {

        Optional<Customer> customerOptional = customerService.findById(customerId);
        if (!customerOptional.isPresent()) {
            return "error/404";
        }

        model.addAttribute("customer", customerOptional.get());

        return "customer/edit";
    }




    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer, BindingResult bindingResult, Model model) {

        new Customer().validate(customer, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("errors", true);
            model.addAttribute("customer", customer);
            return "customer/create";
        }

        customer.setId(null);
        customer.setBalance(BigDecimal.ZERO);
        customerService.save(customer);

        return "customer/create";
    }


    @PostMapping("/update/{customerId}")
    public String update(@PathVariable Long customerId, @ModelAttribute Customer customer) {

        Optional<Customer> customerOptional = customerService.findById(customerId);
        if (!customerOptional.isPresent()) {
            return "error/404";
        }

        customer.setBalance(customerOptional.get().getBalance());
        customer.setId(customerId);
        customerService.save(customer);

        return "redirect:/customers";
    }

}
