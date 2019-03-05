package org.bytewright.springbootvue.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tournaments")
public class Tournament extends BasicEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String pageUrlPath;
    @Column(nullable = false)
    private Integer roundCount = 5;
    @Column(nullable = false)
    private String locationAddress;

    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;
    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDate;

    @ManyToOne
    private User creator;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPageUrlPath() {
        return pageUrlPath;
    }

    public void setPageUrlPath(String pageUrlPath) {
        this.pageUrlPath = pageUrlPath;
    }

    public Integer getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(Integer roundCount) {
        this.roundCount = roundCount;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + super.getId() +
                ", Name='" + name + '\'' +
                ", Start=" + startDate +
                ", End=" + endDate +
                '}';
    }
}
