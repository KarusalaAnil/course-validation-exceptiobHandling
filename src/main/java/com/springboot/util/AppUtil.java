package com.springboot.util;

import com.springboot.dto.CourseRequestDTO;
import com.springboot.dto.CourseResponseDTO;
import com.springboot.modal.CourseEntity;

import java.util.UUID;

public class AppUtil {
    public static CourseEntity convertRequestToEntity(CourseRequestDTO courseRequestDTO) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(courseRequestDTO.getName());
        courseEntity.setTrainerName(courseRequestDTO.getTrainerName());
        courseEntity.setDuration(courseRequestDTO.getDuration());
        courseEntity.setStartDate(courseRequestDTO.getStartDate());
        courseEntity.setCourseType(courseRequestDTO.getCourseType());
        courseEntity.setFees(courseRequestDTO.getFees());
        courseEntity.setCertificateAvailable(courseRequestDTO.isCertificateAvailable());
        courseEntity.setDescription(courseRequestDTO.getDescription());
        courseEntity.setEmail(courseRequestDTO.getEmail());
        courseEntity.setContact(courseRequestDTO.getContact());
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
        courseResponseDTO.setEmail(entity.getEmail());
        courseResponseDTO.setContact(entity.getContact());
        courseResponseDTO.setCourseUniqueCode(UUID.randomUUID().toString().split("-")[0]);
        return courseResponseDTO;

    }
}
