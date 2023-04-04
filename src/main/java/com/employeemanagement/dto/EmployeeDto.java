package com.employeemanagement.dto;

import com.employeemanagement.enums.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto extends BaseDto {

  private String name;
  private EmployeeType type;
}
