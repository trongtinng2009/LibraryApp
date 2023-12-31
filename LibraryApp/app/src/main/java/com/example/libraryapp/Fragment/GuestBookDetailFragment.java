package com.example.libraryapp.Fragment;

import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.libraryapp.Model.BookOffline;
import com.example.libraryapp.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GuestBookDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuestBookDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Bundle b;
    private ImageView bgimg,bookimg;
    private TextView txtquantity,txtsummary,txttitle;

    public GuestBookDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GuestBookDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GuestBookDetailFragment newInstance(String param1, String param2) {
        GuestBookDetailFragment fragment = new GuestBookDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guest_book_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view)
    {
        b = this.getArguments();
        BookOffline bookOffline = (BookOffline)b.getSerializable("book");

        bgimg = view.findViewById(R.id.fragguestbookdetail_bgimg);
        bookimg = view.findViewById(R.id.fragguestbookdetail_bookimg);
        txtquantity = view.findViewById(R.id.fragguestbookdetail_remainquantity);
        txtsummary = view.findViewById(R.id.fragguestbookdetail_summarytxt);
        txttitle = view.findViewById(R.id.fragguestbookdetail_booktitle);

        if(bookOffline.getImg_url() != null)
        {
            Picasso.get().load(bookOffline.getImg_url()).into(bgimg);
            Picasso.get().load(bookOffline.getImg_url()).into(bookimg);
        }
        txttitle.setText(bookOffline.getName());
        txtsummary.setText(bookOffline.getSummary());
        txtquantity.setText(Integer.toString(bookOffline.getRemain_quantity()));
    }
}