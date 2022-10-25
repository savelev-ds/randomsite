package ru.badegva.app.usecase;

import org.springframework.stereotype.Component;
import ru.badegva.app.model.Href;
import ru.badegva.app.repository.ModeratedHrefsRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAllUnapproved {

    private final ModeratedHrefsRepository moderatedHrefsRepository;

    public GetAllUnapproved(ModeratedHrefsRepository moderatedHrefsRepository) {
        this.moderatedHrefsRepository = moderatedHrefsRepository;
    }

    public List<Href> execute() {
        List<Href> all = new ArrayList<>();
        for (int i = 0; i < moderatedHrefsRepository.getAll().size(); i++) {
            Href href = new Href();
            href.setId(i);
            href.setRef(moderatedHrefsRepository.getAll().get(i));
            all.add(href);
        }
        return all;
    }

}
