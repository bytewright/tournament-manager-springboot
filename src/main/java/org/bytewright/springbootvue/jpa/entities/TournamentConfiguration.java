package org.bytewright.springbootvue.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tournament_configuration")
public class TournamentConfiguration {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private Integer roundCount = 5;
  @Column(nullable = false)
  private String locationAddress;
  @Column(nullable = false)
  private String pageUrl;
  @Column(nullable = false)
//  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private String startDate;
  @Column(nullable = false)
//  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private String endDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getRoundCount() {
    return roundCount;
  }

  public void setRoundCount(Integer roundCount) {
    this.roundCount = roundCount;
  }

  public String getLocationAddress() {
    return locationAddress;
  }

  public void setLocationAddress(String locationAddress) {
    this.locationAddress = locationAddress;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "TournamentConfiguration{" +
            "id=" + id +
            ", Name='" + name + '\'' +
            ", Start=" + startDate +
            ", End=" + endDate +
            '}';
  }

  public String getPageUrl() {
    return pageUrl;
  }

  public void setPageUrl(String pageUrl) {
    this.pageUrl = pageUrl;
  }
}
