package com.saoah.envers.dto;

import com.saoah.envers.audit.dto.RevisionTypeDto;

import lombok.Data;

@Data
public class CustomerHistoryDto {

    private final CustomerDto customer;
    private final Long revision;
    private final RevisionTypeDto revisionType;

}