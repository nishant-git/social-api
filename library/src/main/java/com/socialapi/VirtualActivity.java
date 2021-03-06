package com.socialapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.socialapi.model.AbstractSocialService;

/**
 * Created by Nishant on 23/10/15.
 */
public class VirtualActivity extends Activity {


    private AbstractSocialService serviceObject;

    @Override
    protected void onStart() {
        super.onStart();
        if (serviceObject != null)
            serviceObject.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceObject = (AbstractSocialService) getIntent().getExtras().get("service_object");
        if (serviceObject != null) {
            serviceObject.initLogin(this);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (serviceObject != null)
            serviceObject.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (serviceObject != null)
            serviceObject.onStop();
    }
}
