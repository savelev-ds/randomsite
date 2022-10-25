package ru.badegva.app.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuSitesRepository extends FileHrefRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(RuSitesRepository.class);

    public RuSitesRepository(String filePath) {
        super(filePath);
    }

    @Override
    public Logger getLogger() {
        return LOGGER;
    }
}
