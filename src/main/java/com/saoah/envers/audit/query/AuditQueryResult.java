package com.saoah.envers.audit.query;

import org.hibernate.envers.RevisionType;

import com.saoah.envers.audit.model.CustomRevisionEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A container for the Results of an Audit Query<br>
 * Provides strongly typed access to the <b>versioned entity</b>,
 * the <b>revision</b> and the <b>RevisionType</b>
 *
 * @param <T> : Type of entity
 */
@AllArgsConstructor
@Getter
public class AuditQueryResult<T> {
    private final T entity;
    private final CustomRevisionEntity revision;
    private final RevisionType type;

}
