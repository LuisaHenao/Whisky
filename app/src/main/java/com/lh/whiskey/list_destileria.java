package com.lh.whiskey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.lh.whiskey.apimanager.RetrofitClient;
import com.lh.whiskey.models.Destileria;
import com.lh.whiskey.models.Whisky;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class list_destileria extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listDestileria;
    List<Destileria>  mydestileria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_destileria);
        listDestileria = findViewById(R.id.listDestileria);
        getFromIntenetDestileria();
        listDestileria.setOnItemClickListener(this);
    }

    private void getFromIntenetDestileria(){
        Call<List<Destileria>> call = RetrofitClient.getInstance().getMyApi().getDestilerias();
        call.enqueue(new Callback<List<Destileria>>() {

            @Override
            public void onResponse(Call<List<Destileria>> call, Response<List<Destileria>> response) {
                mydestileria = response.body();
                String message = "";
                DestileriaAdapter adapter = new DestileriaAdapter(list_destileria.this, mydestileria);
                listDestileria.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Destileria>> call, Throwable t) {
                Toast.makeText(list_destileria.this, "Error!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent Myintent = new Intent(this,informacion_destileria.class);
        Myintent.putExtra("slug", mydestileria.get(position).getSlugDestileria());
        startActivity(Myintent);
    }
}