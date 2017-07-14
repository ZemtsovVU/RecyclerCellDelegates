package com.laptop.celldelegatesimple;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.laptop.celldelegatesimple.recycler.BaseCellDelegateAdapter;
import com.laptop.celldelegatesimple.recycler.MarginItemDecoration;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;

    private BaseCellDelegateAdapter adapter;
    private RedCellDelegate redCellDelegate;
    private GreenCellDelegate greenCellDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
        initListeners();
        initRecyclerData();
    }

    //region Initialization section

    private void initViews() {
        adapter = new BaseCellDelegateAdapter();
        redCellDelegate = new RedCellDelegate();
        greenCellDelegate = new GreenCellDelegate();

        adapter.setCellDelegates(redCellDelegate, greenCellDelegate);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new MarginItemDecoration(R.dimen.size_small));
        recyclerView.setAdapter(adapter);
    }

    private void initListeners() {
        redCellDelegate.setCellDelegateClickListener((itemView, position, item) ->
                showMessage("Red cell clicked"));

        greenCellDelegate.setCellDelegateClickListener((itemView, position, item) ->
                showMessage("Green cell clicked"));
    }

    private void initRecyclerData() {
        adapter.setItems(Arrays.asList(
                new RedDataObject(),
                new RedDataObject(),
                new GreenDataObject(),
                new RedDataObject(),
                new GreenDataObject(),
                new RedDataObject()
        ));
    }

    //endregion

    private void showMessage(String message) {
        Snackbar.make(recyclerView, message, Snackbar.LENGTH_LONG).show();
    }
}
