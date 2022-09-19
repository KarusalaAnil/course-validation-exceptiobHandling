package com.springboot.controller;

import com.springboot.dto.CourseRequestDTO;
import com.springboot.dto.CourseResponseDTO;
import com.springboot.dto.ServiceResponse;
import com.springboot.modal.CourseEntity;
import com.springboot.services.CourseService;
import com.springboot.util.AppUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger; // logger
import org.slf4j.LoggerFactory; //logger
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController {

//    Logger log = LoggerFactory.getLogger(CourseController.class);
    @Autowired
    private CourseService courseService;
    @PostMapping
    @Operation(summary = "Course Application Adding")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Adding Course Information",
                    content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = CourseController.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ServiceResponse<?>  addCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO) {

        log.info("Course Controller begin:: addCourse ");

        CourseResponseDTO courseResponseDTO = courseService.save(courseRequestDTO);
        log.info("Course Controller ended:: addCourse "+HttpStatus.CREATED);
        getLoggerDetails();
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

    public void getLoggerDetails() {
        log.trace("trace message");
        log.debug("debug message");
        log.info("info message");
        log.warn("warn message");
        log.error("error message");
    }


}
