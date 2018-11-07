package example.com.myvideoplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        String urlString = getIntent().getStringExtra(MainActivity.VIDEO_URL_EXTRA);
        //Toast.makeText(VideoActivity.this, urlString, Toast.LENGTH_SHORT).show();

        mVideoView = (VideoView)findViewById(R.id.video);
        Uri uri = Uri.parse(urlString);
        mVideoView.setVideoURI(uri);


        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(mVideoView);
        mVideoView.setMediaController(mediaController);

        mVideoView.start();
    }
}
