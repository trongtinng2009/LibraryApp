package com.example.libraryapp.Utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.libraryapp.MainActivity;
import com.example.libraryapp.R;
import com.google.firebase.Timestamp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {
<<<<<<< HEAD
    public static String getRandomId(String prefix,int bound)
    {
        Random random = new Random();
        int id = random.nextInt(bound);
        String randomid = prefix + id;
        return  randomid + 1;
=======
    public static String getRandomId(String prefix,int bound) {
        Random random = new Random();
        int id = random.nextInt(bound);
        String randomid = prefix + id;
        return randomid + 1;
>>>>>>> 086ec25e4aa15a8a95c5c7ed59b52d5de88700d2
    }
    public static Timestamp textToTimestamp(int day,int month,int year)
    {
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            date = dateFormat.parse(day + "/" + month + "/" + year);
        }
        catch (Exception e)
        {

        }
        return new Timestamp(date);
    }
    public static String dateToString(Date date)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(date);
    }
    public static Dialog getPopup(Context context,int layout)
    {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(layout);
        Window window = dialog.getWindow();
        if(window == null)
        {
            return null;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowattributes = window.getAttributes();
        windowattributes.gravity = Gravity.CENTER;
        window.setAttributes(windowattributes);
        dialog.setCancelable(false);

        return dialog;
    }
}
