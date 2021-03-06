package com.hotel.Entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "user_name")
    private String userName;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "apartments_id")
    private Apartments apartments;

    public Reservation(Date startDate, Date endDate, String userName) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.userName = userName;
    }

    public Reservation(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Reservation(LocalDate startDate, LocalDate endDate) {
        this.startDate = Date.valueOf(startDate);
        this.endDate = Date.valueOf(endDate);
    }

    public Reservation(Date startDate, Date endDate, Apartments apartments) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.apartments = apartments;
    }

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public void setLocalStartDate(LocalDate startDate) {
        Date date = Date.valueOf(startDate);
        this.startDate = date;
    }


    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public void setLocalEndDate(LocalDate endDate) {
        Date date = Date.valueOf(endDate);
        this.endDate = date;
    }

    public Apartments getApartments() {
        return apartments;
    }

    public void setApartments(Apartments apartments) {
        this.apartments = apartments;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;

        Reservation that = (Reservation) o;

        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        return apartments != null ? apartments.equals(that.apartments) : that.apartments == null;
    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (apartments != null ? apartments.hashCode() : 0);
        return result;
    }
}
