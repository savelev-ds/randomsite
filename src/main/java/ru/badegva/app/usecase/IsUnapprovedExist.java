package ru.badegva.app.usecase;

import org.springframework.stereotype.Component;
import ru.badegva.app.repository.ModeratedHrefsRepository;

@Component
public class IsUnapprovedExist {

    private final ModeratedHrefsRepository moderatedHrefsRepository;

    public IsUnapprovedExist(ModeratedHrefsRepository moderatedHrefsRepository) {
        this.moderatedHrefsRepository = moderatedHrefsRepository;
    }

    public boolean execute(String href) {
        return moderatedHrefsRepository.indexOf(href) >= 0;
    }

}
