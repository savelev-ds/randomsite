package ru.badegva.app.usecase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.badegva.app.repository.ModeratedHrefsRepository;

@Component
public class AddUnapproved {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddUnapproved.class);

    private final ModeratedHrefsRepository moderatedHrefsRepository;
    private final IsUnapprovedExist isUnapprovedExist;

    public AddUnapproved(
        ModeratedHrefsRepository moderatedHrefsRepository,
        IsUnapprovedExist isUnapprovedExist
    ) {
        this.moderatedHrefsRepository = moderatedHrefsRepository;
        this.isUnapprovedExist = isUnapprovedExist;
    }

    public void execute(String href) {
        if (moderatedHrefsRepository.getCount() >= 200) {
            LOGGER.debug("Unapproved limit exceeded");
            return;
        }
        href = href.trim();
        if (href.length() < 2) {
            return;
        }
        if (!href.startsWith("http")) {
            href = "http://" + href;
        }
        if (isUnapprovedExist.execute(href)) {
            LOGGER.debug("Unapproved href {} already exists", href);
            return;
        }
        moderatedHrefsRepository.add(href);
        LOGGER.debug("Unapproved href {} added", href);
    }


}
