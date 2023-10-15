package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.libraryapp.Fragment.GuestHomeFragment;
import com.example.libraryapp.Fragment.GuestProfileFragment;
import com.example.libraryapp.Model.User;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    public static FirebaseFirestore db;
    public static User user;
    private GuestHomeFragment guestHomeFragment;
    private GuestProfileFragment guestProfileFragment;
    enum SelectedBtn
    {
        HOME(1),LIBCARD(2),NOF(3),PROFILE(4);
        private int value;
        private SelectedBtn(int value)
        {
            this.value = value;
        }
    }
    private int selectedbtn = SelectedBtn.HOME.value;
    private LinearLayout homebtn,libcardbtn,nofbtn,profilebtn;

    private ImageView homeimg,libcardimg,nofimg,profileimg;

    private TextView hometxt,libcardtxt,noftxt,profiletxt;

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        initView();
        handleSelected();
        setFragment(new GuestHomeFragment());
    }

    @Override
    protected void onStart() {
        super.onStart();
        db = FirebaseFirestore.getInstance();
        guestHomeFragment = new GuestHomeFragment();
        guestProfileFragment = new GuestProfileFragment();
    }

    private void initView()
    {
        homebtn = findViewById(R.id.mainact_linearlayouthome);
        libcardbtn = findViewById(R.id.mainact_linearlayoutlibcard);
        nofbtn = findViewById(R.id.mainact_linearlayoutnof);
        profilebtn = findViewById(R.id.mainact_linearlayoutprofile);

        homeimg = findViewById(R.id.mainact_imghome);
        libcardimg = findViewById(R.id.mainact_imglibcard);
        nofimg = findViewById(R.id.mainact_imgnof);
        profileimg = findViewById(R.id.mainact_imgprofile);

        hometxt = findViewById(R.id.mainact_texthome);
        libcardtxt = findViewById(R.id.mainact_textlibcard);
        noftxt = findViewById(R.id.mainact_textnof);
        profiletxt = findViewById(R.id.mainact_textprofile);
    }
    private void setFragment(Fragment fragment)
    {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_left);
        transaction.replace(R.id.mainact_fragmentcontainer,fragment);
        transaction.commit();
    }
    private void handleSelected()
    {
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedbtn != SelectedBtn.HOME.value)
                {
                    setFragment(guestHomeFragment);

                    libcardtxt.setVisibility(View.GONE);
                    libcardimg.setImageResource(R.drawable.local_library);
                    libcardbtn.setBackgroundColor(getResources().getColor(R.color.transparent));

                    noftxt.setVisibility(View.GONE);
                    nofimg.setImageResource(R.drawable.notifications);
                    nofbtn.setBackgroundColor(getResources().getColor(R.color.transparent));

                    profiletxt.setVisibility(View.GONE);
                    profileimg.setImageResource(R.drawable.person);
                    profilebtn.setBackgroundColor(getResources().getColor(R.color.transparent));

                    hometxt.setVisibility(View.VISIBLE);
                    homeimg.setImageResource(R.drawable.home_selected);
                    homebtn.setBackgroundResource(R.drawable.round_home);
                    selectedbtn = SelectedBtn.HOME.value;

                    ScaleAnimation scaleAnimation = new ScaleAnimation(
                            0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,
                            0.0f,Animation.RELATIVE_TO_SELF,0.0f
                    );
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    homebtn.setAnimation(scaleAnimation);


                }
            }
        });
        libcardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedbtn != SelectedBtn.LIBCARD.value)
                {
                    hometxt.setVisibility(View.GONE);
                    homeimg.setImageResource(R.drawable.home);
                    homebtn.setBackgroundColor(getResources().getColor(R.color.transparent));

                    noftxt.setVisibility(View.GONE);
                    nofimg.setImageResource(R.drawable.notifications);
                    nofbtn.setBackgroundColor(getResources().getColor(R.color.transparent));

                    profiletxt.setVisibility(View.GONE);
                    profileimg.setImageResource(R.drawable.person);
                    profilebtn.setBackgroundColor(getResources().getColor(R.color.transparent));

                    libcardtxt.setVisibility(View.VISIBLE);
                    libcardimg.setImageResource(R.drawable.local_library_selected);
                    libcardbtn.setBackgroundResource(R.drawable.round_locallib);
                    selectedbtn = SelectedBtn.LIBCARD.value;

                    ScaleAnimation scaleAnimation = new ScaleAnimation(
                            0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,
                            0.0f,Animation.RELATIVE_TO_SELF,0.0f
                    );
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    libcardbtn.setAnimation(scaleAnimation);
                }
            }
        });
        nofbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedbtn != SelectedBtn.NOF.value)
                {
                    hometxt.setVisibility(View.GONE);
                    homeimg.setImageResource(R.drawable.home);
                    homebtn.setBackgroundColor(getResources().getColor(R.color.transparent));

                    libcardtxt.setVisibility(View.GONE);
                    libcardimg.setImageResource(R.drawable.local_library);
                    libcardbtn.setBackgroundColor(getResources().getColor(R.color.transparent));

                    profiletxt.setVisibility(View.GONE);
                    profileimg.setImageResource(R.drawable.person);
                    profilebtn.setBackgroundColor(getResources().getColor(R.color.transparent));

                    noftxt.setVisibility(View.VISIBLE);
                    nofimg.setImageResource(R.drawable.notifications_selected);
                    nofbtn.setBackgroundResource(R.drawable.round_nof);
                    selectedbtn = SelectedBtn.NOF.value;

                    ScaleAnimation scaleAnimation = new ScaleAnimation(
                            0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,
                            0.0f,Animation.RELATIVE_TO_SELF,0.0f
                    );
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    nofbtn.setAnimation(scaleAnimation);
                }
            }
        });
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedbtn != SelectedBtn.PROFILE.value)
                {

                    setFragment(guestProfileFragment);

                    hometxt.setVisibility(View.GONE);
                    homeimg.setImageResource(R.drawable.home);
                    homebtn.setBackgroundColor(getResources().getColor(R.color.transparent));
                    
                    libcardtxt.setVisibility(View.GONE);
                    libcardimg.setImageResource(R.drawable.local_library);
                    libcardbtn.setBackgroundColor(getResources().getColor(R.color.transparent));

                    noftxt.setVisibility(View.GONE);
                    nofimg.setImageResource(R.drawable.notifications);
                    nofbtn.setBackgroundColor(getResources().getColor(R.color.transparent));

                    profiletxt.setVisibility(View.VISIBLE);
                    profileimg.setImageResource(R.drawable.person_selected);
                    profilebtn.setBackgroundResource(R.drawable.round_profile);
                    selectedbtn = SelectedBtn.PROFILE.value;

                    ScaleAnimation scaleAnimation = new ScaleAnimation(
                            0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,
                            0.0f,Animation.RELATIVE_TO_SELF,0.0f
                    );
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    profilebtn.setAnimation(scaleAnimation);


                }
            }
        });
    }
}