package com.saoah.envers.repositories.audit;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.saoah.envers.AuditApplication;
import com.saoah.envers.dto.converter.Converters;
import com.saoah.envers.model.CustomerHistory;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AuditApplication.class)
public class CustomerHistoryRepositoryTest {

    private static Long idCustomer = 13L;

    @Autowired
    private ICustomerHistoryRepository iCustomerHistoryRepository;

    @Test
    public void listCustomerRevisions() {
        // Get History:
        List<CustomerHistory> histories = iCustomerHistoryRepository.listCustomerRevisions(idCustomer);

        assertNotNull(histories);
        System.out.println("History of customer ID : " + idCustomer + " is : " + histories.size());
        // Return the DTO List:
        histories.stream().map(Converters::convert).collect(Collectors.toList());


    }
}