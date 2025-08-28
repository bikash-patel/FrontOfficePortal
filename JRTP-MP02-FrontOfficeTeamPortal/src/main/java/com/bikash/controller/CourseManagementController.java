package com.bikash.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bikash.entity.CourseDetails;
import com.bikash.service.ICourseDetailsService;

@Controller
@RequestMapping("/course")
public class CourseManagementController {

	@Autowired
	private ICourseDetailsService courseSerice;

	@GetMapping({ "/addcourse" })
	public String addEnquiryPage(@ModelAttribute("course") CourseDetails courseDetails, Map<String, Object> map) {
		this.loadSelectData(map);
		return "addcourse";
	}

	@PostMapping({ "/addcourse" })
	public String addEnquiryData(@ModelAttribute("course") CourseDetails courseDetails, RedirectAttributes red) {
		String successMsg = courseSerice.addCourse(courseDetails);
		red.addFlashAttribute("successMsg", successMsg);
		return "redirect:/course/addcourse";
	}

	@GetMapping("/viewcourse")
	public String viewCourses(Model model) {
		List<CourseDetails> courseList = courseSerice.findAll();
		model.addAttribute("courseList", courseList);
		return "/viewcourse";
	}

	@GetMapping("/deletecourse")
	public String deleteCourses(@RequestParam("courseId") Integer courseId, RedirectAttributes red) {
		String successMsg = courseSerice.deleteCourse(courseId);
		red.addFlashAttribute("successMsg", successMsg);
		return "redirect:viewcourse";
	}

	@GetMapping("/editcourse")
	public String showEditCourse(@RequestParam Integer courseId, Model model) {
		CourseDetails course = courseSerice.findCourseById(courseId);
		model.addAttribute("course", course);
		return "editcourse"; // returns editcourse.html
	}

	@PostMapping("/updatecourse")
	public String updateCourse(@ModelAttribute CourseDetails course, RedirectAttributes redirectAttributes) {
		courseSerice.updateCourse(course);
		redirectAttributes.addFlashAttribute("successMsg", "Course updated successfully.");
		return "redirect:viewcourse";
	}

	@GetMapping("/viewcoursepublic")
	public String viewCoursesPublic(Model model) {
		List<CourseDetails> courseList = courseSerice.findAll();
		model.addAttribute("courseList", courseList);
		return "viewcourse-all";
	}

	public void loadSelectData(Map<String, Object> map) {
		List<CourseDetails> courses = courseSerice.findAll();
		map.put("courses", courses);
	}
	
	@GetMapping("/getCourseModes")
	@ResponseBody
	public List<String> getCourseModes(@RequestParam String courseName) {
	    CourseDetails course = courseSerice.findByCourseName(courseName);
	    if (course != null) {
	        return course.getCourseMode();
	    }
	    return List.of(); // empty list if no course found
	}

}
