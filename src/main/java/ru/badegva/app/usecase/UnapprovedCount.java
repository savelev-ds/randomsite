package ru.badegva.app.usecase;

import org.springframework.stereotype.Component;
import ru.badegva.app.repository.ModeratedHrefsRepository;

@Component
public class UnapprovedCount {

    private final ModeratedHrefsRepository moderatedHrefsRepository;

    public UnapprovedCount(ModeratedHrefsRepository moderatedHrefsRepository) {
        this.moderatedHrefsRepository = moderatedHrefsRepository;
    }

    public int get() {
        return moderatedHrefsRepository.getCount();
    }

}
