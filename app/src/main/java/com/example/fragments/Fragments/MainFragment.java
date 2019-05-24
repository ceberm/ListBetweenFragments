package com.example.fragments.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.fragments.Adapters.CustomAdapter;
import com.example.fragments.FormActivity;
import com.example.fragments.R;
import com.example.fragments.models.Persona;

import java.text.Normalizer;
import java.util.ArrayList;

public class MainFragment extends Fragment {

    private ArrayList<Persona> listaActual = new ArrayList<Persona>();;
    private ArrayAdapter<Persona> personaAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Bundle bundle = getArguments();
        if (bundle != null) {
            if(bundle.containsKey("listaActual")){
                listaActual = (ArrayList<Persona>) bundle.getSerializable("listaActual");
            }else {
                if (bundle != null && bundle.containsKey("Persona")) {
                    Persona persona = (Persona) bundle.getSerializable("Persona");
                    listaActual.add(persona);
                }
            }
        }
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        setupUI(view);
        return view;
    }

    /***
     *
     * @param view
     */
    public void setupUI(View view){
        Button btn = (Button) view.findViewById(R.id.btn_newPersona);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                //Guarda un arraylist en el bundle
/*
                Intent intent = new Intent(getContext(), FormActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("listaActual", listaActual);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
                getActivity().finish();*/

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                FormFragment formFragment = new FormFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("listaActual", listaActual);
                formFragment.setArguments(bundle);
                ft.replace(android.R.id.content, formFragment);
                ft.addToBackStack(null); //Add fragment in back stack
                ft.commit();
            }
        });

        personaAdapter = new CustomAdapter(view.getContext(), R.layout.fragment_show, listaActual);
        ListView mListView = (ListView) view.findViewById(R.id.mListView);
        mListView.setAdapter(personaAdapter);

    }

}
