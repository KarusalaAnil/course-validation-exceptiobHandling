package com.springboot.controller;

import com.springboot.dto.CourseRequestDTO;
import com.springboot.dto.CourseResponseDTO;
import com.springboot.dto.ServiceResponse;
import com.springboot.modal.CourseEntity;
import com.springboot.services.CourseService;
import com.springboot.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @PostMapping
    public ServiceResponse<?>  addCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO) {

        CourseResponseDTO courseResponseDTO = courseService.save(courseRequestDTO);
        return new ServiceResponse<>(HttpStatus.CREATED ,courseResponseDTO); // 201

    }
    @GetMapping
    public ResponseEntity<?> findAllCourse(){
        List<CourseResponseDTO> courseResponseDTOList= courseService.viewAllCourse();
        return new ResponseEntity<>(courseResponseDTOList , HttpStatus.OK);
    }
    @GetMapping("/find/{courseId}")
    public ServiceResponse<CourseResponseDTO> findCourse(@PathVariable("courseId") int courseId){
        return new ServiceResponse<> ( HttpStatus.OK,courseService.getCourseDetails(courseId));
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<?> updateCourse(@RequestBody CourseRequestDTO requestDTO ,
                                          @PathVariable int courseId) {
        return new ResponseEntity<>(courseService.updateCourseDetails(requestDTO , courseId) , HttpStatus.OK);
    }

    @DeleteMapping("{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable int courseId) {
        courseService.removeCourse(courseId);
        return new ResponseEntity<>("Course Deleted successfully "+courseId,HttpStatus.OK);
    }


}
