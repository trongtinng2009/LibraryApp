package com.example.libraryapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libraryapp.Model.BookOffline;
import com.example.libraryapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<BookOffline> bookOfflines;
    private Context context;
    private int layoutid;

    public BookAdapter(ArrayList<BookOffline> bookOfflines, Context context, int layoutid) {
        this.bookOfflines = bookOfflines;
        this.context = context;
        this.layoutid = layoutid;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(layoutid,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BookViewHolder bookViewHolder = (BookViewHolder) holder;
        BookOffline book = bookOfflines.get(position);
        int idimg = context.getResources().getIdentifier(book.getImg(),"drawable",context.getPackageName());

        bookViewHolder.booktitle.setText(book.getTitle());
        bookViewHolder.bookimg.setImageResource(idimg);

    }

    @Override
    public int getItemCount() {
        return bookOfflines.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder
    {
        ImageView bookimg;
        TextView booktitle,bookrating;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookimg = itemView.findViewById(R.id.book_item_bookimg);
            bookrating = itemView.findViewById(R.id.book_item_bookrating);
            booktitle = itemView.findViewById(R.id.book_item_booktitle);
        }
    }
}
