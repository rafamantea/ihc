package com.ihc.lixoeletronico;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.ihc.lixoeletronico.com.ihc.lixoeletronico.model.DiscardPlace;
import com.ihc.lixoeletronico.com.ihc.lixoeletronico.model.MockDatabase;

import java.io.IOException;
import java.util.List;

public class AddPlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place);
        setTitle("Cadastrar ponto de Descarte");

        Button addButton = (Button) findViewById(R.id.button_add_place);
        final EditText nameEdit = (EditText) findViewById(R.id.edit_add_place_name);
        final EditText addressEdit = (EditText) findViewById(R.id.edit_add_place_address);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Geocoder geocoder = new Geocoder(AddPlaceActivity.this);
                final List<Address> addresses;
                try {
                    addresses = geocoder.getFromLocationName(addressEdit.getText().toString(), 1);
                    if(addresses.size() > 0) {
                        double latitude= addresses.get(0).getLatitude();
                        double longitude= addresses.get(0).getLongitude();
                        DiscardPlace newPlace = new DiscardPlace(nameEdit.getText().toString(), addressEdit.getText().toString(), new LatLng(latitude, longitude));
                        MockDatabase.getInstance().addPlace(newPlace);
                        AddPlaceActivity.this.finish();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
