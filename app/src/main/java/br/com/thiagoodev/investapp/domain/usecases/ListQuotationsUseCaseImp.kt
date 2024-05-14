package br.com.thiagoodev.investapp.domain.usecases

import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.domain.repositories.QuotationRepository
import javax.inject.Inject

class ListQuotationsUseCaseImp @Inject constructor(
    private val repository: QuotationRepository) : ListQuotationsUseCase {

    override suspend fun list(page: Int): Quotation {
        return repository.list(page)
    }
}