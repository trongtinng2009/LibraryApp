package com.example.libraryapp.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libraryapp.Fragment.GuestBookDetailFragment;
import com.example.libraryapp.MainActivity;
import com.example.libraryapp.Model.BookOffline;
import com.example.libraryapp.R;
import com.squareup.picasso.Picasso;

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
        if(book.getImg_url() != null) {
            Picasso.get().load(book.getImg_url()).into(bookViewHolder.bookimg);
        }
        bookViewHolder.booktitle.setText(book.getName());
        bookViewHolder.bookdetailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putSerializable("book",book);
                GuestBookDetailFragment guestBookDetailFragment = new GuestBookDetailFragment();
                FragmentTransaction trans = MainActivity.fragmentManager.beginTransaction();
                guestBookDetailFragment.setArguments(b);
                trans.replace(R.id.mainact_fragmentcontainer,guestBookDetailFragment);
                trans.addToBackStack(null);
                trans.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookOfflines.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder
    {
        ImageButton bookdetailbtn;
        ImageView bookimg;
        TextView booktitle,bookrating;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookimg = itemView.findViewById(R.id.book_item_bookimg);
            bookrating = itemView.findViewById(R.id.book_item_bookrating);
            booktitle = itemView.findViewById(R.id.book_item_booktitle);
            bookdetailbtn = itemView.findViewById(R.id.book_item_detailbtn);
            bookdetailbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.mainact_fragmentcontainer,new GuestBookDetailFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        }
    }
}
