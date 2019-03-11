package org.bytewright.springbootvue.model;

import org.bytewright.springbootvue.jpa.entities.Tournament;

import java.time.LocalDateTime;

public class TournamentDto {

    public String name;
    public LocalDateTime startDate;
    public LocalDateTime endDate;
    public String address;
    public Integer roundCount;
    public String pageUrlPath;

    public TournamentDto(Tournament tournament) {
        name = tournament.getName();
        startDate = tournament.getStartDate();
        endDate = tournament.getEndDate();
        address = tournament.getLocationAddress();
        roundCount = tournament.getRoundCount();
        pageUrlPath = tournament.getPageUrlPath();
    }
}
