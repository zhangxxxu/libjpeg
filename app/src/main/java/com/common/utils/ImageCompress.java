package com.common.utils;

import android.graphics.Bitmap;

public class ImageCompress {

    static {
        System.loadLibrary("imagecompress");
    }


    public static native int nativeCompressBitmap(Bitmap bitmap, int quality, String destFile);
}
