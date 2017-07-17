package com.laptop.celldelegatedifficult.celldelegate;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laptop.celldelegatedifficult.R;
import com.laptop.celldelegatedifficult.celldelegate.base.BaseViewHolder;
import com.laptop.celldelegatedifficult.celldelegate.base.CellDelegate;
import com.laptop.celldelegatedifficult.celldelegate.base.OnCellDelegateClickListener;
import com.laptop.celldelegatedifficult.dataobject.GreenDataObject;
import com.laptop.celldelegatedifficult.dataobject.MainDataObjectWrapper;

import java.util.UUID;

import butterknife.BindView;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public final class GreenCellDelegate implements CellDelegate<MainDataObjectWrapper> {
    private static final int TYPE = UUID.randomUUID().hashCode();

    private OnCellDelegateClickListener<GreenDataObject> cellDelegateClickListener;

    public void setCellDelegateClickListener(
            OnCellDelegateClickListener<GreenDataObject> cellDelegateClickListener) {
        this.cellDelegateClickListener = cellDelegateClickListener;
    }

    @Override
    public boolean is(MainDataObjectWrapper item) {
        return item.greenDataObject != null;
    }

    @Override
    public int type() {
        return TYPE;
    }

    @Override
    public BaseViewHolder<MainDataObjectWrapper> holder(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.cell_color, parent, false);
        return new GreenViewHolder(view);
    }

    @Override
    public void bind(BaseViewHolder<MainDataObjectWrapper> holder, MainDataObjectWrapper item) {
        holder.bind(item);
    }

    public class GreenViewHolder extends BaseViewHolder<MainDataObjectWrapper> {
        @BindView(R.id.root_view_group)
        protected ViewGroup rootViewGroup;

        public GreenViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(MainDataObjectWrapper item) {
            final Context context = itemView.getContext();
            final GreenDataObject greenDataObject = item.greenDataObject;

            if (greenDataObject == null) {
                return;
            }

            rootViewGroup.setBackgroundColor(ContextCompat.getColor(context, greenDataObject.color));

            itemView.setOnClickListener(view -> {
                if (cellDelegateClickListener != null) {
                    cellDelegateClickListener.onCellDelegateClick(
                            itemView, getLayoutPosition(), greenDataObject);
                }
            });
        }
    }
}
