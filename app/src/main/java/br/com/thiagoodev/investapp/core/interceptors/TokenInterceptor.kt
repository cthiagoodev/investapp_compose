package br.com.thiagoodev.investapp.core.interceptors

import br.com.thiagoodev.investapp.config.env
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request.Builder = chain.request().newBuilder()

        val token: String = env.get("API_KEY")
        request.addHeader("Authorization", "Bearer $token")

        return chain.proceed(request.build())
    }
}