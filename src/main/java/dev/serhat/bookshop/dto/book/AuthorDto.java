package dev.serhat.bookshop.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto implements Serializable {

    private int id;
    private String authorName;
}
