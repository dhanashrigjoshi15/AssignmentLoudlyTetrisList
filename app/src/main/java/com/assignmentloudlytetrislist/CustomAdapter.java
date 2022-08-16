//Adapter to set data of recyclerview as a list

package com.assignmentloudlytetrislist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.assignmentloudlytetrislist.data.RepositoryData;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private ArrayList<RepositoryData> repositoryDataList;
    private Context context;

    //constructor
    public CustomAdapter(Context context, ArrayList<RepositoryData> repositoryDataList ){
        this.context = context;
        this.repositoryDataList = repositoryDataList;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_items, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        long id = repositoryDataList.get(position).getId();
        holder.textViewName.setText(repositoryDataList.get(position).getRepoName());
        holder.textViewLoginName.setText(repositoryDataList.get(position).getOwner().getLoginName());
        holder.textViewSize.setText(repositoryDataList.get(position).getRepoSize()+"");
        //For has_wiki as true, display item with Gray background
        if(repositoryDataList.get(position).isHasWiki())
            holder.cardViewItem.setCardBackgroundColor(Color.LTGRAY);
        else
            holder.cardViewItem.setCardBackgroundColor(Color.WHITE);
    }

    @Override
    public int getItemCount() {
        return repositoryDataList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewName;
        private TextView textViewLoginName;
        private TextView textViewSize;
        private CardView cardViewItem;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewLoginName = itemView.findViewById(R.id.textViewLoginName);
            textViewSize = itemView.findViewById(R.id.textViewSize);
            cardViewItem = itemView.findViewById(R.id.main_container);
        }
    }
}
