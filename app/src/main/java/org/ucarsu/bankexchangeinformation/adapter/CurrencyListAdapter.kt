package org.ucarsu.bankexchangeinformation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.ucarsu.bankexchangeinformation.R
import org.ucarsu.bankexchangeinformation.response.Bank


class CurrencyListAdapter(
    private val context: Context,
    private val dataArgs: List<Bank>
) :
    RecyclerView.Adapter<CurrencyListAdapter.RecyclerViewHolder>() {
    private var dataSource: List<Bank>? = null

    init {
        dataSource = dataArgs
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_bank, parent, false)
        return RecyclerViewHolder(
            view
        )
    }

    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var bankName: TextView = view.findViewById(R.id.textViewBankName)
        var buyPrice: TextView = view.findViewById(R.id.textViewBuyPrice)
        var sellPrice: TextView = view.findViewById(R.id.textViewSellPrice)
    }

    override fun onBindViewHolder(
        holder: RecyclerViewHolder,
        position: Int
    ) {
        dataSource?.let {
            val dataProvider = dataSource!![position]
            holder.bankName.text = "${dataProvider.bankName}"
            holder.buyPrice.text = "Banka Alış: ${dataProvider.buyPrice}"
            holder.sellPrice.text = "Banka Satış: ${dataProvider.sellPrice}"
        }
    }

    override fun getItemCount(): Int {
        return dataSource!!.size
    }
}