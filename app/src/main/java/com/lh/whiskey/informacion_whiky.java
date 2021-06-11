package com.lh.whiskey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.lh.whiskey.apimanager.RetrofitClient;
import com.lh.whiskey.models.Destileria;
import com.lh.whiskey.models.Whisky;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class informacion_whiky extends AppCompatActivity implements View.OnClickListener{
    private String slug;
    private String url;
    List<Whisky> myWhisky;
    TextView txtFechaWisky;
    TextView txtLoteWhysky;

    Button btnPagina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_whiky);

       txtFechaWisky = findViewById(R.id.txtFechaWisky);

        txtLoteWhysky = findViewById(R.id.txtLoteWhysky);
        btnPagina = findViewById(R.id.btnPagina);
        Bundle intent = getIntent().getExtras();
        slug = intent.getString("slug");
        Bundle in = getIntent().getExtras();
        url = in.getString("url");


       btnPagina.setOnClickListener(this);
        getWhiskyBySlug(slug);
    }
    /*txtFechaWisky.setText(myWhisky.get(0).getDt());
                   txtNombreWiskyinfo.setText(myWhisky.get(0).getNameWhisky());
                   txtLoteWhysky.setText(myWhisky.get(0).getLote());*/

    private void getWhiskyBySlug(String slug) {
        Call<List<Whisky>> call = RetrofitClient.getInstance().getMyApi().getWhisky(slug);
        call.enqueue(new Callback<List<Whisky>>() {
            @Override
            public void onResponse(Call<List<Whisky>> call, Response<List<Whisky>> response) {
                myWhisky = response.body();
                String message = "";


                txtFechaWisky.setText(myWhisky.get(0).getDt());
                txtLoteWhysky.setText(myWhisky.get(0).getLote());
            }

            @Override
            public void onFailure(Call<List<Whisky>> call, Throwable t) {
                Toast.makeText(informacion_whiky.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onClick(View v) {
       Uri uri = Uri.parse(url);
        if (v.getId() == R.id.btnPagina){
            Intent Myintent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(Myintent);

        }
    }
}