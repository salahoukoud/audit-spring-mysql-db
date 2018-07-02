package com.saoah.envers.model;

import org.hibernate.envers.RevisionType;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The Auditing Table <b>customer_aud</b> contains the <b>customer entity data</b> of the revision,
 * the <b>revision entity</b> and the <b>revision type</b>
 */
@AllArgsConstructor
@Getter
public class CustomerHistory {

    private final Customer customer;
    private final Number revision;
    private final RevisionType revisionType;

}
