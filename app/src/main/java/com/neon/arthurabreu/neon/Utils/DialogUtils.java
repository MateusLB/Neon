package com.neon.arthurabreu.neon.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.neon.arthurabreu.neon.R;
import com.pnikosis.materialishprogress.ProgressWheel;
import static com.neon.arthurabreu.neon.Utils.LifecycleUtils.isRunning;

/**
 * Created by af2g on 12/12/2017.
 */

public class DialogUtils {

    public static Dialog showProgressDialog(Context context){

        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_loading);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ProgressWheel wheel = new ProgressWheel(context);
        wheel.setBarColor(Color.WHITE);
        wheel.spin();

        dialog.setCancelable(true);
        try{
            if(isRunning(context)){
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                dialog.show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return dialog;
    }

    public static void messageDialog(Activity activity, String text, String title){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_message);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        LinearLayout layotTitle = (LinearLayout) dialog.findViewById(R.id.title_layout);
        TextView textView = (TextView) dialog.findViewById(R.id.content);
        TextView titleView = (TextView) dialog.findViewById(R.id.title);

        if(title==null || title.isEmpty()){
            layotTitle.setVisibility(View.GONE);
        }else {
            layotTitle.setVisibility(View.VISIBLE);
            titleView.setText(title);
        }

        textView.setText(text);

        Button okBtn = (Button) dialog.findViewById(R.id.ok);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
