package com.example.libraryapp.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libraryapp.Activity.LibrarianActivity;
import com.example.libraryapp.Fragment.LibrarianCardDetailConfirmFragment;
import com.example.libraryapp.Fragment.LibrarianConfirmCardFragment;
import com.example.libraryapp.Model.Libcard;
import com.example.libraryapp.R;
import com.example.libraryapp.Utils.Utils;

import java.util.ArrayList;
import java.util.Date;

public class LibcardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    int layoutid;
    ArrayList<Libcard> libcards;

    public LibcardAdapter(Context context, int layoutid, ArrayList<Libcard> libcards) {
        this.context = context;
        this.layoutid = layoutid;
        this.libcards = libcards;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.libcard_request_item,parent,false);
        return new LibcardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LibcardHolder libcardHolder = (LibcardHolder) holder;
        Libcard libcard = libcards.get(position);
        int id = context.getResources().getIdentifier(libcard.getImage_url(),"drawable",context.getPackageName());
        libcardHolder.libcardimg.setImageResource(id);
        Date request_date = libcard.getRequest_date().toDate();
        libcardHolder.txtdate.setText(Utils.dateToString(request_date));
        libcardHolder.txtname.setText(libcard.getFirstname() + " " + libcard.getLastname());
        libcardHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LibrarianCardDetailConfirmFragment librarianConfirmCardFragment = new LibrarianCardDetailConfirmFragment();
                Bundle b= new Bundle();
                b.putSerializable("libcard",libcard);
                librarianConfirmCardFragment.setArguments(b);
                FragmentTransaction transaction = LibrarianActivity.fragmentManager2.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_left);
                transaction.replace(R.id.libact_fragmentcontainer,librarianConfirmCardFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return libcards.size();
    }

    public class LibcardHolder extends RecyclerView.ViewHolder
    {
        LinearLayout layout;
        ImageView libcardimg;
        TextView txtname,txtdate;
        Button btnacc,btnig;
        public LibcardHolder(@NonNull View itemView) {
            super(itemView);
            libcardimg = itemView.findViewById(R.id.libcard_request_libcardimg);
            txtname = itemView.findViewById(R.id.libcard_request_libcardname);
            txtdate = itemView.findViewById(R.id.libcard_request_libcarddate);
            btnacc = itemView.findViewById(R.id.libcard_request_libcardaccbtn);
            btnig = itemView.findViewById(R.id.libcard_request_libcardigbtn);
            layout = itemView.findViewById(R.id.libcard_request_layout);
        }
    }
}
