package com.ali.retrofitjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ali.retrofitjava.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
   private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Post post=new Post(5,"Aly Mamdouh","Hi this is my post");

        // 3- Retrofit Builder
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")

                 // 4- Converter
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface=retrofit.create(ApiInterface.class);

        // 5- Call
       /*
          Get
       Call<List<Post>> call=apiInterface.getPost("1");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                binding.mainTitleTv.setText(response.body().get(0).getTitle());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                binding.mainTitleTv.setText(t.getMessage());
            }
        });*/

        // Post
        Call<Post> call=apiInterface.storePost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                binding.mainTitleTv.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                binding.mainTitleTv.setText(t.getMessage());
            }
        });
    }
}