package com.saoah.envers.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.saoah.envers.AuditApplication;
import com.saoah.envers.model.Customer;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AuditApplication.class)
public class ICustomerRepositoryIntegrationTest {

    private static Long idCustomer;

    @Autowired
    private ICustomerRepository customerRepository;

    @Test
    public void test_save() {
        Customer customer = new Customer("Save", "Test");
        this.customerRepository.save(customer);
        assertNotNull(customer.getId());
        idCustomer = customer.getId();
        System.out.println(" CUSTOMER : " + customer);
    }

    @Test
//    @Transactional
    public void test_update() throws InterruptedException {
        Customer customer = this.customerRepository.findOne(idCustomer);
        assertNotNull(customer);
        System.out.println(customer);
        customer.setFirstName("Edited");
        Thread.sleep(5000);
        this.customerRepository.save(customer);
        System.out.println(customer);
//        Thread.sleep(5000);
        customer= this.customerRepository.findOne(idCustomer);
        System.out.println(customer);

    }
}