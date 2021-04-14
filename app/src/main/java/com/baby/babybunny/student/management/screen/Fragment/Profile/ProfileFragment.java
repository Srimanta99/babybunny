package com.baby.babybunny.student.management.screen.Fragment.Profile;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.utils.ApplicationConstant;
import com.baby.babybunny.student.management.utils.FileUtils;
import com.baby.babybunny.student.management.utils.SessionManager;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    ProfileViewBind profileViewBind;
    ProfileOnClick profileOnClick;
  public String id,otp,name,email,phno,image;

    File file;

    ProgressDialog pd;


    private static final String IMAGE_DIRECTORY = "/demonuts";
    private final int GALLERY = 1, CAMERA = 2;
    ProgressDialog mProgressDialog;

    // File f=null;
    private int serverResponseCode = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        profileViewBind= new ProfileViewBind(this,view);
        profileOnClick=new ProfileOnClick(this,profileViewBind);

       id= SessionManager.getidvalue();
       otp=SessionManager.getotp();

      name=SessionManager.getnamevalue();
      email=SessionManager.getemailidvalue();
      phno=SessionManager.getphnovalue();
        image=SessionManager.getimagevalue();

      profileViewBind.etnameid.setText(name);
      profileViewBind.et_email_id.setText(email);
      profileViewBind.et_ph_no_id.setText(phno);


       /* Glide.with(getContext())
                .load(image)
                .into( profileViewBind.imageiconid);*/

        requestMultiplePermissions();




       super.onViewCreated(view, savedInstanceState);
    }


    private void  requestMultiplePermissions(){
        Dexter.withActivity(getActivity())
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            Toast.makeText(getActivity(), "All permissions are granted by user !!", Toast.LENGTH_SHORT).show();
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            //openSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<com.karumi.dexter.listener.PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }


                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getActivity(), "Some Error! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }

    public void OwnerDetailsloaddata(final String id) {
        pd = new ProgressDialog(getActivity());
        pd.setMessage("loading");
        pd.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.studentOTP_Passwordurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();

                try {
                    JSONArray jsonArray=new JSONArray(response);
                    JSONObject jsonObject=jsonArray.getJSONObject(0);
                    JSONObject jsonObject1=jsonObject.getJSONObject("status");

                    profileViewBind.etnameid .setText(jsonObject1.getString("name"));
                    profileViewBind.et_ph_no_id .setText(jsonObject1.getString("phone"));
                    profileViewBind.et_email_id .setText(jsonObject1.getString("email"));

                   /* String photo= ApplicationConstant.baseurl+"uploads/restaurant/"+jsonObject1.getString("photo");

                    Glide.with(getContext())
                            .load(photo)
                            .into( profileViewBind.imageiconid);*/

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("id",id);
                Log.d("hash", "getParams: "+hashMap);
                return hashMap;
            }
        };
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }

    public void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(getContext());
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode==getActivity().RESULT_OK && data!=null){

            // uniform resorce identifire

            Uri dataa = data.getData();

            try {
                String fullPath = FileUtils.getPath(getContext(), data.getData());
                file = new File(fullPath);
            } catch (Exception exception) {
                file = null;
                Toast.makeText(getActivity(),"This file is not supported because it's a temp file " +
                        "please choose from " +
                        "different folder",Toast.LENGTH_LONG);


                return;
            }


            switch (requestCode){

                case GALLERY: {
                    Log.d("path", dataa.toString());

                    profileViewBind.imageiconid.setImageURI(dataa);

                }
                    break;

                case CAMERA:
                    Log.d("path", dataa.toString());
                    profileViewBind.imageiconid.setImageURI(dataa);
                    break;


                default:
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}