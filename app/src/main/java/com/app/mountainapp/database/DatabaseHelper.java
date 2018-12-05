package com.app.mountainapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "";
    private static String DB_NAME = "MountainAppDatabase.db";
    private static final int DB_VERSION = 1;

    private SQLiteDatabase mDataBase;
    private Context mContext = null;

    public DatabaseHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
        DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";

        this.mContext = context;

        createDatabase();

        this.getReadableDatabase();
    }

    @Override
    public synchronized void close() {
        if(mDataBase != null){
           mDataBase.close();
        }
        super.close();
    }

    private boolean checkDatabase(){
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    public void copyDatabase() throws IOException {
            InputStream mInput = mContext.getAssets().open(DB_NAME);
            String outputFileName = DB_PATH + DB_NAME;
            OutputStream mOutput = new FileOutputStream(outputFileName);
            byte[] mBuffer = new byte[1024];
            int mLength;
            while((mLength = mInput.read(mBuffer)) > 0){
                mOutput.write(mBuffer,0,mLength);
            }
            mOutput.flush();
            mOutput.close();
            mInput.close();

    }

    public void openDatabase(){
        String path = DB_PATH + DB_NAME;
        mDataBase = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READONLY);
    }

    public void createDatabase(){
        if(!checkDatabase()){
            this.getReadableDatabase();
            this.close();
            try{
                copyDatabase();
            }catch(IOException mIOException){
                throw new Error("ErrorCopyingDatabase");
            }
        }
    }

    public Cursor viewName(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Shelter";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
