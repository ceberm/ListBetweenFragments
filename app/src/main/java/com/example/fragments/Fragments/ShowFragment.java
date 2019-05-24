package com.example.fragments.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fragments.R;
import com.example.fragments.models.Persona;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFragment extends Fragment {


    public ShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = getArguments();
        Persona persona= (Persona) bundle.getSerializable("Persona");

        View view = inflater.inflate(R.layout.fragment_show, container, false);
        setupUI(view,persona);
        return view;

    }

    public void setupUI(View view, Persona persona){
        final TextView etNombre = (TextView) view.findViewById(R.id.textName);
        final TextView etApellido = (TextView) view.findViewById(R.id.textAp);
        final TextView etCorreo = (TextView) view.findViewById(R.id.textMail);
        final TextView etNum = (TextView) view.findViewById(R.id.textNum);

        etNombre.setText("Nombre: "+persona.getName());
        etApellido.setText("Apellido: "+persona.getLastName());
        etCorreo.setText("Correo: "+persona.getEmail());
        etNum.setText("Telefono: "+persona.getPhoneNumber());

    }

}
