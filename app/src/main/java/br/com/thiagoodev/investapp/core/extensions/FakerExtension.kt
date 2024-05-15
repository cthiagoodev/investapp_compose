package br.com.thiagoodev.investapp.core.extensions

import br.com.thiagoodev.investapp.domain.models.Index
import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.domain.models.Stock

fun Quotation.Companion.fake(): Quotation {
    return Quotation(
        indexes = listOf(
            Index("AAPL", "Apple Inc."),
            Index("TSLA", "Tesla Inc.")
        ),
        stocks = listOf(
            Stock(
                "AAPL",
                "Apple Inc.",
                150.23,
                1.25,
                1000000.0,
                2000000000.0,
                "https://...apple_logo.png",
                "Technology",
                "Large Cap"
            ),
            Stock(
                "TSLA",
                "Tesla Inc.",
                750.34,
                -2.11,
                500000.0,
                1000000000.0,
                "https://...tesla_logo.png",
                "Automotive",
                "Large Cap"
            )
        ),
        availableSectors = listOf("Technology", "Automotive", "Healthcare"),
        availableStockTypes = listOf("Large Cap", "Mid Cap", "Small Cap"),
        currentPage = 1,
        totalPages = 10,
        itemsPerPage = 100,
        totalCount = 1000,
        hasNextPage = true
    )
}
