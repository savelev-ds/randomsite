package ru.badegva.app.usecase;

import org.springframework.stereotype.Component;
import ru.badegva.app.repository.ModeratedHrefsRepository;
import ru.badegva.app.repository.PartnerHrefsRepository;

@Component
public class PartnerHrefCount {

    private final PartnerHrefsRepository partnerHrefsRepository;

    public PartnerHrefCount(PartnerHrefsRepository partnerHrefsRepository) {
        this.partnerHrefsRepository = partnerHrefsRepository;
    }

    public int get() {
        return partnerHrefsRepository.getCount();
    }

}
