// package com.example.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.Entity.v_Services;
// import com.example.repository.v_ServiceRepository;

// @Service
// public class v_ServicessService {
    
//     @Autowired
//     v_ServiceRepository v_seviceRepository;

//     // save vendorservices to database
//     public v_Services savServices(v_Services vservices){
//         return v_seviceRepository.save(vservices);
//     }
    
//     // to save all the services

//     public List<v_Services> saveAll(List<v_Services> vservice){
//        return v_seviceRepository.saveAll(vservice);
//     } 


//     // to get all the list of servives like catrain,decor,photo

//     public List<v_Services> getAllservices(){
//         return v_seviceRepository.findAll();
//     }
//     //for admin  to get a service by its id

//     public v_Services getv_ServicesById(Long v_servicesId){
//         return v_seviceRepository.findById(v_servicesId).orElse(null);
//     }

//     // update the services if any 
//     public v_Services updatV_Services(v_Services v_services){
//         v_Services oldV_Services=null;
//         Optional<v_Services> optionalv_Services=v_seviceRepository.findById(v_services.getId());
//         if(optionalv_Services.isPresent()){
//             oldV_Services=optionalv_Services.get();
//             oldV_Services.setName(v_services.getName());
//             oldV_Services.setDescription(v_services.getDescription());
//             v_seviceRepository.save(oldV_Services);

//         }
//         else{
//             return new v_Services();
//         }
//         return oldV_Services;
//     }

//     // to delte the service from database by admin

//     public String deletev_servicesById(Long v_servicesId ){
//         v_seviceRepository.deleteById(v_servicesId);
//         return "Vendor services Deleted Successfully";

//     }
// }
