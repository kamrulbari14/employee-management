package com.employeemanagement.dto;

import java.util.Date;
import lombok.Data;

@Data
public class BaseDto {
    private Long id;
    private String createdBy;
    private Date createdAt;
    private String updatedBy;
    private Date updateAt;
    private Integer activeStatus;

}
