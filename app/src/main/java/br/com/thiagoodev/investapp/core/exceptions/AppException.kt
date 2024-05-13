package br.com.thiagoodev.investapp.core.exceptions

open class AppException(private val error: String? = null) : Exception() {
    override fun toString(): String {
        if(error != null) {
            return error
        }
        return "Ocorreu um erro"
    }
}