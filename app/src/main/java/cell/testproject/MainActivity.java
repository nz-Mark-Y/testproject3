package cell.testproject;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    int songSelect;

    //Initialise spinner and adapter
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    //Initialise MediaPlayer
    MediaPlayer maximum;
    MediaPlayer duel;
    MediaPlayer pylons;
    MediaPlayer shame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting up MediaPlayer
        maximum = MediaPlayer.create(this, R.raw.maximum);
        duel = MediaPlayer.create(this, R.raw.duel);
        pylons = MediaPlayer.create(this, R.raw.pylons);
        shame = MediaPlayer.create(this, R.raw.shame);

        //Setting up spinner and functionality
        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.audio_files,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Event listener for spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int i, long l) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(i)+" selected",Toast.LENGTH_SHORT).show();
                songSelect = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    //Event listener for button
    public void buttonOnClick(View v) {
        if (songSelect == 0) maximum.start();
        if (songSelect == 1) duel.start();
        if (songSelect == 2) pylons.start();
        if (songSelect == 3) shame.start();
    }
}
