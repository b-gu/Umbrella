package benjamin.gu.umbrella.model;

import java.util.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //https://api.openweathermap.org/data/2.5/forecast?zip=30030&units=imperial&appid=42044777b90b9ec49b1d193f33ffec7f

    @GET("?")
    Observable<ResultsPojo>
    getWeatherResult(
            @Query("zip")
            @Query("units")
    );
}
