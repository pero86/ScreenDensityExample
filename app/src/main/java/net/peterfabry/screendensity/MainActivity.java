package net.peterfabry.screendensity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float scale = displayMetrics.density; // ratio based on which everything else is calculated
        Log.d("Screen density Scale",String.valueOf(scale));
        int densityDpi = (int)(scale * 160f); // calculating DPI base on ratio we got
        Log.d("Density DPI",String.valueOf(densityDpi)); // getting calculated DPI density
        Log.d("Density DPI", String.valueOf(displayMetrics.densityDpi)); // getting DPI density directly

        /* Calculating DP from px Method 1 */
        float dp_value = 200;
        float px_value = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp_value, getResources().getDisplayMetrics());
        Log.d("Pixels value", String.valueOf(px_value));

        /* Calculating DP from px Method 2 */
        dp_value = 200;
        px_value =  dp_value * scale + 0.5f;
        Log.d("Pixels value", String.valueOf(px_value));

        /* Calculating px from DP */
        px_value = 100;
        dp_value = px_value / scale + 0.5f;
        Log.d("DP value", String.valueOf(dp_value));

    }
}
