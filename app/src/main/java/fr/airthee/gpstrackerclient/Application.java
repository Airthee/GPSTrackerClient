package fr.airthee.gpstrackerclient;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import fr.airthee.gpstrackerclient.entities.DaoMaster;
import fr.airthee.gpstrackerclient.entities.DaoSession;

public class Application extends android.app.Application {
    public DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;


    @Override
    public void onCreate(){
        // GreenDAO initialization
        helper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();

        super.onCreate();
    }
}
