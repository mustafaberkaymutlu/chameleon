package net.epictimes.chameleon.data.remote;

import net.epictimes.chameleon.data.model.GetPhotosResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Services {

    String BASE_URL = "https://api.500px.com/";
    String CONSUMER_KEY = "e1SoJRCtEM050vGfwzh3LY2fOBw00uttzLEj1BuJ";
    String CONSUMER_SECRET = "dQYpXrn3uWbPeqS6gFXQLEN4lklpYMYUqJH77dlM";

    @GET("v1/photos?feature=popular&image_size=2048")
    Call<GetPhotosResponse> getPopularPhotos();

}
