package com.health_declaration.model;

import java.util.List;

public class HealthDeclaration {
    private String name;
    private String dayOfBirth;
    private String gender;
    private String nationality;
    private String idCard;
    private String transport;
    private String idTransport;
    private String seats;
    private String startDate;
    private String endDate;
    private String moreDescription;

    public HealthDeclaration() {
    }

    public HealthDeclaration(String name,
                             String dayOfBirth,
                             String gender,
                             String nationality,
                             String idCard,
                             String transport,
                             String idTransport,
                             String seats,
                             String startDate,
                             String endDate,
                             String moreDescription) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.transport = transport;
        this.idTransport = idTransport;
        this.seats = seats;
        this.startDate = startDate;
        this.endDate = endDate;
        this.moreDescription = moreDescription;
    }

    public String getMoreDescription() {
        return moreDescription;
    }

    public void setMoreDescription(String moreDescription) {
        this.moreDescription = moreDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(String idTransport) {
        this.idTransport = idTransport;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
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
}
