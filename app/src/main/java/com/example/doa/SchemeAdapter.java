package com.example.doa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SchemeAdapter extends RecyclerView.Adapter<SchemeAdapter.SchemeViewHolder> {

    private final List<Scheme> schemeList;
    private final Context context;

    public SchemeAdapter(Context context, List<Scheme> schemeList) {
        this.context = context;
        this.schemeList = schemeList;
    }

    @NonNull
    @Override
    public SchemeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scheme_item, parent, false);
        return new SchemeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SchemeViewHolder holder, int position) {
        Scheme scheme = schemeList.get(position);
        holder.schemeName.setText(scheme.getName());
        holder.schemeThumbnail.setImageResource(scheme.getThumbnail());
        holder.gifPlaceholder.setImageResource(scheme.getGifPlaceholder());

        // Handle click to open SchemeDetailActivity
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, SchemeDetailActivity.class);
            intent.putExtra("scheme_name", scheme.getName());
            intent.putExtra("scheme_video", scheme.getVideoUrl());  // Pass the video URL
            intent.putExtra("scheme_content", scheme.getContent());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return schemeList.size();
    }

    public static class SchemeViewHolder extends RecyclerView.ViewHolder {
        TextView schemeName;
        ImageView schemeThumbnail, gifPlaceholder;

        public SchemeViewHolder(@NonNull View itemView) {
            super(itemView);
            schemeName = itemView.findViewById(R.id.scheme_name);
            schemeThumbnail = itemView.findViewById(R.id.scheme_thumbnail);
            gifPlaceholder = itemView.findViewById(R.id.gif_placeholder);
        }
    }
}
