package elice18pjt.deukryeol.fashionretrieval;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraActivity extends Activity implements View.OnClickListener{
    private ImageButton btnList;
    private ImageButton btnCamera;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Uri fileUri;
    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btnList = (ImageButton)findViewById(R.id.btnList);
        btnCamera = (ImageButton)findViewById(R.id.btnCamera);
        mImageView = (ImageView)findViewById(R.id.imageView);
        btnCamera.setOnClickListener(this);
        btnList.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnList:
                break;
            case R.id.btnCamera:
                dispatchTakePictureIntent();
                break;
        }
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }
}
