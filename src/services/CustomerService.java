// src/services/CustomerService.java
package services;

import dao.CustomerDAO;
import models.Customer;
import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }

    public void addCustomer(Customer customer) {
        try {
            if (isValidCustomer(customer)) {
                customerDAO.addCustomer(customer);
                System.out.println("Customer added successfully.");
            } else {
                System.out.println("Invalid customer data.");
            }
        } catch (SQLException e) {
            System.err.println("Error adding customer: " + e.getMessage());
        }
    }

    public List<Customer> getAllCustomers() {
        try {
            return customerDAO.getAllCustomers();
        } catch (SQLException e) {
            System.err.println("Error retrieving customers: " + e.getMessage());
            return null;
        }
    }

    private boolean isValidCustomer(Customer customer) {
        // Example validation logic
        return customer.getName() != null && !customer.getName().isEmpty()
            && customer.getEmail() != null && !customer.getEmail().isEmpty()
            && customer.getPhone() != null && !customer.getPhone().isEmpty();
    }
}