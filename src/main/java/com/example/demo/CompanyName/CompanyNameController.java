package com.example.demo.CompanyName;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CompanyNameController {
    @Autowired
    private CompanyNameRepository companyNameRepository;

    @GetMapping(value="/companyName")
    public List<CompanyName> getCompanyName(@RequestParam(value = "domainName" ,required = true) String domainName ){
        return  companyNameRepository.findByDomainName(domainName);
    }
}



