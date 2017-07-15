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
import com.laptop.celldelegateaverage.celldelegate.base.ViewTypeable;
import com.laptop.celldelegateaverage.dataobject.ColorDataObject;

import java.util.UUID;

import butterknife.BindView;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public final class BlueCellDelegate implements CellDelegate<ColorDataObject> {
    private static final int TYPE = UUID.randomUUID().hashCode();

    private OnCellDelegateClickListener<ColorDataObject> cellDelegateClickListener;

    public void setCellDelegateClickListener(
            OnCellDelegateClickListener<ColorDataObject> cellDelegateClickListener) {
        this.cellDelegateClickListener = cellDelegateClickListener;
    }

    @Override
    public boolean is(ViewTypeable item) {
        return item.getViewType() == ColorDataObject.BLUE_VIEW_TYPE;
    }

    @Override
    public int type() {
        return TYPE;
    }

    @Override
    public BaseViewHolder<ColorDataObject> holder(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.cell_color, parent, false);
        return new BlueViewHolder(view);
    }

    @Override
    public void bind(BaseViewHolder<ColorDataObject> holder, ColorDataObject item) {
        holder.bind(item);
    }

    public class BlueViewHolder extends BaseViewHolder<ColorDataObject> {
        @BindView(R.id.root_view_group)
        protected ViewGroup rootViewGroup;

        public BlueViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(ColorDataObject item) {
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
