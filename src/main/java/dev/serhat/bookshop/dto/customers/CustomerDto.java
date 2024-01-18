package dev.serhat.bookshop.dto.customers;

import dev.serhat.bookshop.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CustomerDto implements Dto {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDateTime createDate;

    private LocalDateTime lastUpdate;

    private Boolean isActive;
}
