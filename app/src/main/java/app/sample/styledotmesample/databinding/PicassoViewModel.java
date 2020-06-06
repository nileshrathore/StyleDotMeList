package app.sample.styledotmesample.databinding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

import app.sample.AppApplication;

public class PicassoViewModel {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        try {
            new Picasso.Builder(AppApplication.getInstance()).
                    build()
                    .load(imageUrl)
                    .into(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}