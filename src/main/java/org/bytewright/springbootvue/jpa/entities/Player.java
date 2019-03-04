package org.bytewright.springbootvue.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player extends BasicEntity {

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private Integer age = 18;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String goRank = "25k";
    @Column
    private String gender;
    @Column(name = "student")
    private Boolean isStudent;
    @Column(name = "reduced_fee")
    private Boolean isReducedFee;
    @Column(name = "club_member")
    private Boolean isClubMember;

    @ManyToOne
    @Column(nullable = false)
    private Tournament tournament;

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

    public Boolean getClubMember() {
        return isClubMember;
    }

    public void setClubMember(Boolean clubMember) {
        isClubMember = clubMember;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGoRank() {
        return goRank;
    }

    public void setGoRank(String goRank) {
        this.goRank = goRank;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getReducedFee() {
        return isReducedFee;
    }

    public void setReducedFee(Boolean reducedFee) {
        isReducedFee = reducedFee;
    }

    public Boolean getStudent() {
        return isStudent;
    }

    public void setStudent(Boolean student) {
        isStudent = student;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
