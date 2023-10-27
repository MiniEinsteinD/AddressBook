package com.example.lab03;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {

    @Autowired
    AddressBookRepository addressBookRepository;

    @GetMapping("/addressbook")
    public String listBuddies(@RequestParam(name="owner", required=true) String owner, Model model) {
        AddressBook addressBook = addressBookRepository.findByOwner(owner);
        model.addAttribute("addressBook", addressBook);
        return "addressBook";
    }


}
