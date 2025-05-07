//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.service;

import com.bikash.dto.AddEnquiryForm;
import com.bikash.dto.DashboardResponse;
import com.bikash.dto.EditEnquiryForm;
import com.bikash.dto.SearchCriteriaForm;
import com.bikash.entity.CourseDetails;
import com.bikash.entity.EnquiryDetails;
import com.bikash.entity.EnquiryStatus;
import java.util.List;

public interface IEnquiryManagementService {
    DashboardResponse getDashboard();

    String addEnquiry(AddEnquiryForm addForm);

    String editEnquiry(EditEnquiryForm editForm);

    List<EnquiryDetails> viewEnquiry(Integer id);

    List<EnquiryDetails> viewEnquiryWithFiltered(Integer id, SearchCriteriaForm searchCriteria);

    String addStatus(EnquiryStatus status);

    String addCourse(CourseDetails details);

    List<String> getStatus();

    List<String> getCourses();

    EnquiryDetails getEditDetails(Integer id);
}
