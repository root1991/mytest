package test.badoo.com.andrewkhrystiantest.manager

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import test.badoo.com.andrewkhrystiantest.data.model.CurrencyModel
import test.badoo.com.andrewkhrystiantest.data.model.RoughTransaction
import test.badoo.com.andrewkhrystiantest.data.model.Transaction
import test.badoo.com.andrewkhrystiantest.data.model.TransactionDetail
import test.badoo.com.andrewkhrystiantest.interfaces.Util
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

/**
 * Created by andrewkhristyan on 3/9/17.
 */

class DataManager {

    private lateinit var mRoughTransactions: List<RoughTransaction>
    private lateinit var mCurrencyModels: List<CurrencyModel>
    private lateinit var context: Context


    fun init(context: Context) {
        this.context = context
        try {
            mRoughTransactions = Gson().fromJson<List<RoughTransaction>>(readFile(context, TRANSACTIONS), object : TypeToken<ArrayList<RoughTransaction>>() {
            }.type)
        } catch (e: IOException) {
            mRoughTransactions = mutableListOf()
            e.printStackTrace()
        }

    }

    fun getListOfProducts(): MutableList<Transaction>? =
            mRoughTransactions.groupBy { it.sku }.map { Transaction(it.key, it.value.size) }.toMutableList()

    fun getTransactionsByName(transactionName: String, destCurrency: String): List<TransactionDetail> {
        mCurrencyModels = Gson().fromJson<List<CurrencyModel>>(readFile(context, RATES), object : TypeToken<ArrayList<CurrencyModel>>() {
        }.type)
        return mRoughTransactions
                .filter { it.sku == transactionName }
                .map {
                    val currencyRate = getCurrentTransaction(it.currency, destCurrency)?.rate
                    val price = Util.times(it.amount, currencyRate!!)
                    TransactionDetail(it.amount.toString(), price, it.currency)
                }
    }

    fun getTotalPounds(details: List<TransactionDetail>) : Double = details.sumByDouble { it.priceInPounds }


    @Throws(IOException::class)
    private fun readFile(context: Context, fileName: String): String {
        val stream = context.assets.open(fileName)
        BufferedReader(InputStreamReader(stream)).use { br ->
            val sb = StringBuilder()
            var line: String? = br.readLine()

            while (line != null) {
                sb.append(line)
                sb.append("\n")
                line = br.readLine()
            }
            return sb.toString()
        }
    }

    private fun getCurrentTransaction(currencyName: String, destCurrency: String): CurrencyModel? {
        val currentCurrency = mCurrencyModels.filter { it.from == currencyName }
        var trans: CurrencyModel? = currentCurrency.find { it.to == destCurrency }
        if (currencyName == destCurrency) {
            trans = CurrencyModel()
            trans.rate = 1.0
        }

        if (trans == null) {
            val tempTrans = currentCurrency.first()
            trans = mCurrencyModels.filter { it.from == tempTrans.to }.find { it.to == destCurrency }
            var newTrans = trans
            newTrans?.rate = trans?.rate!! * tempTrans.rate
            return newTrans
        }
        return trans
    }


    companion object {

        private val TRANSACTIONS = "transactsdaions.json"
        private val RATES = "rates.json"
    }

}

