package com.fyp.islamic_digital_shelf.services.imple;

import com.fyp.islamic_digital_shelf.model.*;
import com.fyp.islamic_digital_shelf.book.bean.BookRequest;
import com.fyp.islamic_digital_shelf.book.bean.BookView;
import com.fyp.islamic_digital_shelf.services.FileService;
import com.fyp.islamic_digital_shelf.repo.AuthorRepo;
import com.fyp.islamic_digital_shelf.repo.BookRepo;
import com.fyp.islamic_digital_shelf.repo.CategoryRepo;
import com.fyp.islamic_digital_shelf.services.BookService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepository;
    private final AuthorRepo authorRepository;
    private final CategoryRepo categoryRepository;
    private final FileService fileService;

    public BookServiceImpl(BookRepo bookRepository, AuthorRepo authorRepository, CategoryRepo categoryRepository, FileService fileService) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.fileService = fileService;
    }

    @Override
    public BookView createBook(BookRequest request) {
        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        FileEntity fileEntity = null;
        if (request.getFile() != null) {
            try {
                fileEntity = fileService.saveFile(request.getFile());
            } catch (IOException e) {
                throw new RuntimeException("Failed to save file", e);
            }
        }

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setPublishedDate(request.getPublishedDate());
        book.setAuthor(author);
        book.setCategory(category);
        book.setFileUrl(fileEntity);


        Book savedBook = bookRepository.save(book);

        return convertToView(savedBook);
    }

    @Override
    public List<BookView> getAllBooks() {
        return bookRepository.findAll().stream().map(this::convertToView).collect(Collectors.toList());
    }

    @Override
    public BookView getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return convertToView(book);
    }

    @Override
    public BookView updateBook(Long id, BookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        if (request.getFile() != null) {
            try {
                FileEntity fileEntity = fileService.saveFile(request.getFile());
                book.setFileUrl(fileEntity);
            } catch (IOException e) {
                throw new RuntimeException("Failed to save file", e);
            }
        }

        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setPublishedDate(request.getPublishedDate());
        book.setAuthor(author);
        book.setCategory(category);

        Book updatedBook = bookRepository.save(book);
        return convertToView(updatedBook);
    }

    @Override
    public String deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.delete(book);
        return "Book deleted successfully";
    }

    @Override
    public List<BookView> searchBook(String name) {
        return bookRepository.findByTitleContaining(name).stream()
                .map(this::convertToView)
                .collect(Collectors.toList());
    }

    private BookView convertToView(Book book) {

        return new BookView(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getPublishedDate(),
                book.getAuthor().getName(),
                book.getCategory().getName(),
                book.getFileUrl() != null ? book.getFileUrl().getFilePath() : null
        );
    }
}