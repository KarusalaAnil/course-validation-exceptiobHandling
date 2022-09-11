package com.springboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.annotation.CourseTypeValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDTO {

    @NotNull(message = "Please Enter Name of course")
    private String name;
    @NotEmpty(message = "Trainer name is mandatory")
    private String trainerName;
    @NotBlank(message = "duration is Required")
    private String duration;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @Past(message = "start date can't be before date from current")
    private Date startDate;
    @CourseTypeValidation
    private String courseType;
    @Min(value = 1500, message = "course price can't be less than 1500")
    @Max(value = 5000, message = "course price can't be more than 5000")
    private double fees;
    private boolean isCertificateAvailable;
    @NotEmpty(message = "description must be present")
    @Length(min = 5,max = 10)
    private String description;
    @Email(message = "invalid email")
    private String email;
    @Pattern(regexp = "^[0-9]{10}$")
    private String contact;
}
