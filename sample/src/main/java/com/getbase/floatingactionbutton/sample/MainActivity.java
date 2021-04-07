package com.getbase.floatingactionbutton.sample;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{

  FloatingActionsMenu modeMenu;
  FloatingActionButton motorMode,cycleMode,pedMode,disMode;

  byte modeValue=0;//1-2(motor),3-4(cycle),5-6(ped)

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    modeMenu =(FloatingActionsMenu) findViewById(R.id.mode_menu);
    motorMode =(FloatingActionButton) findViewById(R.id.mode_motor);
    cycleMode=(FloatingActionButton) findViewById(R.id.mode_cycle);
    pedMode =(FloatingActionButton) findViewById(R.id.mode_ped);
    disMode =(FloatingActionButton) findViewById(R.id.disconnect);

    disMode.setOnClickListener(this);
    motorMode.setOnClickListener(this);
    cycleMode.setOnClickListener(this);
    pedMode.setOnClickListener(this);

  }

  @TargetApi(Build.VERSION_CODES.O)
  @Override
  public void onClick(View v) {

    modeMenu.collapse();

    switch (v.getId()){

      case R.id.mode_motor:

        if(modeValue==0||modeValue>2){
          modeValue=1;
          modeMenu.updateAddButton(R.drawable.menu_auto_on);
          motorMode.setVisibility(View.GONE);
          cycleMode.setIconDrawable(getDrawable(R.drawable.menu_bike_off));
          cycleMode.setTitle("Be a Cyclist.");
          cycleMode.setVisibility(View.VISIBLE);
          pedMode.setIconDrawable(getDrawable(R.drawable.menu_walk_off));
          pedMode.setTitle("Be a Pedestrian.");
          disMode.setIconDrawable(getDrawable(R.drawable.menu_minus_off));
          disMode.setTitle("Disconnect.");
          disMode.setVisibility(View.VISIBLE);
          pedMode.setVisibility(View.VISIBLE);
        }

        break;
      case R.id.mode_cycle:

        if(modeValue<3||modeValue>4) {
          modeValue = 3;
          modeMenu.updateAddButton(R.drawable.menu_bike_on);
          motorMode.setIconDrawable(getDrawable(R.drawable.menu_auto_off));
          motorMode.setTitle("Be a Motorist.");
          motorMode.setVisibility(View.VISIBLE);
          cycleMode.setVisibility(View.GONE);
          pedMode.setIconDrawable(getDrawable(R.drawable.menu_walk_off));
          pedMode.setTitle("Be a Pedestrian.");
          disMode.setIconDrawable(getDrawable(R.drawable.menu_minus_off));
          disMode.setTitle("Disconnect.");
          disMode.setVisibility(View.VISIBLE);
          pedMode.setVisibility(View.VISIBLE);
        }
        break;
      case R.id.mode_ped:

        if(modeValue<5) {
          modeValue = 5;
          modeMenu.updateAddButton(R.drawable.menu_walk_on);
          motorMode.setIconDrawable(getDrawable(R.drawable.menu_auto_off));
          motorMode.setTitle("Be a Motorist.");
          motorMode.setVisibility(View.VISIBLE);
          cycleMode.setIconDrawable(getDrawable(R.drawable.menu_bike_off));
          cycleMode.setTitle("Be a Cyclist.");
          cycleMode.setVisibility(View.VISIBLE);
          disMode.setIconDrawable(getDrawable(R.drawable.menu_minus_off));
          disMode.setTitle("Disconnect.");
          disMode.setVisibility(View.VISIBLE);
          pedMode.setVisibility(View.GONE);
        }
        break;

        case R.id.disconnect:

        if(modeValue!=0) {
          modeValue = 0;
          modeMenu.updateAddButton(R.drawable.menu_minus_on);
          motorMode.setIconDrawable(getDrawable(R.drawable.menu_auto_off));
          motorMode.setTitle("Be a Motorist.");
          motorMode.setVisibility(View.VISIBLE);
          cycleMode.setIconDrawable(getDrawable(R.drawable.menu_bike_off));
          cycleMode.setTitle("Be a Cyclist.");
          cycleMode.setVisibility(View.VISIBLE);
          pedMode.setIconDrawable(getDrawable(R.drawable.menu_walk_off));
          pedMode.setTitle("Be a Pedestrian.");
          pedMode.setVisibility(View.VISIBLE);
          disMode.setVisibility(View.GONE);
        }
        break;
    }
  }
}
