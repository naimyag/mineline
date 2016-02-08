package com.naimyag.ornek.mineline;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Provider;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class JsonApiProvider implements Provider<JsonApi> {

   // public static final String ENDPOINT = "http://78.46.64.29";
    public static final String ENDPOINT = "http://mineline.azurewebsites.net";

    @Override
    public JsonApi get() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
             //   .setLog(msg -> Log.i("Retrofit", msg))
                .build();

        return restAdapter.create(JsonApi.class);
    }
}
