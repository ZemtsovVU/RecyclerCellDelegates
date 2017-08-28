package com.laptop.celldelegatesimple.celldelegate;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laptop.celldelegatesimple.R;
import com.laptop.celldelegatesimple.celldelegate.base.BaseCellDelegate;
import com.laptop.celldelegatesimple.celldelegate.base.BaseViewHolder;
import com.laptop.celldelegatesimple.celldelegate.base.OnCellDelegateClickListener;
import com.laptop.celldelegatesimple.dataobject.GreenDataObject;

import butterknife.BindView;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public final class GreenCellDelegate extends BaseCellDelegate<GreenDataObject> {
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
    public BaseViewHolder<GreenDataObject> holder(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.cell_color, parent, false);
        return new GreenViewHolder(view);
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
