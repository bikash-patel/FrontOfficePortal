//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.repository;

import com.bikash.entity.EnquiryDetails;
import com.bikash.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnquiryDetailsRepo extends JpaRepository<EnquiryDetails, Integer> {
    UserAccount findByUserAcccount(UserAccount account);
}
