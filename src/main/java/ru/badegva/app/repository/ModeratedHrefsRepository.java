package ru.badegva.app.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ModeratedHrefsRepository extends FileHrefRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModeratedHrefsRepository.class);

    public ModeratedHrefsRepository(String filePath) {
        super(filePath);
    }

    @Override
    public Logger getLogger() {
        return LOGGER;
    }

    public List<String> getAll() {
        return super.getAll();
    }

}
