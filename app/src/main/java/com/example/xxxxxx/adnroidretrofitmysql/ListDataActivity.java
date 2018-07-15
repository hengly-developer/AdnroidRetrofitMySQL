package com.example.xxxxxx.adnroidretrofitmysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.xxxxxx.adnroidretrofitmysql.adapter.AdapterData;
import com.example.xxxxxx.adnroidretrofitmysql.api.ApiRequest;
import com.example.xxxxxx.adnroidretrofitmysql.api.RetroServer;
import com.example.xxxxxx.adnroidretrofitmysql.model.DataModel;
import com.example.xxxxxx.adnroidretrofitmysql.model.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListDataActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<DataModel> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> getData = api.getData();
        getData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                list = response.body().getResult();

                adapter = new AdapterData(list,ListDataActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }
}
