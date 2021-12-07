package com.example.web.controllers;

import com.example.web.accessingdatamysql.FormRepository;
import com.example.web.accessingdatamysql.RegFormRepo;
import com.example.web.dao.PersonForm;
import com.example.web.dao.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller // This means that this class is a Controller // This means URL's start with /demo (after Application path)
public class CrudController {

     // This means to get the bean called userRepository
    private final FormRepository formRepository; // Which is auto-generated by Spring, we will use it to handle the data

    private final RegFormRepo regFormRepo;

    @Autowired
    public  CrudController(FormRepository formRepository, RegFormRepo regFormRepo){
        this.formRepository = formRepository;
        this.regFormRepo = regFormRepo;
    }

    @GetMapping(path="/form")
    public String getPersonForm(PersonForm personForm) {
        return "form";
    }

    @GetMapping(path="/register")
    public String getRegisterForm(RegistrationForm registrationForm) {
        return "register";
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUserForm (
            @RequestParam String name,
            @RequestParam Integer age
    ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        PersonForm person = new PersonForm();
        person.setName(name);
        person.setAge(age);
        formRepository.save(person);
        return "redirect:/form";
    }

    @GetMapping(path="/all")
    public String getAllUsersForm(Model model) {
        // This returns a JSON or XML with the users
        model.addAttribute("all", formRepository.findAll());
        return "all";
    }

    @PostMapping("/add-reg")
    public String addUser(@Valid RegistrationForm registrationForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/error";
        }
        regFormRepo.save(registrationForm);
        return "redirect:/register";
    }

    @GetMapping(path="/registered")
    public String getAllUsersReg(Model model) {
        model.addAttribute("allreg", regFormRepo.findAll());
        return "registered";
    }

    @GetMapping("/person/{id}")
    public String showPersonById(@PathVariable("id") long id, Model model) {
        PersonForm personForm = formRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("persons", personForm);
        return "persons";
    }

//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") long id, Model model) {
//        RegistrationForm registrationForm = regFormRepo.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        regFormRepo.delete(registrationForm);
//        return "redirect:/register";
//    }
}