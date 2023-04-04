package com.employeemanagement.controller;

import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.dto.Response;
import com.employeemanagement.service.EmployeeService;
import com.employeemanagement.util.ResponseBuilder;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

  private final EmployeeService service;

  @PostMapping("/save-employee")
  public Response saveEmployee(@Valid @RequestBody EmployeeDto employeeDto, BindingResult result) {
    if (result.hasErrors()) {
      return ResponseBuilder.getSuccessResponse(HttpStatus.NOT_ACCEPTABLE,
          "Please provide valid input", null);
    }
    return service.saveEmployee(employeeDto);
  }

  @GetMapping("/get-employee")
  public Response saveEmployee() {
    return service.getAllEmployee();
  }
}
