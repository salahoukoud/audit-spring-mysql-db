package com.saoah.envers.audit.query;

import org.hibernate.envers.RevisionType;

import com.saoah.envers.audit.model.BaseRevisionEntity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * The AuditQuery results of Hibernate Envers are simply Object[],
 * which makes it hard to work with in the application.
 * This class provides methods to convert between the untyped <b>Object[]</b>
 * and turns it into a strongly typed <b>AuditQueryResult</b>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuditQueryResultUtils {
    public static <TTargetType> AuditQueryResult<TTargetType> getAuditQueryResult(Object[] item, Class<TTargetType> type) {
        // if no item given
        if (item == null)
            return null;
        // if there is not enough data
        if (item.length < 3)
            return null;

        // Cast item[0] to the Entity
        TTargetType entity = null;
        if (type.isInstance(item[0]))
            entity = type.cast(item[0]);

        // Then get the Revision Entity
        BaseRevisionEntity revision = null;
        if (item[1] instanceof BaseRevisionEntity)
            revision = (BaseRevisionEntity) item[1];

        // Then get the Revision Type
        RevisionType revisionType = null;
        if (item[2] instanceof RevisionType)
            revisionType = (RevisionType) item[2];

//        Build the Query Result
        AuditQueryResult<TTargetType> auditQueryResult = new AuditQueryResult<TTargetType>(entity, revision, revisionType);
        return auditQueryResult;
    }
}
