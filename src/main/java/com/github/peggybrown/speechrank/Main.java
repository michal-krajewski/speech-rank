package com.github.peggybrown.speechrank;

import com.github.peggybrown.speechrank.dao.XodusConferenceDao;
import com.github.peggybrown.speechrank.entity.Conference;
import com.github.peggybrown.speechrank.entity.Year;
import jetbrains.exodus.entitystore.Entity;

public class Main {

    public static void main(String... args) throws Exception {
//        new RatpackRestServer(options)
//            .start();
        XodusConferenceDao xodusConferenceRepository = new XodusConferenceDao();

        Entity year2012 = xodusConferenceRepository.addYear(new Year(null, "2012"));
        Entity year2013 = xodusConferenceRepository.addYear(new Year(null, "2013"));

        xodusConferenceRepository.addConference(new Conference("boiled frog", null), year2012);
        xodusConferenceRepository.addConference(new Conference("Devoxx", null), year2012);
        xodusConferenceRepository.addConference(new Conference("Devoxx", null), year2013);
        xodusConferenceRepository.read();
    }

    private static String options =
        "GET /api/conferences\n" +
            "GET /api/conference/:id\n" +
            "POST /api/rating\n" +
            "POST /api/comment\n" +
            "POST /api/import\n";

}
