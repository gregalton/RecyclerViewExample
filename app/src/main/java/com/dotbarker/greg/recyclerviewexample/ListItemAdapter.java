package com.dotbarker.greg.recyclerviewexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static com.dotbarker.greg.recyclerviewexample.R.layout.list_item;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public ListItemAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listView = LayoutInflater.from(parent.getContext())
                .inflate(list_item, parent, false);

        return new ViewHolder(listView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ListItem listItem = listItems.get(position);

        holder.listItemHeading.setText(listItem.getHeader());
        holder.listItemDescription.setText(listItem.getDescription());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView listItemHeading;
        public TextView listItemDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            listItemHeading = (TextView) itemView.findViewById(R.id.listItemHeading);
            listItemDescription = (TextView) itemView.findViewById(R.id.listItemDescription);

        }

    }
}
