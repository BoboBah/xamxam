package com.example.bobo.xamxam;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.bobo.xamxam.adapters.MyAdapterChapitre;
import com.example.bobo.xamxam.beans.Chapitre;
import com.example.bobo.xamxam.beans.Module;
import com.example.bobo.xamxam.database.AppDatabase;

import java.util.List;

public class VideoActivity extends AppCompatActivity {

    private static final String VIDEO_SAMPLE =
            "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
    private int mCurrentPosition=0;

    public static final String PLAYBACK_TIME="play_time";

    private VideoView mVideoView;

    private AppDatabase db;

    private List<Chapitre> chapitres;

    private RecyclerView recyclerView;

    private ImageView imageView;

    private ListView listView;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        mVideoView = findViewById(R.id.videoview);


        if (savedInstanceState != null)
        {
            mCurrentPosition = savedInstanceState.getInt(PLAYBACK_TIME);

        }

        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(mVideoView);
        mVideoView.setMediaController(controller);

        db = AppDatabase.getInstance(this);


        Intent intent = getIntent();


        int idModule = intent.getExtras().getInt("idModule");


        Module module = db.moduleDao().findById(idModule);


        int idChapitre = intent.getExtras().getInt("idChapitre");


        Chapitre chapitre = db.chapitreDao().findById(idChapitre);


        textView = findViewById(R.id.textView);

        textView.setText(chapitre.getTitre()+ " : "+ chapitre.getVideo());

        chapitres = db.chapitreDao().getAllChapitre(idModule);


        recyclerView = findViewById(R.id.recyclerView);

        MyAdapterChapitre myAdapterChapitre = new MyAdapterChapitre(this, chapitres, module);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myAdapterChapitre);



    }


    private Uri getMedia(String mediaName)
    {
//        return Uri.parse("android.resource://" + getPackageName() +
//                "/raw/" +

        if (URLUtil.isValidUrl(mediaName)) {
            // Media name is an external URL.
            return Uri.parse(mediaName);
        } else {
            // Media name is a raw resource embedded in the app.
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + mediaName);
        }
    }

    private void initializePlayer()
    {


//        Intent intent = getIntent();
//
//        String lien = intent.getExtras().getString("lien");
//
//        Uri uri = getMedia(lien);
//
//        mVideoView.setVideoURI(uri);
//
//        if (mCurrentPosition>0)
//        {
//            mVideoView.seekTo(mCurrentPosition);
//        }
//        else {
//            mVideoView.seekTo(1);
//        }
//
//        mVideoView.start();

        //---------------nouveau code-------------------------------------------
        // Buffer and decode the video sample.
        Uri videoUri = getMedia(VIDEO_SAMPLE);
        mVideoView.setVideoURI(videoUri);

        // Listener for onPrepared() event (runs after the media is prepared).
        mVideoView.setOnPreparedListener(
                new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {

                        // Hide buffering message.
                      //  mBufferingTextView.setVisibility(VideoView.INVISIBLE);

                        // Restore saved position, if available.
                        if (mCurrentPosition > 0) {
                            mVideoView.seekTo(mCurrentPosition);
                        } else {
                            // Skipping to 1 shows the first frame of the video.
                            mVideoView.seekTo(1);
                        }

                        // Start playing!
                        mVideoView.start();
                    }
                });

        // Listener for onCompletion() event (runs after media has finished
        // playing).
        mVideoView.setOnCompletionListener(
                new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {


                        // Return the video position to the start.
                        mVideoView.seekTo(0);
                    }
                });

    }


    private void releasePlayer()
    {
        mVideoView.stopPlayback();
    }


    @Override
    protected void onStart() {
        super.onStart();

        initializePlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releasePlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();

        mVideoView.pause();
    }

    @Override
    protected void onResume() {


        super.onResume();



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(PLAYBACK_TIME, mVideoView.getCurrentPosition());
    }


    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }


}
