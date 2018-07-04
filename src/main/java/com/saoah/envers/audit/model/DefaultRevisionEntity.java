package com.saoah.envers.audit.model;

import java.text.DateFormat;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.RevisionEntity;

import lombok.NoArgsConstructor;

/**
 * The Revision Entity for the application, which defines the mapping to the <b>revinfo</b> table.
 */
@Entity
@Table(name = "revinfo")
@RevisionEntity
@NoArgsConstructor
public class DefaultRevisionEntity extends BaseRevisionEntity {

    public String toString() {
        return "DefaultRevisionEntity(revisionNumber = " + getRevisionNumber()
                + ", revisionDate = " + DateFormat.getDateTimeInstance().format(this.getRevisionDate()) + ")";
    }
}
