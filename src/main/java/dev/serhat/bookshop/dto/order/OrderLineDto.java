package dev.serhat.bookshop.dto.order;

import dev.serhat.bookshop.dto.book.BookDto;
import dev.serhat.bookshop.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderLineDto implements Dto {

    private int id;

    private BigDecimal price;

    private BookDto bookDto;
}
