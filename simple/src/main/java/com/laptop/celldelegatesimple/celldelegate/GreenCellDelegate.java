package com.laptop.celldelegatesimple.celldelegate;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laptop.celldelegatesimple.R;
import com.laptop.celldelegatesimple.dataobject.GreenDataObject;
import com.laptop.celldelegatesimple.celldelegate.base.BaseViewHolder;
import com.laptop.celldelegatesimple.celldelegate.base.CellDelegate;
import com.laptop.celldelegatesimple.celldelegate.base.OnCellDelegateClickListener;

import butterknife.BindView;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public final class GreenCellDelegate implements CellDelegate<GreenDataObject> {
    private static final int LAYOUT_ID = R.layout.cell_color;

    private OnCellDelegateClickListener<GreenDataObject> cellDelegateClickListener;

    public void setCellDelegateClickListener(
            OnCellDelegateClickListener<GreenDataObject> cellDelegateClickListener) {
        this.cellDelegateClickListener = cellDelegateClickListener;
    }

    @Override
    public boolean is(Object item) {
        return item instanceof GreenDataObject;
    }

    @Override
    public int type() {
//        return LAYOUT_ID;
        return 20; // TODO: 14.07.2017
    }

    @Override
    public BaseViewHolder holder(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(LAYOUT_ID, parent, false);
        return new GreenViewHolder(view);
    }

    @Override
    public void bind(BaseViewHolder<GreenDataObject> holder, GreenDataObject item) {
        holder.bind(item);
    }

    public class GreenViewHolder extends BaseViewHolder<GreenDataObject> {
        @BindView(R.id.root_view_group)
        protected ViewGroup rootViewGroup;

        public GreenViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(GreenDataObject item) {
            final Context context = itemView.getContext();
            rootViewGroup.setBackgroundColor(ContextCompat.getColor(context, item.color));

            itemView.setOnClickListener(view -> {
                if (cellDelegateClickListener != null) {
                    cellDelegateClickListener.onCellDelegateClick(itemView, getLayoutPosition(), item);
                }
            });
        }
    }
}
