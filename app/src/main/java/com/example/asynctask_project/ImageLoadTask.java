package com.example.asynctask_project;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageLoadTask extends AsyncTask<ImageView , Integer, Bitmap> {

    //Asycn task basic structere Start
    ImageView iv;
    //Method 1
    @Override
    protected Bitmap doInBackground(ImageView... imageViews) {
        Bitmap bmp = null;
        return bmp;
    }

    //This method input type is onBackground method data type
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        iv.setImageBitmap(bitmap);
    }
    //end





    //Progress eka apita ganna puluwan
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    //Me wede patanganna kalin dewal
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
