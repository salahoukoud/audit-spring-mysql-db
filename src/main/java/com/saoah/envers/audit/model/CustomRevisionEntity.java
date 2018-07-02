package com.saoah.envers.audit.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * The base class for Revision Entities with the revision number and revision timestamp.
 */
@MappedSuperclass
@Getter
@EqualsAndHashCode
public class CustomRevisionEntity implements Serializable {

    @Id
    @RevisionNumber
    @GeneratedValue
    @Column(name = "revision_number")
    private int revisionNumber;

    @RevisionTimestamp
    @Column(name = "revision_timestamp")
    private long revisionTimestamp;

    @Transient
    public Date getRevisionDate() {
        return new Date(this.revisionTimestamp);
    }

    @Override
    public String toString() {
        return "CustomRevisionEntity(revisionNumber = " + this.revisionNumber
                + ", revisionDate = " + DateFormat.getDateTimeInstance().format(this.getRevisionDate())
                + "[" + this.revisionTimestamp + "])";
    }
}
