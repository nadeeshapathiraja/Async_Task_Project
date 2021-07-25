package com.example.asynctask_project;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class ImageLoadTask extends AsyncTask<ImageView , Integer, Bitmap> {

    //Asycn task basic structere Start
    ImageView iv;
    //Method 1
    @Override
    protected Bitmap doInBackground(ImageView... imageViews) {
        Bitmap bmp = null;
        try{
            URL url = new URL("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pexels.com%2Fsearch%2Ffree%2520wallpaper%2F&psig=AOvVaw1U9ruZij2vk7huu6s6LMvO&ust=1627276157297000&source=images&cd=vfe&ved=2ahUKEwj0id2buv3xAhUyg0sFHY8DBt4Qr4kDegUIARDHAQ");
            InputStream in = url.openConnection().getInputStream();

            //Image eke enne eke input streme eka
            bmp = BitmapFactory.decodeStream(in);

        }catch (Exception e){
            e.printStackTrace();
        }
        return bmp;
    }

    //This method input type is onBackground method data type
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        try {
            iv.setImageBitmap(bitmap);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //end





//    //Progress eka apita ganna puluwan
//    @Override
//    protected void onProgressUpdate(Integer... values) {
//        super.onProgressUpdate(values);
//    }
//
//    //Me wede patanganna kalin dewal
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//    }
}
