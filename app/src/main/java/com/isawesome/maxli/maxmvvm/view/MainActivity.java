package com.isawesome.maxli.maxmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import com.isawesome.maxli.maxmvvm.R;
import com.isawesome.maxli.maxmvvm.databinding.ActivityMainBinding;
import com.isawesome.maxli.maxmvvm.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;

    //view of the activity
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set up layout
        setContentView(getContentView());

        //set up binding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, getContentView());
        binding.setActivity(this);

        //ViewModel stuff
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();

        //update UI
        mainActivityViewModel.getUser().observe(this, user -> {
            binding.setUser(mainActivityViewModel.getUser().getValue());
        });
    }

    public void onButtonClick() {
        mainActivityViewModel.changeUserValue("Jameson", "Macallan", "Blue Label", "Buffalo Trace");
    }

    public void onButtonClick2() {
        mainActivityViewModel.changeUserValue("Pizza", "Hamburger", "Kbbq", "Sushi");
    }

    public void onButtonClick3() {
        mainActivityViewModel.changeUserValue("Weihenstephaner", "Blue Moon", "Sam Adams", "805");
    }
}
