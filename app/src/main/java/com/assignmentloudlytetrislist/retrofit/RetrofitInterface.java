//Interface class of Retrofit to raise query

package com.assignmentloudlytetrislist.retrofit;

import com.assignmentloudlytetrislist.data.APIResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    //GET call with query parameter
    @GET("search/repositories")
    Call<APIResponse> getRepositories(@Query("q") String value);
}
