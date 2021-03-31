package com.example.task1.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.R;
import com.example.task1.View.Fragments.HomeFragment;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;

    public RecyclerAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Log.i("Setting", String.valueOf(position));
        GlideApp.with(context)
                .load(HomeFragment.imageUrls.get(position))
                .transition(withCrossFade())
                .error(R.drawable.imgnotfound)
                .into(holder.photoImageView);
    }

    @Override
    public int getItemCount() {
        return HomeFragment.imageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView photoImageView;

        public ViewHolder(View itemView){
            super(itemView);

            photoImageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
