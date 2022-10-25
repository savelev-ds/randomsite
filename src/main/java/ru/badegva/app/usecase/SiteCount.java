package ru.badegva.app.usecase;

import org.springframework.stereotype.Component;
import ru.badegva.app.repository.RuSitesRepository;
import ru.badegva.app.repository.SitesRepository;

@Component
public class SiteCount {

    private final SitesRepository sitesRepository;
    private final RuSitesRepository ruSitesRepository;

    public SiteCount(SitesRepository sitesRepository, RuSitesRepository ruSitesRepository) {
        this.sitesRepository = sitesRepository;
        this.ruSitesRepository = ruSitesRepository;
    }

    public int getTotal() {
        return sitesRepository.getCount();
    }

    public int getRu() {
        return ruSitesRepository.getCount();
    }

}
