package com.lh.whiskey;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lh.whiskey.models.Destileria;
import com.lh.whiskey.models.Whisky;

import java.util.List;

public class DestileriaAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Destileria> myDestilerias;

    public DestileriaAdapter(Activity activity, List<Destileria> myDestilerias) {
        this.activity = activity;
        this.myDestilerias = myDestilerias;
    }

    @Override
    public int getCount() {
        return myDestilerias.size();
    }

    @Override
    public Object getItem(int position) {
        return myDestilerias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.activity_item_destileria,null);
        }

        Destileria destileria = myDestilerias.get(position);
        TextView nombreDestileria = v.findViewById(R.id.txtNombreDesti);
        TextView continente = v.findViewById(R.id.txtContinente);
        nombreDestileria.setText(destileria.getNameDestileria());
        continente.setText(destileria.getContinente());

        return v;
    }
}
