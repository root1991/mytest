package test.badoo.com.andrewkhrystiantest.flow.products;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import test.badoo.com.andrewkhrystiantest.R;
import test.badoo.com.andrewkhrystiantest.data.model.Transaction;
import test.badoo.com.andrewkhrystiantest.interfaces.OnItemClickListener;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<Transaction> mTransactions;
    private OnItemClickListener mOnItemClickListener;

    public ProductsAdapter(List<Transaction> transactions) {
        mTransactions = transactions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction, parent, false);
        return new ViewHolder(itemView);
    }

    void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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

        private void bindData(final Transaction transaction) {
            mTextViewName.setText(transaction.getTransactionName());
            String amount = itemView.getContext().getResources().getQuantityString(R.plurals.transaction, transaction.getTransactionsAmount());
            mTextViewCount.setText(String.format(amount, transaction.getTransactionsAmount()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClicked(transaction);
                    }
                }
            });
        }

    }
}
