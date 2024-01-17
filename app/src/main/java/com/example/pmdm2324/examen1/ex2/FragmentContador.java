package com.example.pmdm2324.examen1.ex2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm2324.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentContador#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentContador extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentContador() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentContador.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentContador newInstance(String param1, String param2) {
        FragmentContador fragment = new FragmentContador();
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
    Button btSuma;
    Button btResta;
    TextView tvContador;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout= inflater.inflate(R.layout.fragment_contador, container, false);
        tvContador = layout.findViewById(R.id.ex2tvContador);
        btSuma = layout.findViewById(R.id.ex2btSuma);
        btResta = layout.findViewById(R.id.ex2btResta);

        btSuma.setOnClickListener((v) -> {
            tvContador.append(tvContador.getText().toString() + ".");
        });

        btResta.setOnClickListener((v) -> {
            //tvContador = tvContador.getText().toString().substring(0, tvContador.length() -1);
        });
        return  layout;
    }
}