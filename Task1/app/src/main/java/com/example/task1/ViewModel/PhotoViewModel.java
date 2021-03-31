package com.example.task1.ViewModel;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.task1.Model.Photos;
import com.example.task1.View.MainActivity;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.task1.View.Fragments.HomeFragment.imageUrls;
import static com.example.task1.View.Fragments.HomeFragment.recyclerAdapter;

public class PhotoViewModel extends AndroidViewModel {
    public PhotoViewModel(@NonNull Application application) {
        super(application);

        Call<Photos> call = RetrofitClient.getInstance().getMyApi().getPhotos();

        call.enqueue(new Callback<Photos>() {
            @Override
            public void onResponse(Call<Photos> call, Response<Photos> response) {
                Photos photos = response.body();
                //Log.i("Output", String.valueOf(photos.getPhotosData().getTotal()));
                for (int i = 0; i < photos.getPhotosData().getPhotoDetails().size(); i++) {
                    imageUrls.add(photos.getPhotosData().getPhotoDetails().get(i).getUrl_s());
                    //Log.i("Image URL", imageUrls.get(i));
                }
                recyclerAdapter.notifyDataSetChanged();
                //Toast.makeText(getApplicationContext(),photos.getStat(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Photos> call, Throwable t) {
                //Log.i("Output", t.getMessage());
                Toast.makeText(application, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}
