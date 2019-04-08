package io.balance.data.model
import com.squareup.moshi.Json


data class WalletBalances(
    @Json(name = "ETH")
    val eTH: ETH,
    @Json(name = "address")
    val address: String, // 0xb5c0f0ff448c4891e04fd88ff77e634e8c9d6e7b
    @Json(name = "countTxs")
    val countTxs: Int, // 492
    @Json(name = "tokens")
    val tokens: List<Token>
)

data class Token(
    @Json(name = "balance")
    val balance: Double, // 5.5978e+22
    @Json(name = "tokenInfo")
    val tokenInfo: TokenInfo,
    @Json(name = "totalIn")
    val totalIn: Int, // 0
    @Json(name = "totalOut")
    val totalOut: Int // 0
)

data class TokenInfo(
    @Json(name = "address")
    val address: String, // 0x77fe30b2cf39245267c0a5084b66a560f1cf9e1f
    @Json(name = "decimals")
    val decimals: String, // 18
    @Json(name = "holdersCount")
    val holdersCount: Int, // 353051
    @Json(name = "issuancesCount")
    val issuancesCount: Int, // 0
    @Json(name = "lastUpdated")
    val lastUpdated: Int, // 1554126366
    @Json(name = "name")
    val name: String, // Azbit
    @Json(name = "owner")
    val owner: String, // 0xacee5fec2e8861507a09c4f7a592dec36294dd48
    @Json(name = "price")
    val price: Boolean, // false
    @Json(name = "symbol")
    val symbol: String, // AZ
    @Json(name = "totalSupply")
    val totalSupply: String // 401408000000000000000000000000
)

data class ETH(
    @Json(name = "balance")
    val balance: Double // 1.2272217859289
)