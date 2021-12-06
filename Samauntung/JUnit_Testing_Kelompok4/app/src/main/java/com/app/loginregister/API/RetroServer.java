package com.app.loginregister.API;

public class RetroServer {
    private static final String baseURL = "http://192.168.1.8/laundry/";
    private static Retrofit retro;

    public static Retrofit konekRetrofit(){
        if(retro == null){
            retro = new Retrofit.Builder ()
                    .baseUrl ( baseURL )
                    .addConverterFactory ( GsonConverterFactory.create ())
                    .build();
        }
        return  retro;
    }
}
