package com.baby.bunny.student.management.screen.CenterAddStudentFeesActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CenterAddStudentFeesViewBind extends DeviceResolution {
    CenterAddStudentFeesActivity centerAddStudentFeesActivity;
    View view;
    Spinner select_class_spinnerid,select_type_spinnerid;
    RecyclerView select_student_rv;
    ImageView back_icon;
    TextView tvsubmmitid;
    EditText Amountet;
    LinearLayout progresslvid;

    public CenterAddStudentFeesViewBind(CenterAddStudentFeesActivity centerAddStudentFeesActivity, View view) {
        super(centerAddStudentFeesActivity);
        this.centerAddStudentFeesActivity=centerAddStudentFeesActivity;
        this.view=view;
        initviewBind();
        setCustomTypeface();
    }

    // for adding custom typeface
    private void setCustomTypeface() {
        // studentlvid.setTypeface(getbebas(mainActivity));
//        btn_hello_wrold.setTypeface(getbebas(mainActivity));
    }

    // for findview
    private void initviewBind() {
        select_class_spinnerid=view.findViewById(R.id.select_class_spinnerid);
        select_type_spinnerid=view.findViewById(R.id.select_type_spinnerid);
        select_student_rv=view.findViewById(R.id.select_student_rv);
        back_icon=view.findViewById(R.id.back_icon);
        tvsubmmitid=view.findViewById(R.id.tvsubmmitid);
        Amountet=view.findViewById(R.id.Amountet);
        progresslvid=view.findViewById(R.id.progresslvid);
        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}
