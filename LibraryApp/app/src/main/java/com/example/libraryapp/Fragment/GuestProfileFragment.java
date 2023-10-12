package com.example.libraryapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.libraryapp.Activity.AdminActivity;
import com.example.libraryapp.MainActivity;
import com.example.libraryapp.Model.User;
import com.example.libraryapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GuestProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuestProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private boolean login = false;
    private TextView usernametxt;
    private ImageView useravatar;
    private EditText loginnameedt,loginpassedt;
    private Button loginbtn;
    private RelativeLayout layoutnoaccount;
    private LinearLayout layouthaveaccount;
    private CollectionReference usercollection = MainActivity.db.collection("User");
    public GuestProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GuestProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GuestProfileFragment newInstance(String param1, String param2) {
        GuestProfileFragment fragment = new GuestProfileFragment();
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
        return inflater.inflate(R.layout.fragment_guest_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        if(!login)
         login();
    }
    private void initView(View view)
    {
        useravatar = view.findViewById(R.id.fragguestprofile_avt);
        usernametxt = view.findViewById(R.id.fragguestprofile_username);
        loginbtn = view.findViewById(R.id.fragguesthome_loginbtn);
        loginnameedt = view.findViewById(R.id.fragguestprofile_loginname);
        loginpassedt = view.findViewById(R.id.fragguestprofile_loginpass);
        layouthaveaccount = view.findViewById(R.id.fragguesthome_haveaccountlayout);
        layoutnoaccount = view.findViewById(R.id.fragguesthome_nothaveaccountlayout);
        if(login)
        {
            useravatar.setImageResource(getResources().getIdentifier(MainActivity.user.getAvatar(),
                    "drawable",getContext().getPackageName()));
            usernametxt.setVisibility(View.VISIBLE);
            usernametxt.setText("Hello " + MainActivity.user.getUsername());
            layouthaveaccount.setVisibility(View.VISIBLE);
            layoutnoaccount.setVisibility(View.GONE);
        }
    }
    private void login()
    {
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginname = loginnameedt.getText().toString();
                String loginpass = loginpassedt.getText().toString();
              Query query = usercollection.whereEqualTo("loginname",loginname)
                      .whereEqualTo("password",loginpass);
              query.get().addOnCompleteListener(getActivity(), new OnCompleteListener<QuerySnapshot>() {
                  @Override
                  public void onComplete(@NonNull Task<QuerySnapshot> task) {
                      if(task.isSuccessful())
                      {
                          QuerySnapshot documentSnapshot = task.getResult();
                          Log.i("size",Integer.toString(documentSnapshot.getDocuments().size()));
                          if(!documentSnapshot.isEmpty())
                          {
                              MainActivity.user = documentSnapshot.getDocuments().get(0).toObject(User.class);
                              if(!MainActivity.user.getRole().equals("Guest"))
                              {
                                  getActivity().finish();
                                  Intent i = new Intent(getContext(), AdminActivity.class);
                                  getContext().startActivity(i);
                              }
                              else
                              {
                                  login = true;
                                  useravatar.setImageResource(getResources().getIdentifier(MainActivity.user.getAvatar(),
                                          "drawable",getContext().getPackageName()));
                                  usernametxt.setVisibility(View.VISIBLE);
                                  usernametxt.setText("Hello " + MainActivity.user.getUsername());
                                  layouthaveaccount.setVisibility(View.VISIBLE);
                                  layoutnoaccount.setVisibility(View.GONE);
                                  ScaleAnimation scaleAnimation = new ScaleAnimation(
                                          0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,
                                          0.0f,Animation.RELATIVE_TO_SELF,0.0f
                                  );
                                  scaleAnimation.setDuration(200);
                                  scaleAnimation.setFillAfter(true);
                                  layouthaveaccount.setAnimation(scaleAnimation);
                              }
                          }
                      }
                      else
                      {
                          Log.i("error","error fetch data");
                      }
                  }
              });
            }
        });
    }
}