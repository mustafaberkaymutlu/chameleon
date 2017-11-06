package net.epictimes.chameleon.data.remote;

import net.epictimes.chameleon.data.model.Tweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Services {

    String BASE_URL = "https://api.twitter.com/";

    String CONSUMER_KEY = "Eq4phU5L8YjFfMjIQ0CQZy7QF";
    String CONSUMER_SECRET = "RHJZ55srJCLurvgijPK6Eu9A39ijDLuVApl2aQQrdulr8vDtys";

    @Headers({
            "oauth_version: 1.0",
            "oauth_signature_method: HMAC-SHA1"
    })
    @POST("/oauth/request_token")
    Call<String> requestToken(@Header("oauth_consumer_key") String consumerKey);

    @GET("/1.1/fstatuses/home_timeline.json")
    Call<List<Tweet>> getTimeline();

}
