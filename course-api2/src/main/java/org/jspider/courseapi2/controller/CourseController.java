package org.jspider.courseapi2.controller;

import org.jspider.courseapi2.model.Course;
import org.jspider.courseapi2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService service;
@PostMapping("/courses")
    public void addCourse(@RequestBody Course c){
        service.addCourse(c);
    }
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return service.getAllCourses();
    }
    @PutMapping("/courses")
    public void updateCourse(@RequestBody Course c){
    service.updateCourse(c);
    }
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable(value = "id") int id){
    service.deleteCourse(id);
    }
}
