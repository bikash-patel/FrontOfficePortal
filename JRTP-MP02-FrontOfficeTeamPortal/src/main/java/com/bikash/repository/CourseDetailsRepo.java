//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.repository;

import com.bikash.entity.CourseDetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseDetailsRepo extends JpaRepository<CourseDetails, Integer> {
    @Query("SELECT courseName FROM CourseDetails")
    List<String> getCourses();
}
