package com.example.fragments.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fragments.R;
import com.example.fragments.models.Persona;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Persona> {

    int mlayoutId;
    public CustomAdapter(Context context, int layoutId, List<Persona> items) {
        super(context, layoutId, items);
        mlayoutId = layoutId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Persona p1 = getItem(position);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mlayoutId, parent, false);
        }

        TextView nameView = (TextView) convertView.findViewById(R.id.textName);
        TextView lastNameView = (TextView) convertView.findViewById(R.id.textAp);

        nameView.setText(p1.getName());
        lastNameView.setText(p1.getLastName());

        return convertView;
    }
}
