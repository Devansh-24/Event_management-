// package com.example.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;

// import com.example.Entity.Service;
// import com.example.Entity.Venue;
// import com.example.repository.ServiceRepository;
// import com.example.repository.VenueRepository;

// @Controller
// public class VenueController {
    
//     @Autowired
//     private VenueRepository venueRepository;
    
//     @Autowired
//     private ServiceRepository serviceRepository;
    
//     @GetMapping("/venues")
//     public String listVenues(Model model) {
//         List<Venue> venues = venueRepository.findAll();
//         model.addAttribute("venues", venues);
//         return "venues";
//     }
    
//     @GetMapping("/venues/{id}")
//     public String viewVenue(@PathVariable("id") Long id, Model model) {
//         Venue venue = venueRepository.getOne(id);
//         model.addAttribute("venue", venue);
//         return "venue";
//     }
    
//     @PostMapping("/venues/{id}/services")
//     public String addService(@PathVariable("id") Long id, @ModelAttribute Service service) {
//         Venue venue = venueRepository.getOne(id);
//         service.setVenue(venue);
//         serviceRepository.save(service);
//         return "redirect:/venues/" + id;
//     }
    
//     @PostMapping("/services/{id}/delete")
//     public String deleteService(@PathVariable("id") Long id) {
//         Service service = serviceRepository.getOne(id);
//         Long venueId = service.getVenue().getId();
//         serviceRepository.delete(service);
//         return "redirect:/venues/" + venueId;
//     }
    
// }

