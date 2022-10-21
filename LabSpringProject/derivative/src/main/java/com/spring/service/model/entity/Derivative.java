package com.spring.service.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "derivative" , uniqueConstraints = {@UniqueConstraint(columnNames = "derivative_code")})
public class Derivative {

    @Column(name = "deri_composite_code",unique = true,nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9]*")
    private String deriCode;
    @Id
    @Column(name = "derivative_code",unique = true,nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9]*")
    private String code;

    @Column(name = "effective_date")
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String effectiveDate;

    @Column(name = "expiration_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expirationDate;

    @Column(name = "created_date")
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Transient
    private Date createdDate;

    @Column(name = "created_by")
    @Transient
    private String createBy;

    @Column(name = "modified_date")
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Transient
    private Date modifiedDate;

    @Column(name = "modified_by")
    @Transient
    private String modifiedBy;

    @Column(name = "underlying_type")
    private String underlyingType;

    public String getDeriCode() {
        return deriCode;
    }

    public void setDeriCode(String deriCompositeCode) {
        this.deriCode = deriCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }



    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }



    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }



    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }



    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getUnderlyingType() {
        return underlyingType;
    }

    public void setUnderlyingType(String underlyingType) {
        this.underlyingType = underlyingType;
    }

    public Derivative() {
    }
}
