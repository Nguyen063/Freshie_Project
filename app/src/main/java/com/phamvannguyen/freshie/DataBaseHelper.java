package com.phamvannguyen.freshie;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.phamvannguyen.freshie.home.HomeFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataBaseHelper extends SQLiteOpenHelper {
   // public static final String DB_PATH_SUFFIX = "/databases/";
    public static final String DB_NAME = "cosmetic.db";
    public static final int DB_VERSION = 1;
    public static final String TBL_PRODUCT = "product";
    public static final String COL_ID = "ProductId";
    public static final String COL_NAME = "ProductName";
    public static final String COL_CATEGORY = "Category";
    public static final String COL_BRAND ="Brand";
    public static final String COL_ORIGINAL_PRICE = "OriginalPrice";
    public static final String COL_PRICE = "Price";
    public static final String COL_DISCOUNT = "Discount";
    public static final String COL_RATING_AVERAGE = "RatingAverage";
    public static final String COL_RATING_COUNT = "RatingCount";
    public static final String COL_SOLD = "Sold";
    public static final String COL_DESCRIPTION = "Description";
    public static final String COL_IMAGE = "Image";


    public DataBaseHelper(@Nullable Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
//    private Context mycontext;
//    private String DB_PATH = "/data/data/com.phamvannguyen.freshie/databases/";

//    public SQLiteDatabase myDataBase;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_PRODUCT + " ("+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " VARCHAR(50), " + COL_IMAGE + " INTEGER, " + COL_PRICE + " REAL," + COL_CATEGORY + " VARCHAR(50), " + COL_RATING_COUNT + " REAL, " + COL_RATING_AVERAGE + " REAL, " + COL_DESCRIPTION + " NVARCHAR, " + COL_DISCOUNT + " REAL, " + COL_SOLD + " REAL) ";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_PRODUCT );
        onCreate(sqLiteDatabase);
    }
    //SELECT
    public Cursor getData(String sql){
        try {
            SQLiteDatabase db = getReadableDatabase();
            return db.rawQuery(sql, null);
        }
        catch (Exception e){
            return null;
        }
    }

    //INSERT, UPDATE, DELETE
    public void execSql(String sql){
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sql);
        }
        catch (Exception e){
        }
    }

        public int getNumbOfRows(){
        Cursor cursor = getData("SELECT * FROM " + TBL_PRODUCT);
        int numbOfRows = cursor.getCount();
        cursor.close();
        return numbOfRows;
    }

    public void createData(){
        if (getNumbOfRows() == 0) {
            execSql("INSERT INTO " + TBL_PRODUCT + " VALUES(null, 'Deal xịn, " + R.drawable.vitamintree + " , 100000, 'Kem trộn' , 4.5 , 100 , ' Kem xịn ' , 20 , 1000 )");
            execSql("INSERT INTO " + TBL_PRODUCT + " VALUES(null, 'Đơn hàng ', " + R.drawable.vitamin + " , 100000, 'Kem trộn' , 4.5 , 100 , ' Kem xịn ' , 20 , 1000 )");
            execSql("INSERT INTO " + TBL_PRODUCT + " VALUES(null, 'Danh mục', " + R.drawable.vitamintree + " , 100000, 'Kem trộn' , 4.5 , 100 , ' Kem xịn ' , 20 , 1000 )");
            execSql("INSERT INTO " + TBL_PRODUCT + " VALUES(null, 'Tích điểm', " + R.drawable.vitamin + " , 100000, 'Kem trộn' , 4.5 , 100 , ' Kem xịn ' , 20 , 1000 )");
            execSql("INSERT INTO " + TBL_PRODUCT + " VALUES(null, 'Freeship', " + R.drawable.vitamintree + " , 100000, 'Kem trộn' , 4.5 , 100 , ' Kem đểu ' , 20 , 1000 )");
            execSql("INSERT INTO " + TBL_PRODUCT + " VALUES(null, 'Freeship X2', " + R.drawable.vitamin + " , 100000, 'Kem trộn' , 4.5 , 100 , ' Kem xịn ' , 20 , 1000 )");
            execSql("INSERT INTO " + TBL_PRODUCT + " VALUES(null, 'Freeship', " + R.drawable.vitamintree + " , 100000, 'Kem trộn' , 4.5 , 100 , ' Kem hết hạn ' , 20 , 1000 )");
            execSql("INSERT INTO " + TBL_PRODUCT + " VALUES(null, 'Freeship X2', " + R.drawable.vitamin + " , 100000, 'Kem trộn' , 4.5 , 100 , ' Kem thừa ' , 20 , 1000 )");

        }
        else {


        }
    }

}
//    public DataBaseHelper(Context context)  {
//        super(context,DB_NAME,null,1);
//        this.mycontext=context;
//        boolean dbexist = checkdatabase();
//        if (dbexist) {
//            opendatabase();
//        } else {
//            System.out.println("Database doesn't exist");
//            createdatabase();
//        }
//    }

//    public void createdatabase() {
//        boolean dbexist = checkdatabase();
//        if(!dbexist) {
//            this.getReadableDatabase();
//            try {
//                copydatabase();
//            } catch(IOException e) {
//                throw new Error("Error copying database");
//            }
//        }
//    }

//    private boolean checkdatabase() {
//
//        boolean checkdb = false;
//        try {
//            String myPath = DB_PATH + DB_NAME;
//            File dbfile = new File(myPath);
//            checkdb = dbfile.exists();
//        } catch(SQLiteException e) {
//            System.out.println("Database doesn't exist");
//        }
//        return checkdb;
//    }
//
//    private void copydatabase() throws IOException {
//        //Open your local db as the input stream
//        InputStream myinput = mycontext.getAssets().open(DB_NAME);
//
//        // Path to the just created empty db
//        String outfilename = DB_PATH + DB_NAME;
//
//        //Open the empty db as the output stream
//        OutputStream myoutput = new FileOutputStream(outfilename);
//
//        // transfer byte to inputfile to outputfile
//        byte[] buffer = new byte[1024];
//        int length;
//        while ((length = myinput.read(buffer))>0) {
//            myoutput.write(buffer,0,length);
//        }
//
//        //Close the streams
//        myoutput.flush();
//        myoutput.close();
//        myinput.close();
//    }
//
//    public void opendatabase() throws SQLException {
//        //Open the database
//        String mypath = DB_PATH + DB_NAME;
//        myDataBase = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READWRITE);
//    }

//    public synchronized void close() {
//        if(myDataBase != null) {
//            myDataBase.close();
//        }
//        super.close();
//    }
//    public Cursor getData(String sql) {
//        SQLiteDatabase db = getWritableDatabase();
//        Cursor c = db.rawQuery(sql, null);
//        return c;
//    }




//    }

//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//
//    }

//}
