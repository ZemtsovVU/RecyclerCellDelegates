package com.laptop.celldelegateaverage.celldelegate;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laptop.celldelegateaverage.R;
import com.laptop.celldelegateaverage.celldelegate.base.BaseViewHolder;
import com.laptop.celldelegateaverage.celldelegate.base.CellDelegate;
import com.laptop.celldelegateaverage.celldelegate.base.OnCellDelegateClickListener;
import com.laptop.celldelegateaverage.dataobject.GreenDataObject;
import com.laptop.celldelegateaverage.celldelegate.base.ViewTypeable;

import butterknife.BindView;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public final class GreenCellDelegate implements CellDelegate<GreenDataObject> {
    private OnCellDelegateClickListener<GreenDataObject> cellDelegateClickListener;

    public void setCellDelegateClickListener(
            OnCellDelegateClickListener<GreenDataObject> cellDelegateClickListener) {
        this.cellDelegateClickListener = cellDelegateClickListener;
    }

    @Override
    public boolean is(ViewTypeable item) {
        return item.getViewType() == GreenDataObject.VIEW_TYPE;
    }

    @Override
    public int type() {
        return GreenDataObject.VIEW_TYPE;
    }

    @Override
    public BaseViewHolder holder(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.cell_color, parent, false);
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
