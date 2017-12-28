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
import com.udacity.gradle.builditbigger.R;


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
        txt_async = root.findViewById(R.id.txt_async);

        prog_bar =  root.findViewById(R.id.prog_bar);
        tell_btn =  root.findViewById(R.id.tell_btn);
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
    }


}
