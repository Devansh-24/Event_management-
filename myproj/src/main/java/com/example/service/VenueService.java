// package com.example.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.Entity.Venue;
// import com.example.repository.VenueRepository;

// @Service
// public class VenueService {
    
//     @Autowired
//     private VenueRepository venueRepository;
    
//     public List<Venue> getAllVenues() {
//         return venueRepository.findAll();
//     }
    
//     public Venue getVenueById(Long id) {
//         return venueRepository.getOne(id);
//     }
    
//     public Venue saveVenue(Venue venue) {
//         return venueRepository.save(venue);
//     }
    
//     public void deleteVenue(Long id) {
//         venueRepository.deleteById(id);
//     }
    
//     public Service addService(Long venueId, String name, String description) {
//         Venue venue = getVenueById(venueId);
//         Service service = new Service(name, description, venue);
//         venue.getServices().add(service);
//         saveVenue(venue);
//         return service;
//     }
    
// }

// }
