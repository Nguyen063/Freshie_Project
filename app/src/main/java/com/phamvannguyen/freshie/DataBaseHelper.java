package com.phamvannguyen.freshie;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.phamvannguyen.freshie.models.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DB_PATH_SUFFIX = "/databases/";
    public static final String DB_NAME = "cosmetic.db";
    public static final int DB_VERSION = 1;
    public static final String TBL_PRODUCT = "product";
    public static final String COL_ID = "ProductId";
    public static final String COL_NAME = "ProductName";
    public static final String COL_CATEGORY = "Category";
    public static final String COL_BRAND ="Brand";
    public static final String COL_ORIGINAL_PRICE = "OriginalPrice";
    public static final String COL_PRICE = "Price";
    public static final String COL_RATING_AVERAGE = "RatingAverage";
    public static final String COL_RATING_COUNT = "RatingCount";
    public static final String COL_SOLD = "Sold";
    public static final String COL_DESCRIPTION = "Description";
    public static final String COL_IMAGE_URL = "MediumImage";
    public static final String COL_THUMB_URL = "Thumb";
    public static final String COL_IS_DEAL = "is_deal";
    public static final String COL_IS_BEST_SELLER = "is_best_seller";
    public static final String COL_IS_NEW = "is_new";
    //Cart Table
    public static final String TBL_CART = "cart";
    public static final String COL_CART_ID = "ProductId";
    public static final String COL_CART_QUANTITY = "Quantity";




    private Context mycontext;
    private String DB_PATH = "/data/data/com.phamvannguyen.freshie/databases/";

    public SQLiteDatabase myDataBase;


    public DataBaseHelper(Context context)  {
        super(context,DB_NAME,null,1);
        this.mycontext=context;
        boolean dbexist = checkdatabase();
        if (dbexist) {
            opendatabase();
        } else {
            System.out.println("Database doesn't exist");
            createdatabase();
        }
    }

    public void createdatabase() {
        boolean dbexist = checkdatabase();
        if(!dbexist) {
            this.getReadableDatabase();
            try {
                copydatabase();
            } catch(IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkdatabase() {

        boolean checkdb = false;
        try {
            String myPath = DB_PATH + DB_NAME;
            File dbfile = new File(myPath);
            checkdb = dbfile.exists();
        } catch(SQLiteException e) {
            System.out.println("Database doesn't exist");
        }
        return checkdb;
    }

    private void copydatabase() throws IOException {
        //Open your local db as the input stream
        InputStream myinput = mycontext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outfilename = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myoutput = new FileOutputStream(outfilename);

        // transfer byte to inputfile to outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myinput.read(buffer))>0) {
            myoutput.write(buffer,0,length);
        }

        //Close the streams
        myoutput.flush();
        myoutput.close();
        myinput.close();
    }

    public void opendatabase() throws SQLException {
        //Open the database
        String mypath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void close() {
        if(myDataBase != null) {
            myDataBase.close();
        }
        super.close();
    }
    public Cursor getData(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(sql, null);
        return c;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public Cursor getProductCol(int productID, String columnName) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT " + columnName + " FROM " + TBL_PRODUCT + " WHERE " + COL_ID + " = " + productID; ;

        Cursor c = db.rawQuery(sql, null);
        return c;
    }
    public void updateCart(int productID, int quantity) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "UPDATE " + TBL_CART + " SET " + COL_CART_QUANTITY + " = " + quantity + " WHERE " + COL_CART_ID + " = " + productID;
        db.execSQL(sql);
    }
    public void increaseCart(int productID, int quantity) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "UPDATE " + TBL_CART + " SET " + COL_CART_QUANTITY + " = " + COL_CART_QUANTITY + " + " + quantity + " WHERE " + COL_CART_ID + " = " + productID;
        db.execSQL(sql);
    }
    public void addCart(int productID, int quantity) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO " + TBL_CART + " VALUES (" + productID + ", " + quantity + ")";
        db.execSQL(sql);
    }
    public void deleteCart(int productID) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "DELETE FROM " + TBL_CART + " WHERE " + COL_CART_ID + " = " + productID;
        db.execSQL(sql);
    }

    public void execSql(String s) {
        SQLiteDatabase db = getWritableDatabase();
    }
}
