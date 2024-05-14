package br.com.thiagoodev.investapp.domain.usecases

import br.com.thiagoodev.investapp.domain.models.Quotation

interface ListQuotationsUseCase {
    suspend fun list(page: Int = 0): Quotation
}