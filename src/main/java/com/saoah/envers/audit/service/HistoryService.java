package com.saoah.envers.audit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saoah.envers.dto.CustomerHistoryDto;
import com.saoah.envers.dto.converter.Converters;
import com.saoah.envers.model.CustomerHistory;
import com.saoah.envers.repositories.audit.ICustomerHistoryRepository;

@Component
public class HistoryService {

    @Autowired
    private ICustomerHistoryRepository historyRepository;

    public List<CustomerHistoryDto> listHistoryRevisions(Number id) {
        List<CustomerHistory> histories = historyRepository.listCustomerRevisions(id.longValue());
        List<CustomerHistoryDto> historyDtoList = histories.stream().map(Converters::convert).collect(Collectors.toList());
        return historyDtoList;
    }

}
