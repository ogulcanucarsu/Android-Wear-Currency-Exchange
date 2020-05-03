package org.ucarsu.bankexchangeinformation.response

import com.google.gson.annotations.SerializedName

data class PriceBankList(
    @SerializedName("GetPriceBankListResult") val data: List<Bank>?
)
data class Bank(
    @SerializedName("bankName") val bankName: String?,
    @SerializedName("buyPrice") val buyPrice: String?,
    @SerializedName("buyStatus") val buyStatus: String?,
    @SerializedName("sellPrice") val sellPrice: String?,
    @SerializedName("sellStatus") val sellStatus: String?,
    @SerializedName("currencyType") val currencyType: String?
)