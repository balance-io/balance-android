package io.balance.data.model
import com.squareup.moshi.Json

data class TickerPrice(
    @Json(name = "24h_volume_usd")
    val hVolumeUsd: String, // 7283249335.05
    @Json(name = "available_supply")
    val availableSupply: String, // 105491233.0
    @Json(name = "id")
    val id: String, // ethereum
    @Json(name = "last_updated")
    val lastUpdated: String, // 1554210620
    @Json(name = "market_cap_usd")
    val marketCapUsd: String, // 16526439490.0
    @Json(name = "max_supply")
    val maxSupply: Any, // null
    @Json(name = "name")
    val name: String, // Ethereum
    @Json(name = "percent_change_1h")
    val percentChange1h: String, // 2.03
    @Json(name = "percent_change_24h")
    val percentChange24h: String, // 10.18
    @Json(name = "percent_change_7d")
    val percentChange7d: String, // 16.41
    @Json(name = "price_btc")
    val priceBtc: String, // 0.03275674
    @Json(name = "price_usd")
    val priceUsd: String, // 156.661733409
    @Json(name = "rank")
    val rank: String, // 2
    @Json(name = "symbol")
    val symbol: String, // ETH
    @Json(name = "total_supply")
    val totalSupply: String // 105491233.0
)