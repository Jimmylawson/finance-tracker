package com.jimmydev.personal_finance_tracker.services;

import java.util.List;

public interface IService {
    // This interface can be used to define common service methods
    // that can be implemented by various service classes in the application.

    // Example method signatures can be added here, such as:
     void save(Object entity);
    Object findById(Long id);
    List<Object> findAll();
     void delete(Long id);
}
