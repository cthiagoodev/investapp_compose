package br.com.thiagoodev.investapp.android.core.extensions

import br.com.thiagoodev.investapp.android.domain.models.User
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser

fun User.Companion.fromFirebase(authResult: AuthResult): User {
    val user: FirebaseUser = authResult.user!!
    return User(
        id = user.uid,
        name = user.displayName ?: "",
        email = user.email ?: "",
        profileImage = user.photoUrl?.path ?: "",
    )
}