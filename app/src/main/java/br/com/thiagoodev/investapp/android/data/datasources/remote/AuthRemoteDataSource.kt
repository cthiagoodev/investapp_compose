package br.com.thiagoodev.investapp.android.data.datasources.remote

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(private val auth: FirebaseAuth) {
    suspend fun auth(email: String, password: String): AuthResult {
        val authTask: Task<AuthResult> = auth.signInWithEmailAndPassword(email, password)
        return authTask.await()
    }
}