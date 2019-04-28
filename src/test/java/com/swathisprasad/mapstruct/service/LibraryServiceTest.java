package com.swathisprasad.mapstruct.service;

import com.swathisprasad.mapstruct.Application;
import com.swathisprasad.mapstruct.dto.BookDTO;
import com.swathisprasad.mapstruct.dto.LibraryDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith (SpringExtension.class)
@SpringBootTest (classes = Application.class)
public class LibraryServiceTest{

    @Autowired
    private LibraryService libraryService;

    @Test
    public void saveLibrary(){
        final LibraryDTO libraryDTO=new LibraryDTO();
        libraryDTO.setName("Library");
        final List<BookDTO> books=new ArrayList<>();
        final BookDTO book1=new BookDTO();
        book1.setName("Book1");
        book1.setAuthor("Author1");
        book1.setPublishedDate(LocalDateTime.now());
        books.add(book1);

        final BookDTO book2=new BookDTO();
        book2.setName("Book2");
        book2.setAuthor("Author2");
        book2.setPublishedDate(LocalDateTime.now().minusDays(10));
        books.add(book2);

        libraryDTO.setBookDTOs(books);
        final LibraryDTO createdLibraryDTO = libraryService.save(libraryDTO);

        final List<BookDTO> createdBooks=createdLibraryDTO.getBookDTOs();
        assertThat(createdBooks).hasSize(2);
        createdBooks.forEach(bookDTO -> assertThat(bookDTO.getLibraryId()).isEqualTo(createdLibraryDTO.getId()));
    }
}
