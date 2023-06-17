// package com.example.Entity;

// import java.util.ArrayList;
// import java.util.List;

// import javax.persistence.CascadeType;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.OneToMany;

// import lombok.Data;

// @Entity
//     @Data
//     public class Venue {
        
//         @Id
//         @GeneratedValue(strategy = GenerationType.AUTO)
//         private Long id;
        
//         private String name;
        
//         private String address;
        
//         @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL, orphanRemoval = true)
//         private List<Service> services = new ArrayList<>();
        
//         // Getters and setters
        
//     }
    
