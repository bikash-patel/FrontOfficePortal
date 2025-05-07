//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.repository;

import com.bikash.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {
    UserAccount findByMailId(String mail);

    UserAccount findByMailIdAndPassword(String mail, String password);
}
