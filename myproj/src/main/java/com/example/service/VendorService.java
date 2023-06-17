// package com.example.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.Entity.Venue;
// import com.example.repository.ServiceRepository;

// @Service
// public class VendorService {
    
//     @Autowired
//     private ServiceRepository serviceRepository;
    
//     public List<Service> getAllService() {
//         return serviceRepository.findAll();
//     }
    
//     public Service getServiceById(Long id) {
//         return serviceRepository.getOne(id);
//     }
    
//     public  Service saveService(Service service) {
//         return serviceRepository.save(service);
//     }
    
//     public void deleteService(Long id) {
//         serviceRepository.deleteById(id);
//     }
    
// }


