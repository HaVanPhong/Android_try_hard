package com.example.getvideofromgaraly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnGetVideo;

    VideoAdapter videoAdapter;
    List<Video> listVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rcv);
        btnGetVideo=findViewById(R.id.btnGetAllVideo);
        videoAdapter=new VideoAdapter(this);


        GridLayoutManager gridLayoutManager=new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        btnGetVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCheckPermission();
            }
        });


    }

    private void myCheckPermission() {
        PermissionListener permissionListener=new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                getAllVideofromGallary();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {

            }
        };
        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .check();
    }

    private void getAllVideofromGallary() {
        listVideo = new ArrayList<>();
        Uri uri;
        Cursor cursor;
        int columnIndexData, thumb;

        String absolutePathOfImage=null;
        String thumbnai=null;

        uri= MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

        String [] projection ={MediaStore.MediaColumns.DATA, MediaStore.Video.Media.BUCKET_DISPLAY_NAME,
                    MediaStore.Video.Media._ID, MediaStore.Video.Thumbnails.DATA};

        final String orderBy= MediaStore.Images.Media.DATE_TAKEN;

        cursor=getApplicationContext().getContentResolver().query(uri, projection, null, null, orderBy + " DESC");

        columnIndexData = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        thumb= cursor.getColumnIndexOrThrow(MediaStore.Video.Thumbnails.DATA);

        while (cursor.moveToNext()){
            absolutePathOfImage=cursor.getString(columnIndexData);
            thumbnai= cursor.getString(thumb);

            Video video=new Video();

            video.setPath(absolutePathOfImage);
            video.setThumb(thumbnai);
            listVideo.add(video);
        }
        videoAdapter.setData(listVideo);
        recyclerView.setAdapter(videoAdapter);
    }
}