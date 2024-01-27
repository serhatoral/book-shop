package dev.serhat.bookshop.controller;


import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.SuccessfulResponse;
import dev.serhat.bookshop.dto.customers.CreateCustomerRequest;
import dev.serhat.bookshop.dto.customers.UpdateCustomerRequest;
import dev.serhat.bookshop.service.CustomerService;
import dev.serhat.bookshop.service.LogService;
import dev.serhat.bookshop.utility.LoggerUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final Logger logger;
    private final LogService logService;

    public CustomerController(CustomerService customerService, LoggerUtil logger, LogService logService) {
        this.customerService = customerService;
        this.logService = logService;
        this.logger = LoggerUtil.getLogger(CustomerController.class);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Dto> getCustomerDtoById(@PathVariable int customerId){

        logService.infoLog(logger,"getCustomerDtoById() den "+customerId+" id'li kullanıcı getirildi");
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
    public ResponseEntity<Dto> createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        return ResponseEntity.ok(customerService.createCustomer(createCustomerRequest));

    }


    @PostMapping("/update")
    public ResponseEntity<Dto> createCustomer(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest){
        return ResponseEntity.ok(customerService.updateCustomer(updateCustomerRequest));

    }

    @DeleteMapping("/delete")
    public ResponseEntity<SuccessfulResponse> createCustomer(@NotNull @RequestParam int id){
        return ResponseEntity.ok(customerService.deleteCustomer(id));

    }

}
