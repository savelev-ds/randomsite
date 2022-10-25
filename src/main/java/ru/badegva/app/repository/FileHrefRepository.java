package ru.badegva.app.repository;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

abstract class FileHrefRepository implements HrefRepository {

    private final String filePath;
    private final AtomicInteger count = new AtomicInteger(0);
    private List<String> hrefs;

    public FileHrefRepository(String filePath) {
        this.filePath = filePath;
    }

    @PostConstruct
    public void init() {
        try {
            File file = new File(filePath);
            hrefs = Files.readAllLines(file.toPath());
            count.set(hrefs.size());
            getLogger().info("Initialized with {} hrefs", count.get());
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public int getCount() {
        return count.get();
    }

    @Override
    public String getHref(int id) {
        return hrefs.get(id);
    }

    @Override
    public void add(String href) {
        try (
            FileWriter fileWriter = new FileWriter(filePath, true)
        ) {
            File file = new File(filePath);
            if (file.length() != 0) {
                fileWriter.append("\n");
            }
            fileWriter.append(href);
            fileWriter.flush();
            hrefs.add(href);
            count.incrementAndGet();
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void remove(int id) {
        try {
            hrefs.remove(id);
            Files.write(
                new File(filePath).toPath(),
                hrefs,
                Charset.forName("UTF-8"),
                StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING
            );
            count.decrementAndGet();
            getLogger().info("Href {} removed, size now {}", id, count.get());
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public int indexOf(String href) {
        return hrefs.indexOf(href);
    }

    protected List<String> getAll() {
        return hrefs;
    }

    public abstract Logger getLogger();


}
