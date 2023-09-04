package org.factoriaf5.comicbooks.comics;

import java.util.List;
import java.util.Optional;

public class ComicService {
    ComicRepository comicRepository;
    public ComicService(ComicRepository repository){
        this.comicRepository = repository;
    }
    public List<Comic> getAll(){
        List<Comic> comics = comicRepository.findAll();
        return comics;
    }
    public Optional<Comic> getComicByIsbn(String isbn){
        return comicRepository.findByIsbn(isbn);
    }
    public Comic create(Comic comic){
        return comicRepository.save(comic);
    }
    public Comic findByIsbn(String isbn){
        return comicRepository.findByIsbn(isbn).get();        
    }
    public Comic update(String isbn, Comic comic){
        Comic currentComic = comicRepository.findByIsbn(isbn).get();
        currentComic.setAuthor(comic.getAuthor());
        currentComic.setTitle(comic.getTitle());
        currentComic.setIshardcover(comic.getIshardcover());
        currentComic.setPhoto(comic.getPhoto());
        currentComic.setPrice(comic.getPrice());
        currentComic.setStock(comic.getStock());
        currentComic.setSynopsis(comic.getSynopsis());
        return comicRepository.save(currentComic);
    }
    public Comic delete(String isbn){
        Comic comic = comicRepository.findByIsbn(isbn).get();
        comicRepository.delete(comic);
        return comic;        
    }
}
