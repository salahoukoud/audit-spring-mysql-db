package com.saoah.envers.audit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class HistoryDto<T> {

    private final T dto;
    private final Long revision;
    private final RevisionTypeDto revisionType;

}