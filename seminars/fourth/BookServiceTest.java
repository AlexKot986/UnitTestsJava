package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    /**
     * У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных.
     * Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
     */
    Book book1;
    Book book2;

    @BeforeEach
    void setUp() {
        book1 = new Book("123");
        book2 = new Book("124");
    }
    @Test
    void testFindBookById() {
        BookRepository mockBookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(mockBookRepository);
        when(mockBookRepository.findById(anyString())).thenReturn(book1);

        assertThat(bookService.findBookById("any")).isEqualTo(book1);
    }
    @Test
    void testFindAllBooks() {
        BookRepository mockBookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(mockBookRepository);
        when(mockBookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        assertThat(bookService.findAllBooks()).isEqualTo(Arrays.asList(book1, book2));
    }


}