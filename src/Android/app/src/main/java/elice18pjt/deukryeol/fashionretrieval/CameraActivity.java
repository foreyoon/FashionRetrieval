package elice18pjt.deukryeol.fashionretrieval;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraActivity extends Activity implements View.OnClickListener{
    private ImageButton btnList;
    private ImageButton btnCamera;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Uri fileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btnList = (ImageButton)findViewById(R.id.btnList);
        btnCamera = (ImageButton)findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(this);
        btnList.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnList:
                break;
            case R.id.btnCamera:
                break;
        }
    }

}
