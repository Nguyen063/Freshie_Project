package com.phamvannguyen.freshie.rating;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.OldRatingAdapter;
import com.phamvannguyen.freshie.models.OldRating;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OldRatingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OldRatingFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public OldRatingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OldRatingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OldRatingFragment newInstance(String param1, String param2) {
        OldRatingFragment fragment = new OldRatingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
//        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_old_rating, container, false);
        ListView lvRatingHistory = (ListView) view.findViewById(R.id.lv_ratinghistory);
        ArrayList<OldRating> OldRatingList = new ArrayList<OldRating>();
        OldRatingList.add(new OldRating(R.drawable.product_photo, "Kem dưỡng da Vitamin Tree Water-Gel", "Tôi thích kem này vì nó không gây mụn, mà lại giữ ẩm tốt cho da. Tôi sẽ mua lại sản phẩm này", "20/10/2020"));
        OldRatingList.add(new OldRating(R.drawable.product_photo, "Kem dưỡng da Vitamin Tree Water-Gel", "Tôi thích kem này vì nó không gây mụn, mà lại giữ ẩm tốt cho da. Tôi sẽ mua lại sản phẩm này", "20/10/2020"));
        OldRatingList.add(new OldRating(R.drawable.product_photo, "Kem dưỡng da Vitamin Tree Water-Gel", "Tôi thích kem này vì nó không gây mụn, mà lại giữ ẩm tốt cho da. Tôi sẽ mua lại sản phẩm này", "20/10/2020"));
        OldRatingList.add(new OldRating(R.drawable.product_photo, "Kem dưỡng da Vitamin Tree Water-Gel", "Tôi thích kem này vì nó không gây mụn, mà lại giữ ẩm tốt cho da. Tôi sẽ mua lại sản phẩm này", "20/10/2020"));

        OldRatingAdapter adapter = new OldRatingAdapter(getActivity(), R.layout.item_old_rating, OldRatingList);
        lvRatingHistory.setAdapter(adapter);
//        TextView txtNumRating = (TextView) view.findViewById(R.id.txt_NumRating);
//        txtNumRating.setText(OldRatingList.size());
        return view;
    }
}