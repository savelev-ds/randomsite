package ru.badegva.app.usecase;

import org.springframework.stereotype.Component;
import ru.badegva.app.repository.ModeratedHrefsRepository;

@Component
public class RemoveUnapproved {

    private final ModeratedHrefsRepository moderatedHrefsRepository;

    public RemoveUnapproved(ModeratedHrefsRepository moderatedHrefsRepository) {
        this.moderatedHrefsRepository = moderatedHrefsRepository;
    }

    public void execute(int id) {
        moderatedHrefsRepository.remove(id);
    }

}
