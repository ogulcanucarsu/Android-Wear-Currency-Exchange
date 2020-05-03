package org.ucarsu.bankexchangeinformation.ui

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.ucarsu.bankexchangeinformation.R
import org.ucarsu.bankexchangeinformation.enums.Currency

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutDollar.setOnClickListener {
            val intent = Intent(this, CurrencyListActivity::class.java)
            intent.putExtra("bundle_currency", Currency.DOLLAR.ordinal)
            startActivity(intent)
        }

        linearLayoutEuro.setOnClickListener {
            val intent = Intent(this, CurrencyListActivity::class.java)
            intent.putExtra("bundle_currency", Currency.EURO.ordinal)
            startActivity(intent)
        }

        linearLayoutGold.setOnClickListener {
            val intent = Intent(this, CurrencyListActivity::class.java)
            intent.putExtra("bundle_currency", Currency.GOLD.ordinal)
            startActivity(intent)
        }
        setAmbientEnabled()
    }
}
