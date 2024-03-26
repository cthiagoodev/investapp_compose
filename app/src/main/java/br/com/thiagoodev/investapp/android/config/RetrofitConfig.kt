package br.com.thiagoodev.investapp.android.config

import br.com.thiagoodev.investapp.android.basics.interceptors.TokenInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class RetrofitConfig {
    companion object {
        fun init() {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://brapi.dev")
                .client(client())
                .build()
        }

        private fun client(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor())
            .build()
    }
}