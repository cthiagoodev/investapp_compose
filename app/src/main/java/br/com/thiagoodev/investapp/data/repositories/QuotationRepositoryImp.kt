package br.com.thiagoodev.investapp.data.repositories

import br.com.thiagoodev.investapp.core.exceptions.NoDataException
import br.com.thiagoodev.investapp.data.datasources.QuotationDataSource
import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.domain.repositories.QuotationRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class QuotationRepositoryImp @Inject constructor(
    private val source: QuotationDataSource) : QuotationRepository {
    override suspend fun list(page: Int, limit: Int): Quotation {
        val response: Response<Quotation> = source.list(page, limit)

        if(!response.isSuccessful || response.body() == null) {
            var message: String = response.message()

            val errorBody: ResponseBody? = response.errorBody()
            if(errorBody != null) {
                val errorEncoded: String = errorBody.string()
                val type = object : TypeToken<Map<String, Any>>() {}.type
                val errorJson: Map<String, Any> = Gson().fromJson(errorEncoded, type)

                if(errorJson.containsKey("message")) {
                    message = errorJson["message"] as String
                }
            }

            throw NoDataException(message)
        }

        return response.body()!!
    }
}