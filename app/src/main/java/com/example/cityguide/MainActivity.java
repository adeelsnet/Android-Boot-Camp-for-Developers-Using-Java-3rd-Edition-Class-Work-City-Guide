package com.example.cityguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        String[ ] attraction = {"Art Institute of Chicago", "Magnificent Mile", "Willis Tower", "Navy Pier", "Water Tower"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.travel, attraction));

    }

    @NonNull
    private Intent getIntentForImageActivity (int imageId)
    {
        // Create intent object to be used by choices 2-4
        Intent intent = new Intent (MainActivity.this, ImageActivity.class);

        // add to the intent object which drawable we want to use (Willis, Water, et al.)
        intent.putExtra ("IMAGE_ID",imageId);

        // send that "loaded" object back to case 2, 3 or 4
        return intent;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                startActivity(
                        new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("http://artic.edu")
                        ));
                break;
            case 1:
                startActivity(
                        new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("http://themagnificentmile.com")
                        ));
                break;
            case 2:
                startActivity(getIntentForImageActivity(R.drawable.willis));
                break;
            case 3:
                startActivity(getIntentForImageActivity(R.drawable.pier));
                break;
            case 4:
                startActivity(getIntentForImageActivity(R.drawable.water));
                break;
            default:
                        super.onListItemClick(l, v, position, id);
        }
    }
}
