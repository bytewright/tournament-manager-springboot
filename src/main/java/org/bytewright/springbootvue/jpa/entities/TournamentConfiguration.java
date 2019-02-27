package org.bytewright.springbootvue.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tournament_configuration")
public class TournamentConfiguration {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String tournamentName;
  @Column(nullable = false)
  private Integer tournamentRoundCount;
  @Column(nullable = false)
  private String locationAddress;
  @Column(nullable = false)
  private LocalDateTime tournamentStart;
  @Column(nullable = false)
  private LocalDateTime tournamentEnd;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTournamentName() {
    return tournamentName;
  }

  public void setTournamentName(String tournamentName) {
    this.tournamentName = tournamentName;
  }

  public Integer getTournamentRoundCount() {
    return tournamentRoundCount;
  }

  public void setTournamentRoundCount(Integer tournamentRoundCount) {
    this.tournamentRoundCount = tournamentRoundCount;
  }

  public String getLocationAddress() {
    return locationAddress;
  }

  public void setLocationAddress(String locationAddress) {
    this.locationAddress = locationAddress;
  }

  public LocalDateTime getTournamentStart() {
    return tournamentStart;
  }

  public void setTournamentStart(LocalDateTime tournamentStart) {
    this.tournamentStart = tournamentStart;
  }

  public LocalDateTime getTournamentEnd() {
    return tournamentEnd;
  }

  public void setTournamentEnd(LocalDateTime tournamentEnd) {
    this.tournamentEnd = tournamentEnd;
  }
}
