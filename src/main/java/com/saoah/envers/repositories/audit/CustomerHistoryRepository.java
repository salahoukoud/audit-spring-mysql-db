package com.saoah.envers.repositories.audit;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.saoah.envers.audit.query.AuditQueryResult;
import com.saoah.envers.audit.query.AuditQueryUtils;
import com.saoah.envers.model.Customer;
import com.saoah.envers.model.CustomerHistory;

@Component
public class CustomerHistoryRepository implements ICustomerHistoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static CustomerHistory getCustomerHistory(AuditQueryResult<Customer> auditQueryResult) {
        CustomerHistory customerHistory = new CustomerHistory(auditQueryResult.getEntity(), auditQueryResult.getRevision().getRevisionNumber(), auditQueryResult.getType());
        return customerHistory;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CustomerHistory> listCustomerRevisions(Long customerId) {
        // Create the Audit Reader. It uses the EntityManager, which will be opened when
        // starting the new Transation and closed when the Transaction finishes.
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        // Create the Query:
        AuditQuery auditQuery = auditReader.createQuery()
                .forRevisionsOfEntity(Customer.class, false, true)
                .add(AuditEntity.id().eq(customerId));
        // We don't operate on the untyped Results, but cast them into a List of AuditQueryResult:
        List<CustomerHistory> customerHistories = AuditQueryUtils.getAuditQueryResults(auditQuery, Customer.class)
                .stream()
                // Turn into the CustomerHistory Domain Object
                .map(x -> getCustomerHistory(x))
                // And collect the results
                .collect(Collectors.toList());

        return customerHistories;
    }
}
