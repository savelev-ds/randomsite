package ru.badegva.app.usecase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.badegva.app.repository.PartnerHrefsRepository;

@Component
public class GetRandomPartnerHref {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetRandomSite.class);

    private final GetNextRandomInt getNextRandomInt;
    private final GetRandomSite getRandomSite;
    private final PartnerHrefsRepository partnerHrefsRepository;

    public GetRandomPartnerHref(
        GetNextRandomInt getNextRandomInt,
        GetRandomSite getRandomSite,
        PartnerHrefsRepository partnerHrefsRepository
    ) {
        this.getNextRandomInt = getNextRandomInt;
        this.getRandomSite = getRandomSite;
        this.partnerHrefsRepository = partnerHrefsRepository;
    }

    public String execute(boolean ru) {
        if (partnerHrefsRepository.getCount() == 0) {
            return getRandomSite.execute(ru);
        }
        int id = getNextRandomInt.execute(partnerHrefsRepository.getCount());
        LOGGER.info("Partner site id {}", id);
        return partnerHrefsRepository.getHref(id);
    }

}
