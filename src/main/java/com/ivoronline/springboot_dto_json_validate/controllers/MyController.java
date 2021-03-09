package com.ivoronline.springboot_dto_json_validate.controllers;

import com.ivoronline.springboot_dto_json_validate.DTO.PersonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {

  //==================================================================
  // ADD PERSON
  //==================================================================
  @ResponseBody
  @RequestMapping("/AddPerson")
  public String addPerson(@Valid @RequestBody PersonDTO personDTO) {
    return "Person added";
  }

  //==================================================================
  // HANDLE EXCEPTIONS
  //==================================================================
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleExceptions(MethodArgumentNotValidException notValidEceptions) {

    //CREATE MAP FOR STORING ERRORS
    Map<String, String> errors = new HashMap<>();

    //ITERATE THROUGH ERRORS
    List<ObjectError> objectErrors = notValidEceptions.getBindingResult().getAllErrors();
    for(ObjectError objectError : objectErrors) {

      //GET ERROR
      FieldError fieldError   = (FieldError) objectError;
      String     fieldName    = fieldError.getField();
      String     errorMessage = fieldError.getDefaultMessage();

      //STORE ERROR
      errors.put(fieldName, errorMessage);

    }

    //RETURN ERRORS
    return errors;

  }

}
