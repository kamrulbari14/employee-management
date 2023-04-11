package com.employeemanagement.controller;

import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.dto.Response;
import com.employeemanagement.service.EmployeeService;
import com.employeemanagement.util.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.employeemanagement.advice.FieldBindingErrors.fieldError;
import static com.employeemanagement.enums.EmployeeType.findByName;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/save-employee")
    public Response saveEmployee(@Valid @RequestBody EmployeeDto employeeDto, BindingResult result) {
        if (!findByName(employeeDto.getType())) {
            fieldError(result, employeeDto.getType(), "Field 'type' should be a valid enum type");
        }
        if (result.hasErrors()) {
            return ResponseBuilder.getFailureResponse(result,
                    "Please provide valid input");
        }
        return service.saveEmployee(employeeDto);
    }

    @GetMapping("/get-employee")
    public Response saveEmployee() {
        return service.getAllEmployee();
    }
}
