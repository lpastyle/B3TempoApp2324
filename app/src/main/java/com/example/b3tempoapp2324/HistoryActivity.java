package com.example.b3tempoapp2324;

import static com.example.b3tempoapp2324.MainActivity.edfApi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.b3tempoapp2324.databinding.ActivityHistoryBinding;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity {
    private final static String LOG_TAG = HistoryActivity.class.getSimpleName();
    private ActivityHistoryBinding binding;

    private List<TempoDate> tempoDates = new ArrayList<>();
    private TempoDateAdapter tempoDateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Init recycler view
        binding.tempoHistoryRv.setHasFixedSize(true);
        binding.tempoHistoryRv.setLayoutManager(new LinearLayoutManager(this));
        tempoDateAdapter = new TempoDateAdapter(tempoDates, this);
        binding.tempoHistoryRv.setAdapter(tempoDateAdapter);

        updateTempoHistory();

    }

    private void updateTempoHistory() {
        Call<TempoHistory> call = edfApi.getTempoHistory("2023","2024");
        binding.tempoHistoryPb.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<TempoHistory>() {
            @Override
            public void onResponse(@NonNull Call<TempoHistory> call, @NonNull Response<TempoHistory> response) {
               tempoDates.clear();
                if (response.code() == HttpURLConnection.HTTP_OK && response.body()!= null) {
                    tempoDates.addAll(response.body().getTempoDates());
                    Log.d(LOG_TAG,"nb elements = " + tempoDates.size());
                    tempoDateAdapter.notifyDataSetChanged();
                } else {
                    Log.e(LOG_TAG," call to getTempoHistory() failed with error code "+ response.code());
                }
                binding.tempoHistoryPb.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<TempoHistory> call, @NonNull Throwable t) {
                Log.e(LOG_TAG," call to getTempoHistory() failed");
                binding.tempoHistoryPb.setVisibility(View.GONE);
            }
        });
    }

}