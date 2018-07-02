package com.saoah.envers.repositories.audit;

import java.util.List;

import com.saoah.envers.model.CustomerHistory;

/**
 * The interface for accessing the auditioned customer table,
 * and getting the audition and versioned data.<br>
 * interface returns a List of CustomerHistory,
 * which is the auditioning and version history for the Customer table
 */
public interface ICustomerHistoryRepository {
    /**
     * Returns a List of CustomerHistory,
     * which is the auditioning and version history for the Customer table
     * @param customerId
     * @return List of CustomerHistory
     */
    List<CustomerHistory> listCustomerRevisions(Long customerId);
}
