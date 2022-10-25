package ru.badegva.app.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartnerHrefsRepository extends FileHrefRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerHrefsRepository.class);

    public PartnerHrefsRepository(String filePath) {
        super(filePath);
    }

    @Override
    public Logger getLogger() {
        return LOGGER;
    }
}
