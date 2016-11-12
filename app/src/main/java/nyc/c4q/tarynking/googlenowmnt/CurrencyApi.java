package nyc.c4q.tarynking.googlenowmnt;

import models.Currency;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Nesada on 11/11/2016.
 */
public interface CurrencyApi {

    String BASE_URL = "http://api.fixer.io/";

    @GET("latest?base=USD")
    Call<Currency> getCurrency();


    class Factory {
        private static CurrencyApi service;

        public static CurrencyApi getInstance() {

            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build();

                service = retrofit.create(CurrencyApi.class);
                return service;
            } else {
                return service;
            }

        }
    }

}
