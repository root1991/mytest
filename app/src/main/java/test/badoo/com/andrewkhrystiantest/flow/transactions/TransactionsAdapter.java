package test.badoo.com.andrewkhrystiantest.flow.transactions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import test.badoo.com.andrewkhrystiantest.R;
import test.badoo.com.andrewkhrystiantest.data.model.TransactionDetail;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.ViewHolder> {

    private List<TransactionDetail> mTransactions;

    public TransactionsAdapter(List<TransactionDetail> transactions) {
        mTransactions = transactions;
    }

    @Override
    public TransactionsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction, parent, false);
        return new TransactionsAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TransactionsAdapter.ViewHolder holder, int position) {
        holder.bindData(mTransactions.get(position));
    }

    @Override
    public int getItemCount() {
        return mTransactions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewName;
        private TextView mTextViewCount;

        public ViewHolder(View itemView) {
            super(itemView);

            mTextViewCount = (TextView) itemView.findViewById(R.id.text_view_count);
            mTextViewName = (TextView) itemView.findViewById(R.id.text_view_name);
        }

        private void bindData(final TransactionDetail transaction) {
            String currencyWithPrice = transaction.getCurrency() + transaction.getPrice();
            mTextViewName.setText(currencyWithPrice);

            DecimalFormat f = new DecimalFormat("#.00");
            String priceInGBP = "GBP:" + f.format(transaction.getPriceInPounds());
            mTextViewCount.setText(priceInGBP);
        }

    }
}
