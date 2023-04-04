package com.employeemanagement.entity;

import com.employeemanagement.enums.EmployeeType;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee extends BaseEntity {

  private String name;
  private EmployeeType type;
}
