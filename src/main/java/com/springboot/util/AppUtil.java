package com.springboot.miscroserice.course.util;

import com.springboot.miscroserice.course.dto.CourseRequestDTO;
import com.springboot.miscroserice.course.dto.CourseResponseDTO;
import com.springboot.miscroserice.course.modal.CourseEntity;

import java.util.UUID;

public class AppUtil {
    public static CourseEntity convertRequestToEntity(CourseRequestDTO courseRequestDTO) {
        CourseEntity courseEntity = new CourseEntity();
//        courseEntity.setCourseId();
        courseEntity.setName(courseRequestDTO.getName());
        courseEntity.setTrainerName(courseRequestDTO.getTrainerName());
        courseEntity.setDuration(courseRequestDTO.getDuration());
        courseEntity.setStartDate(courseRequestDTO.getStartDate());
        courseEntity.setCourseType(courseRequestDTO.getCourseType());
        courseEntity.setFees(courseRequestDTO.getFees());
        courseEntity.setCertificateAvailable(courseRequestDTO.isCertificateAvailable());
        courseEntity.setDescription(courseRequestDTO.getDescription());
        return courseEntity;

    }

    public static CourseResponseDTO convertEntityToResponse(CourseEntity entity) {
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setCourseId(entity.getCourseId());
        courseResponseDTO.setName(entity.getName());
        courseResponseDTO.setTrainerName(entity.getTrainerName());
        courseResponseDTO.setDuration(entity.getDuration());
        courseResponseDTO.setStartDate(entity.getStartDate());
        courseResponseDTO.setCourseType(entity.getCourseType());
        courseResponseDTO.setFees(entity.getFees());
        courseResponseDTO.setCertificateAvailable(entity.isCertificateAvailable());
        courseResponseDTO.setDescription(entity.getDescription());
        courseResponseDTO.setCourseUniqueCode(UUID.randomUUID().toString().split("-")[0]);
//        courseResponseDTO.setCourseUniqueCode();
        return courseResponseDTO;

    }
}
