package intern.appman.sirichai.appmanintern.recyclerview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import intern.appman.sirichai.appmanintern.R;
import intern.appman.sirichai.appmanintern.pojo.AppmanInternData;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private AppmanInternData appmanInternData;
    private Context context;

    public RecyclerViewAdapter(AppmanInternData appmanInternData, Context context) {
        this.appmanInternData = appmanInternData;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        String doctype = appmanInternData.getData().get(position).getDocType();
        holder.docTypeTv.setText(doctype);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (!isLongClick) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                    alertBuilder.setMessage(appmanInternData.getData().get(position).getDescription().getTh() + " / " +
                            appmanInternData.getData().get(position).getDescription().getEn())
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            }).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return appmanInternData.getData().size();
    }
}
