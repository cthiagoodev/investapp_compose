package br.com.thiagoodev.investapp.android.core.interceptors

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain
            .request()
            .newBuilder()
            .url(addTokenInUrl(chain.request().url()))
            .build()

        return chain.proceed(request);
    }

    private fun addTokenInUrl(url: HttpUrl): HttpUrl {
        if(url.queryParameter("token") == null) {
            return url
                .newBuilder()
                .addQueryParameter("token", "")
                .build()
        }

        return url;
    }
}