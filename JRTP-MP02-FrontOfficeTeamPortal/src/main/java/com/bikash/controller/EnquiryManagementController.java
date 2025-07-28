//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.controller;

import com.bikash.dto.AddEnquiryForm;
import com.bikash.dto.DashboardResponse;
import com.bikash.dto.EditEnquiryForm;
import com.bikash.dto.SearchCriteriaForm;
import com.bikash.entity.EnquiryDetails;
import com.bikash.service.IEnquiryManagementService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EnquiryManagementController {
	@Autowired
	private IEnquiryManagementService enquiryService;
	@Autowired
	private HttpSession session;

	public EnquiryManagementController() {
	}

	@GetMapping({ "/dashboard" })
	public String dashboardPage(Map<String, Object> map, @ModelAttribute("dashboard") DashboardResponse response) {
		DashboardResponse result = this.enquiryService.getDashboard();
		BeanUtils.copyProperties(result, response);
		map.put("response", result);
		return "dashboard";
	}

	@GetMapping({ "/addenquiry" })
	public String addEnquiryPage(@ModelAttribute("enquiry") AddEnquiryForm enquiryForm, Map<String, Object> map) {
		this.loadSelectData(map);
		return "addenquiry";
	}

	@PostMapping({ "/addenquiry" })
	public String addEnquiryData(@ModelAttribute("enquiry") AddEnquiryForm enquiryForm, RedirectAttributes red) {
		String successMsg = this.enquiryService.addEnquiry(enquiryForm);
		red.addFlashAttribute("successMsg", successMsg);
		return "redirect:/addenquiry";
	}

	@GetMapping({ "/editenquirydata" })
	public String editEnquiryPage(@ModelAttribute("enquiry") EditEnquiryForm enquiryForm, Map<String, Object> map) {
		this.loadSelectData(map);
		return "editenquiry";
	}

	@PostMapping({ "/editenquirydata" })
	public String editEnquiryData(@ModelAttribute("enquiry") EditEnquiryForm enquiryForm, RedirectAttributes red) {
		String successMsg = this.enquiryService.editEnquiry(enquiryForm);
		red.addFlashAttribute("successMsg", successMsg);
		return "redirect:/viewenquiry";
	}

	@GetMapping({ "/editenquiry" })
	public String editEnquiryPage(@RequestParam Integer enquiryId,
			@ModelAttribute("enquiry") EditEnquiryForm enquiryForm, Map<String, Object> map) {
		EnquiryDetails enquiryDetails = this.enquiryService.getEditDetails(enquiryId);
		BeanUtils.copyProperties(enquiryDetails, enquiryForm);
		this.loadSelectData(map);
		return "editenquiry";
	}

	@GetMapping({ "/viewenquiry" })
	public String viewEnquiryPage(Map<String, Object> map, @ModelAttribute("successMsg") String successMsg) {
		int id = (Integer) this.session.getAttribute("userId");
		List<EnquiryDetails> details = this.enquiryService.viewEnquiry(id);
		this.loadSelectData(map);
		map.put("enquiryData", details);
		// Add successMsg to map only if it exists
		if (successMsg != null && !successMsg.isEmpty()) {
			map.put("successMsg", successMsg);
		}

		return "viewenquiry";
	}

	@GetMapping({ "/viewenquiry-filter" })
	public String viewEnquiryPageWithFilter(Map<String, Object> map, @ModelAttribute SearchCriteriaForm searchForm) {
		int id = (Integer) this.session.getAttribute("userId");
		List<EnquiryDetails> details = this.enquiryService.viewEnquiryWithFiltered(id, searchForm);
		this.loadSelectData(map);
		map.put("enquiryData", details);
		return "viewenquiryfilter";
	}

	public void loadSelectData(Map<String, Object> map) {
		List<String> courses = this.enquiryService.getCourses();
		List<String> status = this.enquiryService.getStatus();
		map.put("courses", courses);
		map.put("statuses", status);
	}
}
