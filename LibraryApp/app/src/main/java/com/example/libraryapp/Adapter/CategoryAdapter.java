package com.example.libraryapp.Adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libraryapp.Model.Category;
import com.example.libraryapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<Category> categories;
    private int layoutid;

    public CategoryAdapter(Context context, ArrayList<Category> categories, int layoutid) {
        this.context = context;
        this.categories = categories;
        this.layoutid = layoutid;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(layoutid,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        int[] bgcolor = {R.color.pas_cream,R.color.pas_pinkpur,R.color.pas_orange
        ,R.color.pas_yellow,R.color.pas_pink,R.color.pas_green};
        int imgid = context.getResources().getIdentifier(categories.get(position).getImg(),"drawable",
                context.getPackageName());

        viewHolder.cate_img.setImageResource(imgid);
        viewHolder.cate_txt.setText(categories.get(position).getName());
        viewHolder.cate_bg.setBackgroundTintList(ContextCompat.getColorStateList(context,bgcolor[position]));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private FrameLayout cate_bg;
        private ImageView cate_img;
        private TextView cate_txt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cate_bg = itemView.findViewById(R.id.cate_item_bg);
            cate_img = itemView.findViewById(R.id.cate_item_img);
            cate_txt = itemView.findViewById(R.id.cate_item_txt);
        }
    }
}
