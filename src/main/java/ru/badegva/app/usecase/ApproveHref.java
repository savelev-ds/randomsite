package ru.badegva.app.usecase;

import org.springframework.stereotype.Component;
import ru.badegva.app.repository.ModeratedHrefsRepository;
import ru.badegva.app.repository.PartnerHrefsRepository;
import ru.badegva.app.repository.RuSitesRepository;
import ru.badegva.app.repository.SitesRepository;

@Component
public class ApproveHref {

    private final SitesRepository sitesRepository;
    private final RuSitesRepository ruSitesRepository;
    private final ModeratedHrefsRepository moderatedHrefsRepository;
    private final RemoveUnapproved removeUnapproved;
    private final PartnerHrefsRepository partnerHrefsRepository;

    public ApproveHref(
        SitesRepository sitesRepository,
        RuSitesRepository ruSitesRepository,
        RemoveUnapproved removeUnapproved,
        ModeratedHrefsRepository moderatedHrefsRepository,
        PartnerHrefsRepository partnerHrefsRepository
    ) {
        this.sitesRepository = sitesRepository;
        this.ruSitesRepository = ruSitesRepository;
        this.removeUnapproved = removeUnapproved;
        this.moderatedHrefsRepository = moderatedHrefsRepository;
        this.partnerHrefsRepository = partnerHrefsRepository;
    }

    public void execute(int id, boolean ru, boolean isPartner) {
        String href = moderatedHrefsRepository.getHref(id);
        sitesRepository.add(href);
        if (ru || isPartner) {
            ruSitesRepository.add(href);
        }
        if (isPartner) {
            partnerHrefsRepository.add(href);
        }
        removeUnapproved.execute(id);
    }

}
