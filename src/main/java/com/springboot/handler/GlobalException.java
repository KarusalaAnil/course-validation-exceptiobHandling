package com.springboot.handler;

import com.springboot.dto.ErrorDTO;
import com.springboot.dto.ServiceResponse;
import com.springboot.exception.CourseServiceBusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalException {
//    MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServiceResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        List<ErrorDTO> errorDTOList = new ArrayList<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error  ->{
                        errorDTOList.add(new ErrorDTO(error.getDefaultMessage()+" "+error.getField()));
                });
        serviceResponse.setStatus(HttpStatus.BAD_REQUEST);
        serviceResponse.setError(errorDTOList);
//        serviceResponse.getError().stream().forEach(errorDTO -> System.out.println(errorDTO));
        return serviceResponse;
    }

    @ExceptionHandler(CourseServiceBusinessException.class)
    public ResponseEntity<?> handleBusinessException(CourseServiceBusinessException exception){
        return new ResponseEntity<>(new ErrorDTO(exception.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
