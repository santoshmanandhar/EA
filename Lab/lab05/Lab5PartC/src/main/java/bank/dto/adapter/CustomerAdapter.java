package bank.dto.adapter;

import bank.domain.Customer;
import bank.dto.CustomerDTO;

public class CustomerAdapter {
    public static Customer getCustomerFromCustomerDTO(CustomerDTO customerDTO){
        return new Customer (customerDTO.getName());

    }
    public static CustomerDTO getCustomerDTOFromCustomer(Customer customer){
        return new CustomerDTO (customer.getName());

    }
}
