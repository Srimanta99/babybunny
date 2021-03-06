package com.baby.babybunny.student.management.screen.FragmentCenterManager.CenterManagerFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baby.babybunny.student.management.R;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class CerterManagerFragment extends Fragment {
    CerterManagerFragmentViewBind certerManagerFragmentViewBind;
    CerterManagerFragmentOnClick certerManagerFragmentOnClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_certer_manager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        certerManagerFragmentViewBind= new CerterManagerFragmentViewBind(this,view);
        certerManagerFragmentOnClick=new CerterManagerFragmentOnClick(this,certerManagerFragmentViewBind);
    

        super.onViewCreated(view, savedInstanceState);
    }
}