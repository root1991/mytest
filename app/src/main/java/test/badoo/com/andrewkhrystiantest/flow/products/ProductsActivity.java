package test.badoo.com.andrewkhrystiantest.flow.products;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import test.badoo.com.andrewkhrystiantest.R;
import test.badoo.com.andrewkhrystiantest.base.BaseMvpActivity;
import test.badoo.com.andrewkhrystiantest.data.model.Transaction;
import test.badoo.com.andrewkhrystiantest.flow.transactions.TransactionActivity;
import test.badoo.com.andrewkhrystiantest.interfaces.OnItemClickListener;

public class ProductsActivity extends BaseMvpActivity<ProductsContract.Presenter> implements ProductsContract.View {

    private RecyclerView mRecyclerViewProducts;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerViewProducts = (RecyclerView) findViewById(R.id.recycler_view_products);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar();
        mPresenter.generateData();
    }

    @NonNull
    @Override
    protected ProductsContract.Presenter getPresenterInstance() {
        return new ProductsPresenter();
    }

    @Override
    public void showResults(List<Transaction> results) {
        ProductsAdapter adapter = new ProductsAdapter(results);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClicked(Transaction transaction) {
                startActivity(TransactionActivity.newIntent(ProductsActivity.this, transaction.getTransactionName()));
            }
        });
        mRecyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewProducts.setAdapter(adapter);
    }

    private void setupToolbar() {
        mToolbar.setTitle(getString(R.string.products));
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
