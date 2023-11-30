package com.example.pmdm2324.ut04.fragments1;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pmdm2324.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link u4afrag4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class u4afrag4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int COLOR_RANGE = 256;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public u4afrag4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment u4afrag4.
     */
    // TODO: Rename and change types and number of parameters
    public static u4afrag4 newInstance(String param1, String param2) {
        u4afrag4 fragment = new u4afrag4();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView tvColores;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.u4a1frag4, container, false);

        tvColores = layout.findViewById(R.id.u4afrag4tvHola);

        tvColores.setOnClickListener((v) -> {
            tvColores.setBackgroundColor(Color.argb(
                    (int) (Math.random()*COLOR_RANGE),
                    (int) (Math.random()*COLOR_RANGE),
                    (int) (Math.random()*COLOR_RANGE),
                    (int) (Math.random()*COLOR_RANGE)));
        });


        return layout;
    }
}