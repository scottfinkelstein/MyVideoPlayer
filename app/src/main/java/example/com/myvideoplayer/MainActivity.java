package example.com.myvideoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        List<VideoObject> videos = new ArrayList<VideoObject>();
        videos.add(new VideoObject("Video 1", "http://google.com"));
        videos.add(new VideoObject("Video 2", "http://google.com"));
        videos.add(new VideoObject("Video 3", "http://google.com"));

        VideoAdapter adapter = new VideoAdapter(videos);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setAdapter(adapter);
    }
}
