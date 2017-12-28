package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    public static ProgressBar prog_bar;
    public static TextView txt_async;
    Button tell_btn;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        if()
        View root = inflater.inflate(R.layout.fragment_main, container, false);


        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        prog_bar = (ProgressBar) root.findViewById(R.id.prog_bar);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        txt_async = (TextView) root.findViewById(R.id.txt_async);
        tell_btn = (Button) root.findViewById(R.id.tell_btn);
        tell_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });

        return root;
    }
    @Override
    public void onStart() {
        super.onStart();
        txt_async.setVisibility(View.GONE);
    }

    public void tellJoke() {

        prog_bar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask().execute(new Pair<Context, String>(getActivity(), "Manfred"));
//        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
    }
}
