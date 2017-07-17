package com.laptop.celldelegatedifficult;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.laptop.celldelegatedifficult.celldelegate.BlueCellDelegate;
import com.laptop.celldelegatedifficult.celldelegate.GreenCellDelegate;
import com.laptop.celldelegatedifficult.celldelegate.RedCellDelegate;
import com.laptop.celldelegatedifficult.celldelegate.YellowCellDelegate;
import com.laptop.celldelegatedifficult.celldelegate.base.BaseCellDelegateAdapter;
import com.laptop.celldelegatedifficult.dataobject.ColorDataObject;
import com.laptop.celldelegatedifficult.dataobject.GreenDataObject;
import com.laptop.celldelegatedifficult.dataobject.MainDataObjectWrapper;
import com.laptop.celldelegatedifficult.dataobject.RedDataObject;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;

    private BaseCellDelegateAdapter<MainDataObjectWrapper> adapter;
    private RedCellDelegate redCellDelegate;
    private GreenCellDelegate greenCellDelegate;
    private BlueCellDelegate blueCellDelegate;
    private YellowCellDelegate yellowCellDelegate;

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
        adapter = new BaseCellDelegateAdapter<>();
        redCellDelegate = new RedCellDelegate();
        greenCellDelegate = new GreenCellDelegate();
        blueCellDelegate = new BlueCellDelegate();
        yellowCellDelegate = new YellowCellDelegate();

        adapter.setCellDelegates(
                redCellDelegate, greenCellDelegate, blueCellDelegate, yellowCellDelegate);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new MarginItemDecoration(R.dimen.size_small));
        recyclerView.setAdapter(adapter);
    }

    private void initListeners() {
        redCellDelegate.setCellDelegateClickListener((itemView, position, item) ->
                showMessage("Red cell clicked"));

        greenCellDelegate.setCellDelegateClickListener((itemView, position, item) ->
                showMessage("Green cell clicked"));

        blueCellDelegate.setCellDelegateClickListener((itemView, position, item) ->
                showMessage("Blue cell clicked"));

        yellowCellDelegate.setCellDelegateClickListener((itemView, position, item) ->
                showMessage("Yellow cell clicked"));
    }

    private void initRecyclerData() {
        adapter.setItems(Arrays.asList(
                new MainDataObjectWrapper(new RedDataObject()),
                new MainDataObjectWrapper(new RedDataObject()),
                new MainDataObjectWrapper(new GreenDataObject()),
                new MainDataObjectWrapper(new ColorDataObject(ColorDataObject.Type.BLUE, android.R.color.holo_blue_dark)),
                new MainDataObjectWrapper(new RedDataObject()),
                new MainDataObjectWrapper(new GreenDataObject()),
                new MainDataObjectWrapper(new ColorDataObject(ColorDataObject.Type.YELLOW, android.R.color.holo_orange_dark)),
                new MainDataObjectWrapper(new RedDataObject())
        ));
    }

    //endregion

    private void showMessage(String message) {
        Snackbar.make(recyclerView, message, Snackbar.LENGTH_LONG).show();
    }
}
