package com.saoah.envers.repositories;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.saoah.envers.model.Customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
//@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Commit // because @datajpatest Rolled back transaction
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ICustomerRepositoryTest {

    private static Long idCustomer;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ICustomerRepository customerRepository;

    @Test
    public void test_3_findAll() {
        List<Customer> customers = customerRepository.findAll();

        assertNotNull("TOTO", customers);
    }

    @Test
    public void test_1_save() {
        Customer customer = new Customer("Save", "Test");
        this.customerRepository.save(customer);
        assertNotNull(customer.getId());
        idCustomer = customer.getId();
        System.out.println("ID CUSTOMER : " + customer.getId());
    }

    @Test
    public void test_2_findById() {
        Customer customer = customerRepository.findOne(idCustomer);
        assertNotNull(customer);
        assertEquals(customer.getFirstName(), "TOTO");
        assertEquals(customer.getLastName(), "TITI");
    }
}