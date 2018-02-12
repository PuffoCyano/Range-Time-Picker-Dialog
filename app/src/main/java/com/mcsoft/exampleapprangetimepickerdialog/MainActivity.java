package com.mcsoft.exampleapprangetimepickerdialog;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
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
      dialog.newInstance(R.color.CyanWater, R.color.White, R.color.Yellow, R.color.Yellow, true);
      FragmentManager fragmentManager = getFragmentManager();
      dialog.setMessageErrorRangeTime("Devi selezionare una data finale maggiore di quella iniziale");
      dialog.setTextBtnNegative("Annulla");
      dialog.setTextBtnPositive("Conferma");
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
