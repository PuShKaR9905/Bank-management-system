// src/BankManagementSystem.java
import models.Customer;
import models.Account;
import services.CustomerService;
import services.AccountService;

import java.math.BigDecimal;
import java.util.List;

public class BankManagementSystem {
    public static void main(String[] args) {
        // Initialize service classes
        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService();

        // Add a new customer
        Customer newCustomer = new Customer(0, "Alice Johnson", "alice@example.com", "555-1234");
        customerService.addCustomer(newCustomer);

        // Fetch and display all customers
        System.out.println("All Customers:");
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        // Assuming the customer ID is retrieved or known; here we'll use the first customer in the list for demonstration.
        if (!customers.isEmpty()) {
            int customerId = customers.get(0).getId();

            // Create a new account for the first customer
            Account newAccount = new Account(0, customerId, new BigDecimal("1000.00"), "SAVINGS");
            accountService.addAccount(newAccount);

            // Fetch and display all accounts
            System.out.println("\nAll Accounts:");
            List<Account> accounts = accountService.getAllAccounts();
            for (Account account : accounts) {
                System.out.println(account);
            }
        } else {
            System.out.println("No customers found to create accounts for.");
        }
    }
}