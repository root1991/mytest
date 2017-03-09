package test.badoo.com.andrewkhrystiantest.flow.transactions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.List;

import test.badoo.com.andrewkhrystiantest.R;
import test.badoo.com.andrewkhrystiantest.base.BaseMvpActivity;
import test.badoo.com.andrewkhrystiantest.data.model.TransactionDetail;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public class TransactionActivity extends BaseMvpActivity<TransactionPresenter> implements TransactionContract.View {

    private static final String TRANSACTION_NAME = "transactionName";

    private RecyclerView mRecyclerViewTransactions;
    private TextView mTextViewTotal;
    private Toolbar mToolbar;

    public static Intent newIntent(Context context, String transactionName) {
        Intent intent = new Intent(context, TransactionActivity.class);
        intent.putExtra(TRANSACTION_NAME, transactionName);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_details);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerViewTransactions = (RecyclerView) findViewById(R.id.recycler_view_products);
        mTextViewTotal = (TextView) findViewById(R.id.text_view_total_pounds);

        String transactionName = getIntent().getStringExtra(TRANSACTION_NAME);
        setupToolbar(transactionName);
        mPresenter.generateData(transactionName);
    }

    private void setupToolbar(String transactionName) {
        mToolbar.setTitle(String.format(getString(R.string.transaction_for), transactionName));
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @NonNull
    @Override
    protected TransactionPresenter getPresenterInstance() {
        return new TransactionPresenter();
    }

    @Override
    public void showResults(List<TransactionDetail> transactionDetails) {
        TransactionsAdapter adapter = new TransactionsAdapter(transactionDetails);
        mRecyclerViewTransactions.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewTransactions.setAdapter(adapter);
    }

    @Override
    public void showTotalPounds(String totalPounds) {
        mTextViewTotal.setText(totalPounds);
    }
}
