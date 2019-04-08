package io.balance.data.model
import com.squareup.moshi.Json

data class CDP(
    @Json(name = "act")
    val act: String, // give
    @Json(name = "arg")
    val arg: Any, // null
    @Json(name = "art")
    val art: Double, // 0.3
    @Json(name = "block")
    val block: Int, // 7458765
    @Json(name = "deleted")
    val deleted: Boolean, // false
    @Json(name = "id")
    val id: Int, // 16250
    @Json(name = "ink")
    val ink: Double, // 0.009607279374823263
    @Json(name = "ire")
    val ire: Double, // 0.29547314219345344
    @Json(name = "lad")
    val lad: String, // 0xD2a3334183fb61c3770E3658d7127B410768A210
    @Json(name = "liq_price")
    val liqPrice: Int, // 45
    @Json(name = "pep")
    val pep: Double, // 755.3990625
    @Json(name = "per")
    val per: String, // 1.0408774024211158
    @Json(name = "pip")
    val pip: Double, // 155.6275
    @Json(name = "ratio")
    val ratio: Double, // 518.7583333333333
    @Json(name = "tab")
    val tab: Double, // 1.5562749999999999
    @Json(name = "time")
    val time: String, // 2019-03-28T19:09:47.000Z
    @Json(name = "timestamp")
    val timestamp: Long // 1553800187000
)