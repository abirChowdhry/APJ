package com.domain;

import javax.persistence.*;

@Entity
@Table(name = "LeaveType")
public class LeaveType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "l_id")
    private LeaveApplication leave_id;

    @ManyToOne
    @JoinColumn(name = "l_id")
    private LeaveApplication totalDays;

    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LeaveApplication getLeave_id() {return leave_id;}

    public void setLeave_id(LeaveApplication leave_id) {this.leave_id = leave_id;}

    public void setTotalDays(LeaveApplication totalDays) {this.totalDays = totalDays;}

    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}

    public LeaveApplication getTotalDays() {return totalDays;}
}
