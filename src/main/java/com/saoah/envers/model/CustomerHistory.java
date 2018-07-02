package com.saoah.envers.model;

import org.hibernate.envers.RevisionType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerHistory {

    private final Customer customer;
    private final Number revision;
    private final RevisionType revisionType;

}
