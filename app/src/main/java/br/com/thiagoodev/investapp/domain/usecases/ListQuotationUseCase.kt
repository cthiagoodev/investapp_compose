package br.com.thiagoodev.investapp.domain.usecases

import br.com.thiagoodev.investapp.domain.models.Quotation

interface ListQuotationUseCase {
    suspend fun list(page: Int): Quotation
}