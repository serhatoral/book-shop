package dev.serhat.bookshop.dto.order;

import dev.serhat.bookshop.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderHistoryDto implements Dto {

    private int id;

    private LocalDateTime statusDate;

    private String orderStatus;
}
