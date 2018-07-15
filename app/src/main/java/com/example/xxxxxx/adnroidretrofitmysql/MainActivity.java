package com.example.xxxxxx.adnroidretrofitmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xxxxxx.adnroidretrofitmysql.api.ApiRequest;
import com.example.xxxxxx.adnroidretrofitmysql.api.RetroServer;
import com.example.xxxxxx.adnroidretrofitmysql.model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText txtnpm,txtnama,txtprodi,txtfakeultas;
    Button btnInsert,btnListData;
    String npm,nama,prodi,fakeultas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnpm = findViewById(R.id.npm);
        txtnama = findViewById(R.id.nama);
        txtprodi = findViewById(R.id.prodi);
        txtfakeultas = findViewById(R.id.fakeultas);

        btnInsert = findViewById(R.id.btnInsert);
        btnListData = findViewById(R.id.btnlistData);

        btnListData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ListDataActivity.class);
                startActivity(intent);
            }
        });

        final ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                npm=txtnpm.getText().toString();
                nama=txtnama.getText().toString();
                prodi=txtprodi.getText().toString();
                fakeultas=txtfakeultas.getText().toString();

                Call<ResponseModel> sendview= api.sendData(npm,nama,prodi,fakeultas);
                sendview.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        //Log.d("RETRO","response: "+response.body().toString());
//                        String kode = response.body().getKode();
//                        if (kode=="1"){
//                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
//                        }else{
//                            Toast.makeText(MainActivity.this, "Data Error", Toast.LENGTH_SHORT).show();
//                        }
                        Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Log.d("RETRO","Failure : "+"Data Error");
                    }
                });
            }
        });
    }
}
