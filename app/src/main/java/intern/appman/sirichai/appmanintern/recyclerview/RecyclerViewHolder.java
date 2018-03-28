package intern.appman.sirichai.appmanintern.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import intern.appman.sirichai.appmanintern.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    protected TextView docTypeTv;
    private ItemClickListener itemClickListener;

    protected RecyclerViewHolder(View itemView) {
        super(itemView);
        docTypeTv = itemView.findViewById(R.id.docTypeTv);
        itemView.setOnClickListener(this);
    }

    protected void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), true);
        return true;
    }
}
