package com.github.peggybrown.speechrank.dao;

import com.github.peggybrown.speechrank.entity.Conference;
import com.github.peggybrown.speechrank.entity.Year;
import jetbrains.exodus.entitystore.*;

public class XodusConferenceDao {

    private static final String CONFERENCE_ENTITY = "Conference";
    private static final String YEAR_ENTITY = "Year";

    private static final String NAME_PROPERTY = "name";
    private static final String YEAR_PROPERTY = "year";

    private static final String dbFilePath = "/Users/atreses/Documents/Projects/speech-rank/.data";

    private PersistentEntityStore entityStore = PersistentEntityStores.newInstance(dbFilePath); //TODO change to GUICE

    public Entity addConference(Conference conference, Entity year) {
        return entityStore.computeInTransaction(txn -> {
            Entity entity = txn.newEntity(CONFERENCE_ENTITY);
            entity.setProperty(NAME_PROPERTY, conference.getName());
            entity.setLink(YEAR_PROPERTY, year);

            return entity;
        });
    }

    public Entity addYear(Year year) {
        return entityStore.computeInTransaction(txn -> {
            Entity entity = txn.newEntity(YEAR_ENTITY);
            entity.setProperty(YEAR_PROPERTY, year.getYear());

            return entity;
        });
    }



    public void test() {
        entityStore.executeInTransaction(txn -> {

            final Entity conference = txn.newEntity("Conference");
            conference.setProperty("year", 2020);
            conference.setProperty("title", "Boiled Frog");
        });
    }

    public void read() {
        entityStore.executeInReadonlyTransaction(txn -> {
            EntityIterable conference = txn.getAll("Conference");
            EntityIterator iterator = conference.iterator();

            for (long i = 0; i < conference.size(); i++) {
                EntityId entityId = iterator.nextId();
                Entity entity = txn.getEntity(entityId);
                System.out
                    .println("Conference: id=".concat(entityId.toString()).concat(", title=").concat((String) entity.getProperty(NAME_PROPERTY)).concat(", year=").concat(entity.getLink(YEAR_PROPERTY).toString()));
            }
        });
    }
}
