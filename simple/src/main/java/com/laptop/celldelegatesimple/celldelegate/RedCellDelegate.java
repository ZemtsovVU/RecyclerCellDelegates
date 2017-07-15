package com.laptop.celldelegatesimple.celldelegate;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laptop.celldelegatesimple.R;
import com.laptop.celldelegatesimple.celldelegate.base.BaseViewHolder;
import com.laptop.celldelegatesimple.celldelegate.base.CellDelegate;
import com.laptop.celldelegatesimple.celldelegate.base.OnCellDelegateClickListener;
import com.laptop.celldelegatesimple.dataobject.RedDataObject;

import java.util.UUID;

import butterknife.BindView;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public final class RedCellDelegate implements CellDelegate<RedDataObject> {
    private static final int TYPE = UUID.randomUUID().hashCode();

    private OnCellDelegateClickListener<RedDataObject> cellDelegateClickListener;

    public void setCellDelegateClickListener(
            OnCellDelegateClickListener<RedDataObject> cellDelegateClickListener) {
        this.cellDelegateClickListener = cellDelegateClickListener;
    }

    @Override
    public boolean is(Object item) {
        return item instanceof RedDataObject;
    }

    @Override
    public int type() {
        return TYPE;
    }

    @Override
    public BaseViewHolder<RedDataObject> holder(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.cell_color, parent, false);
        return new RedViewHolder(view);
    }

    @Override
    public void bind(BaseViewHolder<RedDataObject> holder, RedDataObject item) {
        holder.bind(item);
    }

    public class RedViewHolder extends BaseViewHolder<RedDataObject> {
        @BindView(R.id.root_view_group)
        protected ViewGroup rootViewGroup;

        public RedViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(RedDataObject item) {
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
