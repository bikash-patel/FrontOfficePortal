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
import com.bikash.entity.UserAccount;
import com.bikash.repository.CourseDetailsRepo;
import com.bikash.repository.EnquiryDetailsRepo;
import com.bikash.repository.EnquiryStatusRepo;
import com.bikash.repository.UserAccountRepo;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class EnquiryManagementServiceImpl implements IEnquiryManagementService {
    @Autowired
    private EnquiryDetailsRepo repo;
    @Autowired
    private CourseDetailsRepo courseRepo;
    @Autowired
    private EnquiryStatusRepo statusRepo;
    @Autowired
    private UserAccountRepo userRepo;
    @Autowired
    private HttpSession session;

    public EnquiryManagementServiceImpl() {
    }

    public DashboardResponse getDashboard() {
        Integer id = (Integer)this.session.getAttribute("userId");
        Optional<UserAccount> opt = this.userRepo.findById(id);
        List<EnquiryDetails> listEnquiry = null;
        if (opt.isPresent()) {
            UserAccount account = (UserAccount)opt.get();
            listEnquiry = account.getEnquiry();
        }

        Integer totalEnquiry = listEnquiry != null ? listEnquiry.size() : 0;
        Long enrolledStudent = listEnquiry != null ? listEnquiry.stream().filter((list) -> {
            return list.getEnquiryStatus().equalsIgnoreCase("ENROLLED");
        }).count() : 0L;
        Long lostStudent = listEnquiry != null ? listEnquiry.stream().filter((list) -> {
            return list.getEnquiryStatus().equalsIgnoreCase("LOST");
        }).count() : 0L;
        DashboardResponse response = new DashboardResponse();
        response.setTotalEnquiry(totalEnquiry);
        response.setEnrollStudent(enrolledStudent);
        response.setLostStudent(lostStudent);
        return response;
    }

    public String addEnquiry(AddEnquiryForm addForm) {
        EnquiryDetails details = new EnquiryDetails();
        BeanUtils.copyProperties(addForm, details);
        details.setEnquiryDate(LocalDate.now());
        Optional<UserAccount> optAcc = this.userRepo.findById((Integer)this.session.getAttribute("userId"));
        if (optAcc.isPresent()) {
            UserAccount account = (UserAccount)optAcc.get();
            details.setUserAcccount(account);
        }

        this.repo.save(details);
        return "Enquiry details saved";
    }

    public String editEnquiry(EditEnquiryForm addForm) {
        Optional<EnquiryDetails> opt = this.repo.findById(addForm.getEnquiryId());
        if (opt.isPresent()) {
            EnquiryDetails details = (EnquiryDetails)opt.get();
            BeanUtils.copyProperties(addForm, details);
            this.repo.save(details);
        }

        return "Details updated";
    }

    public List<EnquiryDetails> viewEnquiry(Integer id) {
        Optional<UserAccount> opt = this.userRepo.findById(id);
        if (opt.isPresent()) {
            UserAccount account = (UserAccount)opt.get();
            return account.getEnquiry();
        } else {
            return Collections.emptyList();
        }
    }

    public List<EnquiryDetails> viewEnquiryWithFiltered(Integer id, SearchCriteriaForm searchCriteria) {
        EnquiryDetails enquiryDetails = new EnquiryDetails();
        if (searchCriteria.getCourseName() != null && searchCriteria.getCourseName() != "") {
            enquiryDetails.setCourseName(searchCriteria.getCourseName());
        }

        if (searchCriteria.getEnquiryStatus() != null && searchCriteria.getEnquiryStatus() != "") {
            enquiryDetails.setEnquiryStatus(searchCriteria.getEnquiryStatus());
        }

        if (searchCriteria.getClassMode() != null && searchCriteria.getClassMode() != "") {
            enquiryDetails.setClassMode(searchCriteria.getClassMode());
        }

        Optional<UserAccount> account = this.userRepo.findById(id);
        if (account.isPresent()) {
            enquiryDetails.setUserAcccount((UserAccount)account.get());
        }

        return this.repo.findAll(Example.of(enquiryDetails));
    }

    public String addCourse(CourseDetails details) {
        int id = ((CourseDetails)this.courseRepo.save(details)).getCourseId();
        return "Course added with id " + id;
    }

    public String addStatus(EnquiryStatus status) {
        int id = ((EnquiryStatus)this.statusRepo.save(status)).getEnquiryId();
        return "Status added with id " + id;
    }

    public List<String> getStatus() {
        return this.statusRepo.getStatus();
    }

    public List<String> getCourses() {
        return this.courseRepo.getCourses();
    }

    public EnquiryDetails getEditDetails(Integer id) {
        Optional<EnquiryDetails> opt = this.repo.findById(id);
        EnquiryDetails enquiryDetails = null;
        if (opt.isPresent()) {
            enquiryDetails = (EnquiryDetails)opt.get();
        }

        return enquiryDetails;
    }
}
