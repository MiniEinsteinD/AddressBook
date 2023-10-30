package com.example.lab03;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/createAddressBook")
    public String createAddressBookForm() {
        return "createAddressBook";
    }
    @PostMapping("/createAddressBook")
    public String createAddressBook(@RequestParam String owner) {
        AddressBook addressBook = new AddressBook(owner);
        addressBookRepository.save(addressBook);
        return "redirect:/addressbook?owner=" + owner;
    }
    @GetMapping("/addBuddy")
    public String addBuddyForm() {
        return "addBuddy";
    }

    @PostMapping("/addBuddy")
    public String addBuddy(@RequestParam Long id, @RequestParam String name, @RequestParam String phoneNumber) {
        // Retrieve the address book you want to add the buddy to (you can modify this logic)
        AddressBook addressBook = addressBookRepository.findByOwner("Daniah");

        if (addressBook != null) {
            BuddyInfo buddy = new BuddyInfo(id, name, phoneNumber);
            addressBook.addBuddy(buddy);
            addressBookRepository.save(addressBook);
        }
        return "redirect:/addressbook?owner=Daniah";
    }


}
