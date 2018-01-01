package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import com.gemidroid.android_lib.AndroidLibrary;
import com.gemidroid.java_lib.JavaClass;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import java.io.IOException;

import static com.udacity.gradle.builditbigger.MainActivityFragment.prog_bar;
import static com.udacity.gradle.builditbigger.MainActivityFragment.txt_async;

/**
 * Created by root on 17/12/17.
 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:1234/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        Log.v("doInBackground","doInBackground ---->  " +name );
        try {


            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.v("doInBackground","onPostExecute ---->  " +result );
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
/*
        JavaClass javaJokesList = new JavaClass();
//        javaJokesList.prepareJokes();
//        double x1 = Math.random();
        int x = (int) (Math.random() * 9);
        String s = javaJokesList.GetAllJokes().get(x);
        prog_bar.setVisibility(View.GONE);
        txt_async.setVisibility(View.VISIBLE);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Intent intent = new Intent(context, AndroidLibrary.class)
                .putExtra("jokes", result);

        context.startActivity(intent);
    }
}