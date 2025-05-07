//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.repository;

import com.bikash.entity.EnquiryStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnquiryStatusRepo extends JpaRepository<EnquiryStatus, Integer> {
    @Query("SELECT status FROM EnquiryStatus")
    List<String> getStatus();
}
