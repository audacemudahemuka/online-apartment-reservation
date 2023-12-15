package com.auca.onlineappaertmentreservistionbook.controller;

import com.auca.onlineappaertmentreservistionbook.model.Administrator;
import com.auca.onlineappaertmentreservistionbook.model.Apartment;
import com.auca.onlineappaertmentreservistionbook.model.Customer;
import com.auca.onlineappaertmentreservistionbook.service.ApartmentService;
import com.auca.onlineappaertmentreservistionbook.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageControler {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ApartmentService apartmentService;
    @GetMapping("/customer")
    public String getCustomerPage(Model model, HttpSession session) {
        Customer authenticatedCustomer =(Customer) session.getAttribute("authenticatedCustomer");

        if (authenticatedCustomer != null) {
            model.addAttribute("authenticatedCustomer", authenticatedCustomer);
            return "customerPage";
        } else {
            // Redirect to login if the customer is not authenticated
            return "redirect:/login";
        }

    }
    @GetMapping("/customerReservation")
    public String getCustomerReservation(Model model, HttpSession session) {
        Customer authenticatedCustomer =(Customer) session.getAttribute("authenticatedCustomer");

        if (authenticatedCustomer != null) {
            model.addAttribute("authenticatedCustomer", authenticatedCustomer);
            return "customerReservation";
        } else {
            // Redirect to login if the customer is not authenticated
            return "redirect:/login";
        }
    }
    @GetMapping("/customerApartment")
    public String getCustomerApartment(Model model, HttpSession session){


        Customer authenticatedCustomer =(Customer) session.getAttribute("authenticatedCustomer");

        if (authenticatedCustomer != null) {
            model.addAttribute("authenticatedCustomer", authenticatedCustomer);
            return "customerApartment";
        } else {
            // Redirect to login if the customer is not authenticated
            return "redirect:/login";
        }

    }
    @GetMapping("/customerProfile")
    public String getCustomerProfile(Model model, HttpSession session){
        Customer authenticatedCustomer =(Customer) session.getAttribute("authenticatedCustomer");

        if (authenticatedCustomer != null) {
            model.addAttribute("authenticatedCustomer", authenticatedCustomer);
            return "customerProfile";
        } else {
            // Redirect to login if the customer is not authenticated
            return "redirect:/login";
        }


    }
    @GetMapping("/adminPage")
    public String getAdminPage(HttpSession session, Model model){
        Administrator loggedInAdministrator=(Administrator) session.getAttribute("loggedInAdministrator");
        if(loggedInAdministrator!=null){
            model.addAttribute("loggedInAdministrator",loggedInAdministrator);
            return "adminPage";

        }else {
            return "redirect:/adminLogin";
        }


    }
    @GetMapping("/adminApartment")
    public String getAdminApartment(HttpSession session, Model model){
        Administrator loggedInAdministrator=(Administrator) session.getAttribute("loggedInAdministrator");
        if(loggedInAdministrator!=null){
            model.addAttribute("loggedInAdministrator",loggedInAdministrator);
            model.addAttribute("apartment", new Apartment());
            model.addAttribute("apartments",apartmentService.getAllApartments());
            return "adminApartment";

        }else {
            return "redirect:/adminLogin";
        }


    }
    @GetMapping("/adminReservation")
    public String getAdminReservation(HttpSession session, Model model){
        Administrator loggedInAdministrator=(Administrator) session.getAttribute("loggedInAdministrator");
        if(loggedInAdministrator!=null){
            model.addAttribute("loggedInAdministrator",loggedInAdministrator);
            return "adminReservation";

        }else {
            return "redirect:/adminLogin";
        }


    }
    @GetMapping("/adminCustomer")
    public String getAdminCustomer(HttpSession session, Model model){
        Administrator loggedInAdministrator=(Administrator) session.getAttribute("loggedInAdministrator");
        if(loggedInAdministrator!=null){
            Customer customer= new Customer();
            List<Customer> customers= customerService.getAllCustomers();
            model.addAttribute("customers",customers);
            model.addAttribute("customer",customer);
            model.addAttribute("loggedInAdministrator",loggedInAdministrator);
            return "adminCustomer";

        }else {
            return "redirect:/adminLogin";
        }



    }
    @GetMapping("/adminProfile")
    public String getAdminProfile(HttpSession session, Model model){
        Administrator loggedInAdministrator=(Administrator) session.getAttribute("loggedInAdministrator");
        if(loggedInAdministrator!=null){
            model.addAttribute("loggedInAdministrator",loggedInAdministrator);
            return "adminProfile";

        }else {
            return "redirect:/adminLogin";
        }



    }
    @GetMapping("/customerForm")
    public String getAdminCustomerForm(HttpSession session, Model model){
        Administrator loggedInAdministrator=(Administrator) session.getAttribute("loggedInAdministrator");
        if(loggedInAdministrator!=null){
            model.addAttribute("loggedInAdministrator",loggedInAdministrator);
            model.addAttribute("customer",new Customer());
            return "customerForm";

        }else {
            return "/adminLogin";
        }



    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session
        session.invalidate();

        // Redirect to the root URL
        return "redirect:/";
    }
}
