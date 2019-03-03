package org.bytewright.springbootvue.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Column
  private Integer age;
  @Column(nullable = false)
  private String city;
  @Column(nullable = false)
  private String goRank;
  @Column
  private String gender;
  @Column(name = "student")
  private Boolean isStudent;
  @Column(name = "reduced_fee")
  private Boolean isReducedFee;
  @Column(name = "club_member")
  private Boolean isClubMember;

  @PrePersist
  void preInsert() {
    if (this.isStudent == null) {
      this.isStudent = false;
    }
    if (this.isReducedFee == null) {
      this.isReducedFee = false;
    }
    if (this.isClubMember == null) {
      this.isClubMember = false;
    }
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getGoRank() {
    return goRank;
  }

  public void setGoRank(String goRank) {
    this.goRank = goRank;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Boolean getStudent() {
    return isStudent;
  }

  public void setStudent(Boolean student) {
    isStudent = student;
  }

  public Boolean getReducedFee() {
    return isReducedFee;
  }

  public void setReducedFee(Boolean reducedFee) {
    isReducedFee = reducedFee;
  }

  public Boolean getClubMember() {
    return isClubMember;
  }

  public void setClubMember(Boolean clubMember) {
    isClubMember = clubMember;
  }

}
