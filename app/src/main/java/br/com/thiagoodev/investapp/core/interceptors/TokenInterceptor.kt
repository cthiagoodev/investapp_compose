package br.com.thiagoodev.investapp.core.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request.Builder = chain.request().newBuilder()
        request.addHeader("Authorization", "Bearer 9FXhQvcbGQKhVWjdRoXyxA")

        return chain.proceed(request.build())
    }
}