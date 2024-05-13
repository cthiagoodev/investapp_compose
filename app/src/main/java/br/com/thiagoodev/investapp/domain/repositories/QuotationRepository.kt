package br.com.thiagoodev.investapp.domain.repositories

import br.com.thiagoodev.investapp.domain.models.Quotation

interface QuotationRepository {
    suspend fun list(page: Int): Quotation
}