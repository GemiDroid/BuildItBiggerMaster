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
    public static ProgressBar progress_bar;

    public static TextView text_after_async;
    Button tell_jo_btn;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        if()
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        text_after_async = (TextView) root.findViewById(R.id.text_after_async);

        progress_bar = (ProgressBar) root.findViewById(R.id.progress_bar);
        tell_jo_btn = (Button) root.findViewById(R.id.tell_jo_btn);
        tell_jo_btn.setOnClickListener(new View.OnClickListener() {
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
        text_after_async.setVisibility(View.GONE);
    }

    public void tellJoke() {

        progress_bar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask().execute(new Pair<Context, String>(getActivity(), "Manfred"));
//        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
    }


}
