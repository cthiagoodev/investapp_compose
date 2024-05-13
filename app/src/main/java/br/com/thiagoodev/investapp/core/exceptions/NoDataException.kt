package br.com.thiagoodev.investapp.core.exceptions

class NoDataException(private val error: String? = null) : AppException() {
    override fun toString(): String {
        if(error != null) {
            return error
        }
        return "Não foi encontrado nenhuma informação"
    }
}