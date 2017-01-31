package com.oblenergo.model;

import com.oblenergo.enums.StatusOrderEnum;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

  private static final long serialVersionUID = 7191453677142422700L;

  private int id;
  private WorkType workType;
  private String user_tab;
  private String customer;
  private Car car;
  private String car_model;
  private String car_number;
  private Integer performer_id;
  private String date;
  private String time;
  private String time_end;
  private int count;
  private String mobile_phone_number;
  private String all_sum;
  private String bill_number;
  private StatusOrderEnum status_order = StatusOrderEnum.valueOf("NEW");
  private String second_email;

  // getters
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  @ManyToOne(optional = false)
  @JoinColumn(name = "name_servise_id", referencedColumnName = "id")
  public WorkType getWorkType() {
    return workType;
  }

  @NotBlank
  @Size(min = 4, max = 5)
  @Column(name = "user_tab")
  public String getUser_tab() {
    return user_tab;
  }

  @Column(name = "customer")
  public String getCustomer() {
    return customer;
  }

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "car_name_id", referencedColumnName = "id")
  public Car getCar() {
    return car;
  }

  @NotBlank
  @Column(name = "car_model")
  public String getCar_model() {
    return car_model;
  }

  @NotBlank
  @Column(name = "car_number")
  public String getCar_number() {
    return car_number;
  }

  @Column(name = "performer_id")
  public Integer getPerformer_id() {
    return performer_id;
  }

  @NotBlank
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "date")
  public String getDate() {
    return date;
  }

  @Column(name = "time")
  public String getTime() {
    return time;
  }

  @Column(name = "time_end")
  public String getTime_end() {
    return time_end;
  }

  @Column(name = "count")
  public int getCount() {
    return count;
  }

  @Enumerated(EnumType.STRING)
  @Column(name = "status_order")
  public StatusOrderEnum getStatus_order() {
    return status_order;
  }

  @NotBlank
  @Size(max = 13, min = 13)
  @Column(name = "mobile_phone_number")
  public String getMobile_phone_number() {
    return mobile_phone_number;
  }

  @Column(name = "all_sum")
  public String getAll_sum() {
    return all_sum;
  }

  @Column(name = "bill_number")
  public String getBill_number() {
    return bill_number;
  }

  @Column(name = "second_email")
  public String getSecond_email(){ return second_email; }

  // setters

  public void setId(int id) {
    this.id = id;
  }

  public void setWorkType(WorkType workType) {
    this.workType = workType;
  }

  public void setUser_tab(String user_tab) {
    this.user_tab = user_tab;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public void setCar_model(String car_model) {
    this.car_model = car_model;
  }

  public void setCar_number(String car_number) {
    this.car_number = car_number;
  }

  public void setPerformer_id(Integer performer_id) {
    this.performer_id = performer_id;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public void setTime_end(String time_end) {
    this.time_end = time_end;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public void setStatus_order(StatusOrderEnum status_order) {
    this.status_order = status_order;
  }

  public void setMobile_phone_number(String mobile_phone_number) {
    this.mobile_phone_number = mobile_phone_number;
  }

  public void setAll_sum(String all_sum) {
    this.all_sum = all_sum;
  }

  public void setBill_number(String bill_number) {
    this.bill_number = bill_number;
  }

  public void setSecond_email(String second_email) {this.second_email = second_email; }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this, true);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj, true);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}