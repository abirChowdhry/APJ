package com.service;

import com.domain.LeaveApplication;
import com.repository.LeaveApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LeaveApplicationService {

    private LeaveApplicationRepository leaveApplicationRepository;

    public LeaveApplicationService(LeaveApplicationRepository leaveApplicationRepository) {
        this.leaveApplicationRepository = leaveApplicationRepository;
    }

    @Transactional
    public boolean insert(LeaveApplication leaveApplication) {

        if (leaveApplication.getTotalDays() <= leaveApplication.getLeaveType().getTotalDays()) {
            return leaveApplicationRepository.create(leaveApplication);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public LeaveApplication get(Long id) {
        return leaveApplicationRepository.get(id);
    }
    @Transactional(readOnly = true)
    public LeaveApplication List() {
        return (LeaveApplication) leaveApplicationRepository.list();
    }

    @Transactional
    public LeaveApplication delete(Long id) {

            return leaveApplicationRepository.delete(id);

    }

    @Transactional
    public LeaveApplication update(Long id) {

            return leaveApplicationRepository.update(id);

    }
}
