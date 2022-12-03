package com.phamvannguyen.freshie;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
    public static final String COL_DESCRIPTION = "Description";
    public static final String COL_IMAGE = "Image";

    public DataBaseHelper(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
