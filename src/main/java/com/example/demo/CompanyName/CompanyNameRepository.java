package com.example.demo.CompanyName;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyNameRepository extends JpaRepository<CompanyName,Integer> {
    //@Query("select u from companyname u where u.domainName = ?1")
    List<CompanyName> findByDomainName(String domainName);
}
