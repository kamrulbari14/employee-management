package com.employeemanagement.service;

import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.dto.Response;
import com.employeemanagement.entity.Employee;
import com.employeemanagement.repository.EmployeeRepository;
import com.employeemanagement.util.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeService {

  private final EmployeeRepository repository;
  private final ModelMapper modelMapper;

  public Response saveEmployee(EmployeeDto employeeDto) {
    Employee employee = modelMapper.map(employeeDto, Employee.class);
    repository.save(employee);
    return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Saved successfully!!", "");
  }

  public Response getAllEmployee() {
    return ResponseBuilder.getSuccessResponse(HttpStatus.OK,"Retrieved",repository.findAll());
  }
}
