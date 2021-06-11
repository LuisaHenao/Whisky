package com.lh.whiskey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.lh.whiskey.apimanager.RetrofitClient;
import com.lh.whiskey.models.Whisky;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class list_whisky extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listWhisky;
    List<Whisky> myWhisky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_whisky);
        listWhisky = findViewById(R.id.listWhisky);
        listWhisky.setOnItemClickListener(this);
        getFromIntenetWhisky();
    }



    private void getFromIntenetWhisky(){
        Call<List<Whisky>> call = RetrofitClient.getInstance().getMyApi().getWhiskys();
        call.enqueue(new Callback<List<Whisky>>() {

            @Override
            public void onResponse(Call<List<Whisky>> call, Response<List<Whisky>> response) {
                myWhisky = response.body();
                String message = "";
                WhiskyAdapter adapter = new WhiskyAdapter(list_whisky.this, myWhisky);
                listWhisky.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Whisky>> call, Throwable t) {
                Toast.makeText(list_whisky.this, "Error!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Intent Myintent = new Intent(this,informacion_whiky.class);
        Myintent.putExtra("slug", myWhisky.get(position).getSlugWhisky());
        Myintent.putExtra("url", myWhisky.get(position).getUrl());
        startActivity(Myintent);
    }
}