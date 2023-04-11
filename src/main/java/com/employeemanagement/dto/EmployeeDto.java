package com.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto extends BaseDto {

    @NotBlank(message = "The field can not be blank!!")
    private String name;
    private String type;
}
