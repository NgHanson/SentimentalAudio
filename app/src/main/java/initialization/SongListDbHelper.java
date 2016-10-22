package initialization;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by christophE on 2016-10-22.
 */

public class SongListDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";



    //Predefined statements
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SongListContract.FeedEntry.TABLE_NAME + " (" +
                    SongListContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    SongListContract.FeedEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    SongListContract.FeedEntry.COLUMN_NAME_ARTIST + TEXT_TYPE + COMMA_SEP +
                    SongListContract.FeedEntry.COLUMN_NAME_PATH + TEXT_TYPE + COMMA_SEP +
                    SongListContract.FeedEntry.COLUMN_NAME_CATEGORY + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SongListContract.FeedEntry.TABLE_NAME;


    public SongListDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
