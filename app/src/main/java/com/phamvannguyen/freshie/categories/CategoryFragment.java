package com.phamvannguyen.freshie.categories;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.models.Product;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {


    private View view;
    private GridView gridView;
    static ArrayList<Product> products;

    private DataBaseHelper db = MainActivity.db;
    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        products = new ArrayList<Product>();
        view = inflater.inflate(R.layout.fragment_category, container, false);

        gridView = (GridView) view.findViewById(R.id.gv_ListProduct);

        loadListview("Skincare");


        //Add raw data
//        products.add(new Product(1, "Sửa rửa mặt", "Sửa rửa mặt", "senka", 1000,800,
//                41,4.2,100));
//        products.add(new Product(1, "Sửa rửa mặt", "Sửa rửa mặt", "senka", 1000,800,
//                41,4.2,100));
//        products.add(new Product(1, "Sửa rửa mặt", "Sửa rửa mặt", "senka", 1000,800,
//                41,4.2,100));
//        products.add(new Product(1, "Sửa rửa mặt", "Sửa rửa mặt", "senka", 1000,800,
//                41,4.2,100));


        //--Load db----

        ;


        return view;

    }

    private void loadListview(String category) {
        //Cursor cursor = db.getData("SELECT * FROM Product");
//        Cursor cursor = db.getData("SELECT "+ DataBaseHelper.COL_ID
//                + " FROM " + DataBaseHelper.TBL_PRODUCT + " WHERE " +
//                DataBaseHelper.COL_CATEGORY  + " = '"+ category +"'" );
//
//
//        while (cursor.moveToNext()) {
//            products.add(new Product(cursor.getInt(0), cursor.getString(1), cursor.getInt(2),
//                    cursor.getString(3), cursor.getDouble(4), cursor.getDouble(5),cursor.getInt(6),
//                    cursor.getDouble(7), cursor.getInt(8),cursor.getBlob(9)));
////        }
//            products.add(new Product(cursor.getInt(0)));
//        }
//        cursor.close();

        products = MainActivity.getListWhere(DataBaseHelper.COL_CATEGORY + " = '" + category + "'");
        CategoryAdapter adapter = new CategoryAdapter(getActivity(), R.layout.item_category, products);
        gridView.setAdapter(adapter);
    }

}