package com.employeemanagement.entity;

import com.employeemanagement.enums.ActiveStatus;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(updatable = false)
  private String createdBy;
  @Column(updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;
  private String updatedBy;
  @Temporal(TemporalType.TIMESTAMP)
  private Date updateAt;
  private Integer activeStatus;

  @PrePersist
  public void setPreInsertData() {
    this.createdAt = new Date();
    if (this.activeStatus == null) {
      this.activeStatus = ActiveStatus.ACTIVE.getValue();
    }
  }

  @PreUpdate
  public void setPreUpdateData() {
    this.updateAt = new Date();
    this.activeStatus = ActiveStatus.ACTIVE.getValue();
  }
}
