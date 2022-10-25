package ru.badegva.app.repository;

import ru.badegva.app.model.Href;

interface HrefRepository {

    int getCount();

    String getHref(int id);

    void add(String href);

    void remove(int id);

    int indexOf(String href);

}
