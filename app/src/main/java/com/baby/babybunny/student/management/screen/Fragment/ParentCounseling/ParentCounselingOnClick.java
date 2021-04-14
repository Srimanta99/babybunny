package com.baby.babybunny.student.management.screen.Fragment.ParentCounseling;

import android.content.Intent;
import android.view.View;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.VideoandAudioClipActivity.VideoandAudioClipActivity;
import com.baby.babybunny.student.management.screen.BlogsActivity.BlogsActivity;
import com.baby.babybunny.student.management.screen.DoAndDontsActivity.DoAndDoNotsActivity;
import com.baby.babybunny.student.management.screen.PdfActivity.PdfActivity;


public class ParentCounselingOnClick implements View.OnClickListener{
    ParentCounselingFragment parentCounselingFragment;
    ParentCounselingViewBind parentCounselingViewBind;

    public ParentCounselingOnClick(ParentCounselingFragment parentCounselingFragment, ParentCounselingViewBind parentCounselingViewBind) {
        this.parentCounselingFragment=parentCounselingFragment;
        this.parentCounselingViewBind=parentCounselingViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        parentCounselingViewBind.pdfid.setOnClickListener(this);
        parentCounselingViewBind.blogsid.setOnClickListener(this);
        parentCounselingViewBind.videoclipsid.setOnClickListener(this);
        parentCounselingViewBind.lvDoandDontsid.setOnClickListener(this);

    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pdfid:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(parentCounselingFragment.getActivity(), PdfActivity.class);
                parentCounselingFragment.getActivity().startActivity(intent);


            }
            break;

            case R.id.blogsid:{
                Intent intent=new Intent(parentCounselingFragment.getActivity(), BlogsActivity.class);
                parentCounselingFragment.getActivity().startActivity(intent);
            }
           break;

            case R.id.videoclipsid:{
                Intent intent=new Intent(parentCounselingFragment.getActivity(), VideoandAudioClipActivity.class);
                parentCounselingFragment.getActivity().startActivity(intent);
            }
            break;

            case R.id.lvDoandDontsid:{
                Intent intent=new Intent(parentCounselingFragment.getActivity(), DoAndDoNotsActivity.class);
                parentCounselingFragment.getActivity().startActivity(intent);
            }

        }
    }
}
