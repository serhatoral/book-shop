package dev.serhat.bookshop.controller;


import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.customers.CreateCustomerRequest;
import dev.serhat.bookshop.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Dto> getCustomerDtoById(@PathVariable int customerId){
        return ResponseEntity.ok(customerService.getCustomerDtoById(customerId));

    }

    @GetMapping("/{customerId}/addresses")
    public ResponseEntity<Dto> getCustomerAddressDtoById(@PathVariable int customerId){
        return ResponseEntity.ok(customerService.getCustomerAddressDtoById(customerId));

    }

    @GetMapping("/{customerId}/orders")
    public ResponseEntity<Dto> getCustomerOrderDtoById(@PathVariable int customerId){
        return ResponseEntity.ok(customerService.getCustomerOrderDtoById(customerId));

    }

    @GetMapping("/{customerId}/extended")
    public ResponseEntity<Dto> getCustomerExtendedDtoById(@PathVariable int customerId){
        return ResponseEntity.ok(customerService.getCustomerExtendedDtoById(customerId));

    }

    @PostMapping("/create")
    public ResponseEntity<Dto> createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest){
        return ResponseEntity.ok(customerService.createCustomer(createCustomerRequest));

    }


}
