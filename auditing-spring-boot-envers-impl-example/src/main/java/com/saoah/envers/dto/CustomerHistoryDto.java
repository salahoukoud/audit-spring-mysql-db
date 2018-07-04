package com.saoah.envers.dto;

import com.saoah.envers.audit.dto.HistoryDto;
import com.saoah.envers.audit.dto.RevisionTypeDto;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CustomerHistoryDto extends HistoryDto<CustomerDto> {
    public CustomerHistoryDto(CustomerDto dto, Long revision, RevisionTypeDto revisionType) {
        super(dto, revision, revisionType);
    }

}