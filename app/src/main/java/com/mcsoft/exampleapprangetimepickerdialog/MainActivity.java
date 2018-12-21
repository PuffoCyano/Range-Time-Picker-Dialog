package com.mcsoft.exampleapprangetimepickerdialog;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mcsoft.timerangepickerdialog.RangeTimePickerDialog;

public class MainActivity extends AppCompatActivity implements RangeTimePickerDialog.ISelectedTime
{
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      fab.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View view)
         {
            showCustomDialogTimePicker();
         }
      });
   }

   public void showCustomDialogTimePicker()
   {
      // Create an instance of the dialog fragment and show it
      RangeTimePickerDialog dialog = new RangeTimePickerDialog();
      dialog.newInstance();
      dialog.setIs24HourView(true);
      dialog.setRadiusDialog(20);
      dialog.setTextTabStart("Start");
      dialog.setTextTabEnd("End");
      dialog.setTextBtnPositive("Accept");
      dialog.setTextBtnNegative("Close");
      dialog.setValidateRange(false);
      dialog.setColorBackgroundHeader(R.color.colorPrimary);
      dialog.setColorBackgroundTimePickerHeader(R.color.colorPrimary);
      dialog.setColorTextButton(R.color.colorPrimaryDark);
      dialog.enableMinutes(true);
      dialog.setStartTabIcon(R.drawable.ic_access_time_black_24dp);
      dialog.setEndTabIcon(R.drawable.ic_timelapse_black_24dp);
//      dialog.setInitialOpenedTab(RangeTimePickerDialog.InitialOpenedTab.START_CLOCK_TAB);
//      dialog.setInitialStartClock(3,45);
//      dialog.setInitialEndClock(16,33);
      FragmentManager fragmentManager = getFragmentManager();
      dialog.show(fragmentManager, "");
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu)
   {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.menu_main, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item)
   {
      // Handle action bar item clicks here. The action bar will
      // automatically handle clicks on the Home/Up button, so long
      // as you specify a parent activity in AndroidManifest.xml.
      int id = item.getItemId();

      //noinspection SimplifiableIfStatement
      if (id == R.id.action_settings)
      {
         return true;
      }

      return super.onOptionsItemSelected(item);
   }

   @Override
   public void onSelectedTime(int hourStart, int minuteStart, int hourEnd, int minuteEnd)
   {
      Toast.makeText(this, "Start: "+hourStart+":"+minuteStart+"\nEnd: "+hourEnd+":"+minuteEnd, Toast.LENGTH_SHORT).show();
   }
}
