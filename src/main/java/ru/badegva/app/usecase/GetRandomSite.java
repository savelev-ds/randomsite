package ru.badegva.app.usecase;

import org.springframework.stereotype.Component;
import ru.badegva.app.repository.RuSitesRepository;
import ru.badegva.app.repository.SitesRepository;

@Component
public class GetRandomSite {

    private final GetNextRandomInt getNextRandomInt;
    private final RuSitesRepository ruSitesRepository;
    private final SitesRepository sitesRepository;

    public GetRandomSite(
        GetNextRandomInt getNextRandomInt,
        RuSitesRepository ruSitesRepository,
        SitesRepository sitesRepository
    ) {
        this.getNextRandomInt = getNextRandomInt;
        this.ruSitesRepository = ruSitesRepository;
        this.sitesRepository = sitesRepository;
    }

    public String execute(boolean ru) {
        if (ru) {
            return ruSitesRepository.getHref(getNextRandomInt.execute(ruSitesRepository.getCount()));
        }
        return sitesRepository.getHref(getNextRandomInt.execute(sitesRepository.getCount()));
    }

}
