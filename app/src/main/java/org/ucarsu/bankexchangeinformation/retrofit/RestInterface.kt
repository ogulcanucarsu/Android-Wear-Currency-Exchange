package org.ucarsu.bankexchangeinformation.retrofit

import org.ucarsu.bankexchangeinformation.response.PriceBankList
import retrofit2.http.GET
import retrofit2.Call

interface RestInterface {
    @GET("currency_type=usd")
    fun getDollarCurrency(): Call<PriceBankList>?

    @GET("currency_type=euro")
    fun getEuroCurrency(): Call<PriceBankList>?

    @GET("currency_type=gold")
    fun getGoldCurrency(): Call<PriceBankList>?
}