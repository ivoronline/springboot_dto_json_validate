package com.ivoronline.springboot_dto_json_validate.DTO;

import org.springframework.stereotype.Component;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public class PersonDTO {

  @NotBlank(message = "Name is mandatory")                  //@NotBlank()
  @Size(min=5, max=30)                                      //characters
  public String name;

  @NotNull                                                  //"must not be null"
  @Min(value = 18, message = "Minimum value for Age is 18") //@Min(18)
  public Integer age;

}
