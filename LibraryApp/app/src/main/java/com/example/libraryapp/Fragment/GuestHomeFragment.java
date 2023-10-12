package com.example.libraryapp.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.libraryapp.Adapter.BookAdapter;
import com.example.libraryapp.Adapter.CategoryAdapter;
import com.example.libraryapp.Adapter.EventAdapter;
import com.example.libraryapp.Model.BookOffline;
import com.example.libraryapp.Model.Category;
import com.example.libraryapp.Model.Events;
import com.example.libraryapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GuestHomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuestHomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ViewPager2 viewPager2;
    private List<Events> events;
    private ArrayList<Category> categories;
    private ArrayList<BookOffline> bookOfflines;
    private RecyclerView rcvhotcate,rcvnewbook;
    private Handler handler = new Handler();

    public GuestHomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GuestHomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GuestHomeFragment newInstance(String param1, String param2) {
        GuestHomeFragment fragment = new GuestHomeFragment();
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
        return inflater.inflate(R.layout.fragment_guest_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }
    private void initView(View view)
    {
        viewPager2 = view.findViewById(R.id.fragguesthome_eventsslider);
        rcvhotcate = view.findViewById(R.id.fragguesthome_rcvhotcate);
        rcvnewbook = view.findViewById(R.id.fragguesthome_rcvnewbook);
        events = new ArrayList<Events>();

        events.add(new Events(R.drawable.sera1));
        events.add(new Events(R.drawable.sera2));
        events.add(new Events(R.drawable.sera3));
        events.add(new Events(R.drawable.sera4));

        bookOfflines = new ArrayList<BookOffline>();
        bookOfflines.add(new BookOffline("banhoctoilalinhdanhthue","Bạn Học Tôi Là Lính Đánh Thuê",0));
        bookOfflines.add(new BookOffline("aliceinborderland","Alice In Borderland",0));
        bookOfflines.add(new BookOffline("signal100","Signal 100",0));
        bookOfflines.add(new BookOffline("trothanhcuutinhcunhanvatchinh","Trở Thành Cứu Tinh Của Nhân Vật Chính",0));
        bookOfflines.add(new BookOffline("nguoichoimoicaptoida","Người Chơi Mới Cấp Tối Đa",0));
        bookOfflines.add(new BookOffline("dangnhapmurim","Đăng Nhập Murim",0));

        rcvnewbook.setAdapter(new BookAdapter(bookOfflines,getContext(),R.layout.book_item));
        rcvnewbook.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        categories = new ArrayList<Category>();
        categories.add(new Category("Science Book","sciencebook"));
        categories.add(new Category("Education Book","edubook"));
        categories.add(new Category("Manga Book","mangabook"));
        categories.add(new Category("Mental Book","mentalbook"));
        categories.add(new Category("Economics Book","economicbook"));
        categories.add(new Category("Fiction Book","fictionbook"));

        rcvhotcate.setAdapter(new CategoryAdapter(getContext(),categories,R.layout.cate_item));
        rcvhotcate.setLayoutManager(new GridLayoutManager(getContext(),3));

        viewPager2.setAdapter(new EventAdapter(events,R.layout.slide_events,getContext(),viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(4);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1- Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,2000);
            }
        });
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable,3000);
    }
}