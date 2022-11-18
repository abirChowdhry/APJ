package com.repository;

import com.domain.LeaveApplication;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class LeaveApplicationRepository {
    private SessionFactory sessionFactory;

    public LeaveApplicationRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<LeaveApplication> list() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query<LeaveApplication> leaveApplicationQuery = session.createQuery("from LeaveApplication", LeaveApplication.class);
        return leaveApplicationQuery.getResultList();
    }

    public boolean create(LeaveApplication leaveApplication) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(leaveApplication);
        return true;
    }
}
