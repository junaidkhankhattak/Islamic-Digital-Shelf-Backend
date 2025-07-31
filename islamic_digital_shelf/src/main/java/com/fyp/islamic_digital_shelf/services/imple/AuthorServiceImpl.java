package com.fyp.islamic_digital_shelf.services.imple;

import com.fyp.islamic_digital_shelf.auther.bean.AuthorRequestParam;
import com.fyp.islamic_digital_shelf.auther.bean.AuthorView;
import com.fyp.islamic_digital_shelf.model.Author;
import com.fyp.islamic_digital_shelf.repo.AuthorRepo;
import com.fyp.islamic_digital_shelf.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private  final AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public List<AuthorView> getAllAuthor() {
        return authorRepo.findAll().stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorView getAuthorById(Long id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with ID: " + id));
        return mapToView(author);
    }

    @Override
    public AuthorView updateAuthor(Long id, AuthorRequestParam authorRequestParam) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with ID: " + id));

        author.setName(authorRequestParam.getName());
        author.setBio(authorRequestParam.getBio());
        author = authorRepo.save(author);

        return mapToView(author);
    }

    @Override
    public AuthorView saveAuthor(AuthorRequestParam authorRequestParam) {
        Author author = new Author();
        author.setName(authorRequestParam.getName());
        author.setBio(authorRequestParam.getBio());
        author = authorRepo.save(author);
        return mapToView(author);
    }

    private AuthorView mapToView(Author author) {
        AuthorView view = new AuthorView();
        view.setId(author.getId());
        view.setName(author.getName());
        view.setBio(author.getBio());
        return view;
    }

    @Override
    public String deleteAuthor(Long id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        authorRepo.delete(author);
        return "Author deleted successfully";
    }

}
