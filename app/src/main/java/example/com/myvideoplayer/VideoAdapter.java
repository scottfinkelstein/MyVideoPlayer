package example.com.myvideoplayer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {

    List<VideoObject> mVideoObjects;

    public VideoAdapter(List<VideoObject> videoObjectsList) {
        mVideoObjects = videoObjectsList;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View listView = inflater.inflate(R.layout.list_item, viewGroup, false);
        VideoHolder videoHolder = new VideoHolder(listView);
        return videoHolder;
    }

    @Override
    public int getItemCount() {
        return mVideoObjects.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder videoHolder, int i) {
        VideoObject vidObject = mVideoObjects.get(i);
        videoHolder.videoTitle.setText(vidObject.title);
    }

    public class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView videoTitle;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            videoTitle = (TextView)itemView.findViewById(R.id.videoTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            VideoObject videoObj = mVideoObjects.get(getLayoutPosition());
            Intent intent = new Intent(v.getContext(), VideoActivity.class);
            intent.putExtra(MainActivity.VIDEO_URL_EXTRA, videoObj.url);
            v.getContext().startActivity(intent);
        }
    }
}
