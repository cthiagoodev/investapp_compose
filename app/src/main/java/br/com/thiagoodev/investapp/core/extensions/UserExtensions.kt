package br.com.thiagoodev.investapp.core.extensions

import br.com.thiagoodev.investapp.domain.models.User
import com.google.firebase.auth.AuthResult

fun User.Companion.fromFirebase(result: AuthResult): User {
    return User(
        uuid = result.user!!.uid,
        email = result.user!!.email ?: "",
        profileImage = result.user!!.photoUrl?.path ?: "",
        name = result.user!!.displayName!!,
    )
}