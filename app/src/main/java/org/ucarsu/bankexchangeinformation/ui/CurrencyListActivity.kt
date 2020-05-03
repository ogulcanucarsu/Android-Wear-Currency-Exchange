package org.ucarsu.bankexchangeinformation.ui

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import androidx.wear.widget.WearableLinearLayoutManager
import kotlinx.android.synthetic.main.activity_currency_list.*
import org.ucarsu.bankexchangeinformation.R
import org.ucarsu.bankexchangeinformation.adapter.CurrencyListAdapter
import org.ucarsu.bankexchangeinformation.enums.Currency
import org.ucarsu.bankexchangeinformation.response.PriceBankList
import org.ucarsu.bankexchangeinformation.retrofit.ApiClient
import org.ucarsu.bankexchangeinformation.retrofit.RestInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CurrencyListActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_list)

        val currencyType = intent.getIntExtra("bundle_currency",-1)

        bankRecyclerView.setHasFixedSize(true)
        bankRecyclerView.isEdgeItemsCenteringEnabled = true
        bankRecyclerView.layoutManager = WearableLinearLayoutManager(this)

        val restInterface = ApiClient.getClient()?.create(RestInterface::class.java)
        var callService : Call<PriceBankList>? = null
        callService = when(currencyType){
            Currency.DOLLAR.ordinal -> {
                textViewHeader.text = "Bankalar - Dolar"
                restInterface?.getDollarCurrency()
            }
            Currency.EURO.ordinal -> {
                textViewHeader.text = "Bankalar - Euro"
                restInterface?.getEuroCurrency()
            }
            Currency.GOLD.ordinal -> {
                textViewHeader.text = "Bankalar - Altın"
                restInterface?.getGoldCurrency()
            }
            else -> {
                textViewHeader.text = "Bankalar - Dolar"
                restInterface?.getDollarCurrency()
            }
        }

        callService?.enqueue(object : Callback<PriceBankList?> {
            override fun onResponse(
                call: Call<PriceBankList?>?,
                response: Response<PriceBankList?>?
            ) {
                response?.body()?.let { priceBankList ->
                    setBankList(priceBankList)
                }
            }

            override fun onFailure(
                call: Call<PriceBankList?>?,
                t: Throwable?
            ) {
                //no-op
            }
        })
        setAmbientEnabled()
    }

    private fun setBankList(priceBankList: PriceBankList) {
        priceBankList.data?.let {
            bankRecyclerView.adapter =
                CurrencyListAdapter(
                    this,
                    priceBankList.data
                )
        }
    }
}
