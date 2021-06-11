package com.lh.whiskey.apimanager;

import com.lh.whiskey.models.Destileria;
import com.lh.whiskey.models.Whisky;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    String BASE_URL = "https://whiskyhunter.net/api/";


    @GET("auctions_info")
    Call<List<Whisky>> getWhiskys();

    @GET("distilleries_info/")
    Call<List<Destileria>> getDestilerias();

    @GET("auction_data/{slug}/")
    Call<List<Whisky>> getWhisky(@Path("slug") String slug);



    @GET("distillery_data/{slug}/")
    Call<List<Destileria>> getDestileria(@Path("slug") String slug);


}
