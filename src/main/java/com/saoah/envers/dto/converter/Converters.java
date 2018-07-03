package com.saoah.envers.dto.converter;

import org.hibernate.envers.RevisionType;

import com.saoah.envers.audit.dto.RevisionTypeDto;
import com.saoah.envers.dto.CustomerDto;
import com.saoah.envers.dto.CustomerHistoryDto;
import com.saoah.envers.model.Customer;
import com.saoah.envers.model.CustomerHistory;

public class Converters {

    public static CustomerDto convert(Customer customer) {
        if (customer == null)
            return null;

        return new CustomerDto(customer.getId(), customer.getFirstName(), customer.getLastName());
    }

    public static Customer convert(CustomerDto customer) {
        if (customer == null)
            return null;

        return new Customer(customer.getId(), customer.getFirstName(), customer.getLastName());
    }

    public static RevisionTypeDto convert(RevisionType revisionType) {
        if (revisionType == null)
            return null;

        switch (revisionType) {
            case ADD:
                return RevisionTypeDto.ADD;
            case MOD:
                return RevisionTypeDto.MOD;
            case DEL:
                return RevisionTypeDto.DEL;
            default:
                throw new IllegalArgumentException("revisionType is null !!");
        }
    }

    public static CustomerHistoryDto convert(CustomerHistory customerHistory) {
        if (customerHistory == null) return null;
        CustomerDto customerDto = convert(customerHistory.getCustomer());
        Long revision = customerHistory.getRevision().longValue();
        RevisionTypeDto revisionTypeDto = convert(customerHistory.getRevisionType());

        return new CustomerHistoryDto(customerDto, revision, revisionTypeDto);
    }
}