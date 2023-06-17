// package com.example.configuration;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
// import org.springframework.security.web.DefaultRedirectStrategy;
// import org.springframework.security.web.RedirectStrategy;
// import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
// import org.springframework.stereotype.Component;

// import com.example.Entity.Customer;
// import com.example.repository.CustomerRepository;
// import com.example.repository.RoleRepository;

// @Component
// public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler {
//     @Autowired
//     RoleRepository roleRepository;
//     @Autowired
//    CustomerRepository CustomerRepository;

//    private RedirectStrategy redirectStrategy= new DefaultRedirectStrategy();

//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse,Authentication authentication) throws IOException,servletException{
//        OAuth2AuthenticationToken token= (OAuth2AuthenticationToken) authentication;
//        String custId=token.getPrincipal().getAttributes().get(custId);
//        if(CustomerRepository.findById(custId).isPresent()){

//        }
//        else{
//         Customer cust=new Custmer();
//         cust.setCustName(token.getPrincipal().getAuthorities().get("given_name").toString());
//         cust.setCustEmail(token.getPrincipal().getAuthorities().get("given_add").toString());
//         cust.setCustMob(token.getPrincipal().getAuthorities().get("given_value").toString());
//         cust.setCustPass(token.getPrincipal().getAuthorities().get("given_pval").toString());
//         List<Role> roles=new ArrayList<>();
//         roles.add(roleRepository.findById(2).get());
//         roles.add(roleRepository.findById(3).get());
//         cust.setRoles(roles);
//         CustomerRepository.save(cust);

//        }
//     //    used to redirect user internally
//        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse , "/");
//    }

//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse) throws IOException{

//     }

//  } 