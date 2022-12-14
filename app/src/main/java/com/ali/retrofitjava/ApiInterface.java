package com.ali.retrofitjava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

// 2- Api Interface
public interface ApiInterface {
     @GET("posts")
     /* change number of posts dynamically
     @GET("posts/{id}")
     Call<Post> getPost(@Path("id") int postId);*/

          /*
          // just one post to display it
             @GET("posts/1")
             Call<Post> getPost();
             */
     // Query list of posts
     Call<List<Post>> getPost(@Query("userId") String userId);

     // Post
     @POST("posts")
     Call<Post> storePost(@Body Post post);
}
