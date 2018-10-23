package com.example.cell1;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.app.job.JobWorkItem;
import android.os.Build;

import java.util.List;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MjobSchedular extends JobService {
    // MainActivity o=new MainActivity();

    private static final boolean TODO = true;
    private MjobExecuter mjobExecuter;
    //private MainActivity mainActivity;
    String ss;


//    MainActivity mainActivity=new MainActivity();

    @Override
    public boolean onStartJob(final JobParameters params) {

        //  mainActivity=(MainActivity)con



        //   mainActivity.configure_button();

        mjobExecuter = new MjobExecuter() {

            @Override
            protected void onPostExecute(String s) {

                ToDoActivity.getInstance().configure_button();


                //   Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                //Toast.makeText(MjobSchedular.this,"\n " + location.getLongitude() + " " + location.getLatitude(),Toast.LENGTH_LONG).show();
                jobFinished(params, false);
            }
        };

        mjobExecuter.execute();

        return true;
    }



    @Override
    public boolean onStopJob(JobParameters params) {
        mjobExecuter.cancel(true);
        return true;
    }
}

