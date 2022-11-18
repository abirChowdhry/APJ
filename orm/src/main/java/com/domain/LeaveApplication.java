package com.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leaveApplication")
public class LeaveApplication {
    @Id
    @Column(name = "l_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "e_id")
    private Employee e_id;

    private LocalDate fromLeaveDate;

    private LocalDate toLeaveDate;

    private int totalLeaveDays;

    private  String reason;

    public Long getId(){return id;}

    public void setId(Long id) {this.id = id;}

    public Employee getE_id() {return e_id;}

    public void setE_id(Employee e_id) {this.e_id = e_id;}

    public LocalDate getFromLeaveDate() {return fromLeaveDate;}

    public void setFromLeaveDate(LocalDate fromLeaveDate) {this.fromLeaveDate = fromLeaveDate;}

    public LocalDate getToLeaveDate() {return toLeaveDate;}

    public void setToLeaveDate(LocalDate toLeaveDate) {this.toLeaveDate = toLeaveDate;}

    public int getTotalLeaveDays() {return totalLeaveDays;}

    public void setTotalLeaveDays(int totalLeaveDays) {this.totalLeaveDays = totalLeaveDays;}

    public String getReason() {return reason;}

    public void setReason(String reason) {this.reason = reason;}
}
