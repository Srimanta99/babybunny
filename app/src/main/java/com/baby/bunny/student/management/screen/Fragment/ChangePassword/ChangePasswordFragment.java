package com.baby.bunny.student.management.screen.Fragment.ChangePassword;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentZoneViewBind;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentsZoneOnclick;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class ChangePasswordFragment extends Fragment {
    ChangePasswordViewBind changePasswordViewBind;
    ChangePasswordOnClick changePasswordOnClick;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_change_password, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        changePasswordViewBind= new ChangePasswordViewBind(this,view);
        changePasswordOnClick=new ChangePasswordOnClick(this,changePasswordViewBind);




   /*     show_pass_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.show_pass_id){

                    if(evpasswordid.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                        show_pass_id.setImageResource(R.drawable.ic_baseline_visibility_off_24);

                        //Show Password
                        evpasswordid.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }
                    else{
                        ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_visibility_24);

                        //Hide Password
                        evpasswordid.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    }
                }
            }
        });*/

      /*  show_new_password_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.show_new_password_id){

                    if(et_show_new_password_id.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                        show_new_password_id.setImageResource(R.drawable.ic_baseline_visibility_off_24);

                        //Show Password
                        et_show_new_password_id.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }
                    else{
                        ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_visibility_24);

                        //Hide Password
                        et_show_new_password_id.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    }
                }

            }
        });*/

      /*  show_confirm_pass_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.show_confirm_pass_id){

                    if(et_show_confirm_pass_id.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                        show_confirm_pass_id.setImageResource(R.drawable.ic_baseline_visibility_off_24);

                        //Show Password
                        et_show_confirm_pass_id.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }
                    else{
                        ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_visibility_24);

                        //Hide Password
                        et_show_confirm_pass_id.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    }
                }
            }
        });*/




        super.onViewCreated(view, savedInstanceState);


    }
}