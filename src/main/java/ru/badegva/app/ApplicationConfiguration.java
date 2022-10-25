package ru.badegva.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.badegva.app.repository.ModeratedHrefsRepository;
import ru.badegva.app.repository.PartnerHrefsRepository;
import ru.badegva.app.repository.RuSitesRepository;
import ru.badegva.app.repository.SitesRepository;

@Configuration
class ApplicationConfiguration {

    @Bean
    SitesRepository sitesRepository() {
        return new SitesRepository("sites");
    }

    @Bean
    PartnerHrefsRepository partnerHrefsRepository() {
        return new PartnerHrefsRepository("partner");
    }

    @Bean
    ModeratedHrefsRepository moderatedHrefsRepository() {
        return new ModeratedHrefsRepository("moderated");
    }

    @Bean
    RuSitesRepository ruSitesRepository() {
        return new RuSitesRepository("ru_sites");
    }

}
