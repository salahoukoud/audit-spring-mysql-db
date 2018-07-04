package com.saoah.envers.audit.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.saoah.envers.AuditApplication;
import com.saoah.envers.dto.CustomerHistoryDto;
import com.saoah.envers.services.audit.HistoryService;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AuditApplication.class)
public class HistoryServiceTest {

    private static Long idCustomer = 13L;

    @Autowired
    private HistoryService historyService;

    @Test
    public void listHistoryRevisions() {
        List<CustomerHistoryDto> historyDtoList = historyService.listHistoryRevisions(idCustomer);

        assertNotNull(historyDtoList);

        System.out.println("History size : " + historyDtoList.size());
        for (CustomerHistoryDto historyDto : historyDtoList) {
            System.out.println(historyDto);
        }

    }
}