package ru.badegva.app.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SitesRepository extends FileHrefRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(SitesRepository.class);

    public SitesRepository(String filePath) {
        super(filePath);
    }

    @Override
    public Logger getLogger() {
        return LOGGER;
    }
}
