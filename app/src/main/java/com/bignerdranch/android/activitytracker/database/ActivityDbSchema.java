package com.bignerdranch.android.activitytracker.database;

/**
 * Created by Nick030 on 12/10/2017.
 */

public class ActivityDbSchema {
    public static final class ActivityTable {
        public static final String NAME = "activities";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String LOCATION = "location";
            public static final String COMMENT = "comment";
            public static final String DURATION = "duration";
            public static final String DATE = "date";
        }
    }

    public static final class UserInfoTable {
        public static final String NAME = "settings";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String EMAIL = "email";
            public static final String GENDER = "gender";
            public static final String COMMENT = "comment";
        }
    }
}
