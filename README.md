# Range-Time-Picker-Dialog
[![](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
<a target="_blank" href="https://developer.android.com/reference/android/os/Build.VERSION_CODES.html#JELLY_BEAN"><img src="https://img.shields.io/badge/API-14%2B-blue.svg?style=flat" alt="API" /></a>

Simple Android Library that provide you a custom dialog that allow you to set a start time and end time.

Screenshot
:-------------------------
![](https://i.imgur.com/TbBcjS5.jpg?1) ![](https://i.imgur.com/Fta9uUw.jpg?1)
![](https://i.imgur.com/vgIhIwr.jpg?1) ![](https://i.imgur.com/8a4R16O.jpg?1)
![](https://i.imgur.com/Sh8BHNB.jpg?1) ![](https://i.imgur.com/6MRme3P.jpg?1)

## Install
Add this to your project build.gradle
``` gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
Add this to your module build.gradle

```gradle
   dependencies {
        compile 'com.github.PuffoCyano:Range-Time-Picker-Dialog:v1.1'
    }

```
### Usage
In your <b>activity</b> (Default method "newInstance()"):
```java
    // Create an instance of the dialog fragment and show it
    RangeTimePickerDialog dialog = new RangeTimePickerDialog();
    dialog.newInstance();
    dialog.setRadiusDialog(20); // Set radius of dialog (default is 50)
    dialog.setIs24HourView(true); // Indicates if the format should be 24 hours
    dialog.setColorBackgroundHeader(R.color.colorPrimary); // Set Color of Background header dialog
    dialog.setColorTextButton(R.color.colorPrimaryDark); // Set Text color of button
    FragmentManager fragmentManager = getFragmentManager();
    dialog.show(fragmentManager, "");
```
You can instantiate the dialog with more parameters:
```java
     // Create an instance of the dialog fragment and show it
     RangeTimePickerDialog dialog = new RangeTimePickerDialog();
     dialog.newInstance(R.color.CyanWater, R.color.White, R.color.Yellow, R.color.colorPrimary, true);
     FragmentManager fragmentManager = getFragmentManager();
     dialog.show(fragmentManager, "");
```
To read parameter from Dialog your activity have to implements the interface ISelectedTime:
```java
public class MainActivity extends AppCompatActivity implements RangeTimePickerDialog.ISelectedTime
```
Then you have to override the method "onSelectedTime":
```java
@Override
public void onSelectedTime(int hourStart, int minuteStart, int hourEnd, int minuteEnd)
{
  // Use parameters provided by Dialog
  Toast.makeText(this, "Start: "+hourStart+":"+minuteStart+"\nEnd: "+hourEnd+":"+minuteEnd, Toast.LENGTH_SHORT).show();
}
```
In your <b>fragment</b>:
```java
   // Create an instance of the dialog fragment and show it
   RangeTimePickerDialog dialog = new RangeTimePickerDialog();
   dialog.newInstance(R.color.CyanWater, R.color.White, R.color.Yellow, R.color.colorPrimary, true);
   FragmentManager fragmentManager = getFragmentManager();
   dialog.setTargetFragment(this, MY_FRAGMENT_ID); // MY_FRAGMENT_ID is a personal identifier that allow you to get parameter from dialog into onActivityResult
   dialog.show(fragmentManager, "");
```
When you have to read parameter provided by Dialog you have to override onResultActivity in your fragment:
```java
@Override
public void onActivityResult(int requestCode, int resultCode, Intent data)
{
   super.onActivityResult(requestCode, resultCode, data);
   if (requestCode == MY_FRAGMENT_ID)
   {
      if (resultCode == Activity.RESULT_OK)
      {
         if (data.getExtras().containsKey(RangeTimePickerDialog.HOUR_START))
         {
            int hourStart = data.getExtras().getInt(RangeTimePickerDialog.HOUR_START);
            int hourEnd = data.getExtras().getInt(RangeTimePickerDialog.HOUR_END);
            int minuteStart = data.getExtras().getInt(RangeTimePickerDialog.MINUTE_START);
            int minuteEnd = data.getExtras().getInt(RangeTimePickerDialog.MINUTE_END);
            // Use the returned value
            Toast.makeText(getActivity(), "Time start:"+hourStart+":"+minuteStart+"\nUntil: "+hourEnd+":"+minuteEnd, Toast.LENGTH_SHORT).show();
         }
      }
   }
}
```

## License
```
Copyright 2018 Alessandro Marino

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
