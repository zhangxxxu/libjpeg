package com.zx.example;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.common.utils.ImageCompress;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MPermissionUtils.requestPermissionsResult(this, 0, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, null);
        // TODO 放一张图片名称为 bbb.jpg 的图片到手机存储根目录
        File f = new File(getFileDir(), "bbb.jpg");
        Bitmap bitmap = BitmapFactory.decodeFile(f.getAbsolutePath());
        String result = getFileDir() + "/result.png";
        int qu = 100; //压缩质量为1~100，值越大，图片越清晰
        ImageCompress.nativeCompressBitmap(bitmap, qu, result);
    }

    private String getFileDir() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

}
