package com.kelurahankepuharjo.atry;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<Model> list ;
    private ItemClickListener clickListener;

    public RecyclerViewAdapter(List<Model> list, ItemClickListener clickListener){
        this.list = list;
        this.clickListener  = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder,int position) {
        Model model = list.get(position);

        holder.title.setText(model.getTitle());
        holder.subtitle.setText(model.getSubtitle());
        holder.imageView.setImageResource(model.getImagetitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        ImageView imageView;
        TextView title, subtitle;
        public MyViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.title_image);
            title = view.findViewById(R.id.title);
            subtitle = view.findViewById(R.id.subtitle);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.onItemClick(list.get(getAdapterPosition()));
            }
        }
    }
    public interface ItemClickListener {
        public void onItemClick(Model model);
    }
}
