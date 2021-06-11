package com.lh.whiskey;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.lh.whiskey.apimanager.RetrofitClient;
import com.lh.whiskey.models.Destileria;
import com.lh.whiskey.models.Whisky;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class informacion_destileria extends AppCompatActivity {

    TextView  txtNombreDesInfo;
    TextView txtFechaDes;
    TextView txtCantidadLotes;
    List<Destileria> myDestileria;
    private String slug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_destileria);
        txtNombreDesInfo = findViewById(R.id.txtNombreDesInfo);
        txtFechaDes = findViewById(R.id.txtFechaDes);
        txtCantidadLotes = findViewById(R.id.txtCantidadLotes);
        Bundle intent = getIntent().getExtras();
        slug = intent.getString("slug");

        getDestileriaBySlug(slug);
    }

    private void getDestileriaBySlug(String slug){
        Call <List<Destileria>> call = RetrofitClient.getInstance().getMyApi().getDestileria(slug);
        call.enqueue(new Callback<List<Destileria>> () {
            @Override
            public void onResponse(Call<List<Destileria>>  call, Response<List<Destileria>>  response) {
                myDestileria = response.body();
                String message = "";

                txtNombreDesInfo.setText(myDestileria.get(0).getNameDestileria());
                txtFechaDes.setText(myDestileria.get(0).getFecha());
                txtCantidadLotes.setText(myDestileria.get(0).getLoteDest());

            }

            @Override
            public void onFailure(Call<List<Destileria>>  call, Throwable t) {
                Toast.makeText(informacion_destileria.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}