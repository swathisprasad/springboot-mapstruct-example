package com.swathisprasad.mapstruct.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BookDTO implements Serializable{

    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String author;

    @NotNull
    private LocalDateTime publishedDate;

    private UUID libraryId;
}
