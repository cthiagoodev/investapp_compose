package br.com.thiagoodev.investapp.core.extensions

import br.com.thiagoodev.investapp.domain.models.User
import com.google.firebase.auth.AuthResult

fun User.fromFirebase(result: AuthResult): User {
    return User(
        uuid = result.user?.uid ?: "",
    );
}