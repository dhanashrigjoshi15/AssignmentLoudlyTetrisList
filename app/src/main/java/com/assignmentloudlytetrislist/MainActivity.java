package com.assignmentloudlytetrislist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.assignmentloudlytetrislist.data.APIResponse;
import com.assignmentloudlytetrislist.data.RepositoryData;
import com.assignmentloudlytetrislist.retrofit.RetrofitClient;
import com.assignmentloudlytetrislist.retrofit.RetrofitInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.assignmentloudlytetrislist.Constants.GET_VALUE;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<RepositoryData> repositoryDataList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        getRepositoryDataListFromRestApi();
    }

    //Get repository data from API
    private void getRepositoryDataListFromRestApi() {

        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show();

        //initialize retrofit
        RetrofitInterface retrofitInterface = RetrofitClient.getClient().create(RetrofitInterface.class);

        //retrofit get call with GET_VALUE as tetris
        Call<APIResponse> call = retrofitInterface.getRepositories(GET_VALUE);
        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {

                progressDialog.dismiss();
                APIResponse apiResponse = response.body();
                repositoryDataList = apiResponse.getRepositoryDataList();
                customAdapter = new CustomAdapter(getApplicationContext(), repositoryDataList);
                recyclerView.setAdapter(customAdapter);

            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }
}