// package com.example.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;

// import com.example.Entity.Service;
// import com.example.repository.ServiceRepository;

// @Controller
// public class ServiceController {
    
//     @Autowired
//     private ServiceRepository serviceRepository;
    
//     @GetMapping("/services")
//     public String listServices(Model model) {
//         List<Service> services = serviceRepository.findAll();
//         model.addAttribute("services", services);
//         return "services";
//     }
    
//     @GetMapping("/services/{id}")
//     public String viewService(@PathVariable("id") Long id, Model model) {
//         Service service = serviceRepository.getOne(id);
//         model.addAttribute("service", service);
//         return "service";
//     }
    
//     @PostMapping("/services/{id}/delete")
//     public String deleteService(@PathVariable("id") Long id) {
//         Service service = serviceRepository.getOne(id);
//         Long venueId = service.getVenue().getId();
//         serviceRepository.delete(service);
//         return "redirect:/venues/" + venueId;
//     }
    
// }

