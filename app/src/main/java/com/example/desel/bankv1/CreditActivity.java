package com.example.desel.bankv1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

public class CreditActivity extends AppCompatActivity
{
    // VARIABLES

    // Database Related
    DatabaseHelper myDB;
    SQLiteDatabase sqLiteDatabase;

    // Text Views
    TextView tvAmount;

    // Chart Related
    LineChart lineChart;
    LineDataSet lineDataSet = new LineDataSet(null, null);
    LineData lineData;

    // Arrays
    ArrayList<ILineDataSet> dataSets = new ArrayList<>();

    // Edit Texts
    EditText etIAmount;

    // Other
    ListView lvList;

    // Debugging
    private static final String TAG = "CreditActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        // INITIALISING

        // Database Related
        myDB = new DatabaseHelper(this);

        // Text Views
        tvAmount = findViewById(R.id.tvAmount);

        // Chart Related
        lineChart = findViewById(R.id.lineChartCredit);
        sqLiteDatabase = myDB.getWritableDatabase();

        // Edit Texts
        etIAmount = findViewById(R.id.etIAmount);

        // Arrays
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();

        // Other
        lvList = findViewById(R.id.lvChequeTransactions);

        viewTransactionHistory();
        Log.i(TAG, "onCreate: List View Viewing");
        viewAmount();
        executeShow();
        styling();
    }

    private void viewTransactionHistory()
    {
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContentCredit();

        if (data.getCount() == 0)
        {
            Toast.makeText
                    (this, "The database is empty",
                            Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(data.moveToNext())
            {
                if (data.getString(2).equals("Cheque") ||
                        data.getString(2).equals("Savings") ||
                        data.getString(2).equals("Business"))
                {
                    // This value is the column ID for the Items
                    theList.add("\n    " + String.format("R%.2f", data.getDouble(5)) + " WAS HOW MUCH YOU HAD\n" +
                            "    " + String.format("R%.2f", data.getDouble(1)) + " TRANSFER FROM '" + data.getString(2) + "\' ACCOUNT \n" +
                            "'   " + String.format("R%.2f", data.getDouble(3)) + " IS THE NEW AMOUNT \n" +
                            "    SPEND CATEGORY IS \'" + data.getString(4) + "\'\n" +
                            "    ON \'" + data.getString(7) + "\' ACCOUNT\n" +
                            "    ACCOUNT NO. '" + data.getString(8) + "\'\n" +
                            "    TIMESTAMP WAS \'" + data.getString(6) + "\'\n");

                    ListAdapter listAdapter = new ArrayAdapter<>
                            // the list style which  is changeable
                            (this, android.R.layout.simple_list_item_1, theList);

                    lvList.setAdapter(listAdapter);
                }
                else if (data.getString(2).equals("Credit")) {
                    // This value is the column ID for the Items
                    theList.add("\n    " + String.format("R%.2f", data.getDouble(5)) + " WAS HOW MUCH YOU HAD\n" +
                            "    " + String.format("R%.2f", data.getDouble(1)) + " TRANSFER MADE TO '" + data.getString(9) + "\' ACCOUNT\n" +
                            "'   " + String.format("R%.2f", data.getDouble(3)) + " IS THE REMAINING AMOUNT \n" +
                            "    SPEND CATEGORY IS \'" + data.getString(4) + "\'\n" +
                            "    ON \'" + data.getString(7) + "\' ACCOUNT\n" +
                            "    ACCOUNT NO. '" + data.getString(8) + "\'\n" +
                            "    TIMESTAMP WAS \'" + data.getString(6) + "\'\n");

                    ListAdapter listAdapter = new ArrayAdapter<>
                            // the list style which  is changeable
                            (this, android.R.layout.simple_list_item_1, theList);

                    lvList.setAdapter(listAdapter);
                }
                else
                {
                    // This value is the column ID for the Items
                    theList.add("\n    " + String.format("R%.2f", data.getDouble(5)) + " WAS HOW MUCH YOU HAD\n" +
                            "    " + String.format("R%.2f", data.getDouble(1)) + " PURCHASE MADE TO '" + data.getString(2) + "\'\n" +
                            "'   " + String.format("R%.2f", data.getDouble(3)) + " IS THE REMAINING AMOUNT \n" +
                            "    SPEND CATEGORY IS \'" + data.getString(4) + "\'\n" +
                            "    ON \'" + data.getString(7) + "\' ACCOUNT\n" +
                            "    ACCOUNT NO. '" + data.getString(8) + "\'\n" +
                            "    TIMESTAMP WAS \'" + data.getString(6) + "\'\n");

                    ListAdapter listAdapter = new ArrayAdapter<>
                            // the list style which  is changeable
                            (this, android.R.layout.simple_list_item_1, theList);

                    lvList.setAdapter(listAdapter);
                }
            }
        }
    }

    private void viewAmount()
    {
        Cursor data = myDB.getLastValueCredit();

        if (data.getCount() == 0)
        {
            Toast.makeText
                    (this, "The database is empty",
                            Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (data.moveToNext())
            {
                // This value is the column ID for the Items
                etIAmount.setText("" + String.format("R%.2f", data.getDouble(3)));

                tvAmount.setText("" + etIAmount.getText().toString());
            }
        }
    }

    private void executeShow()
    {
        lineDataSet.setValues(getDataValues());
        lineDataSet.setLabel("Cheque Balance");

        // will refresh the chart to fill with new values
        dataSets.clear();
        dataSets.add(lineDataSet);

        lineData = new LineData(dataSets);
        lineData.setValueFormatter(new CreditActivity.myValueFormatter());

        lineChart.clear();
        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    private void styling()
    {
        lineDataSet.setLineWidth(4);

        lineChart.setNoDataText("No Data Found yet");
        lineChart.setDrawGridBackground(false);
        lineChart.setDrawBorders(false);

        lineChart.setBackgroundColor(Color.rgb(16, 100, 147));
        lineChart.setNoDataTextColor(Color.BLACK);
        lineChart.setBorderColor(Color.YELLOW);
        lineChart.setBorderWidth(0);
        //lineChart.setViewPortOffsets(-10, 0, 0, 0);
        lineChart.setVisibleXRangeMaximum(3);
        lineChart.moveViewToX(0);

        Description description = new Description();
        description.setText("Available Balance Over Time");
        description.setYOffset(-15f);
        description.setTextColor(Color.WHITE);
        description.setTextSize(15);
        lineChart.setDescription(description);

        // These remove the background grid lines properly
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getAxisLeft().setDrawGridLines(true);
        lineChart.getAxisRight().setDrawGridLines(false);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.setExtraBottomOffset(20f);
        lineChart.getXAxis().setDrawLabels(false);
        lineChart.getLegend().setEnabled(false);

        XAxis xAxis = lineChart.getXAxis();
        YAxis yAxisLeft = lineChart.getAxisLeft();
        YAxis yAxisRight = lineChart.getAxisRight();

        xAxis.setValueFormatter(new CreditActivity.MyAxisValueFormatter());
        yAxisLeft.setValueFormatter(new CreditActivity.MyYAxisValueFormatter());
        //yAxisLeft.setValueFormatter(new MyAxisValueFormatter());
        //yAxisRight.setValueFormatter(new MyAxisValueFormatter());
        xAxis.setTextColor(Color.WHITE);
        yAxisLeft.setTextColor(Color.WHITE);
        yAxisRight.setTextColor(Color.WHITE);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setSpaceMin(0.60f);
        xAxis.setSpaceMax(0.40f);
        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawLabels(false);

        lineChart.setExtraLeftOffset(10);
        lineChart.setExtraRightOffset(10);
        xAxis.setAvoidFirstLastClipping(true);

        // Line Styling used on lineDataSet1
        lineDataSet.setLineWidth(3);
        lineDataSet.setColor(Color.rgb(102, 209, 253));
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setValueTextColor(Color.WHITE);
        lineDataSet.setValueTextSize(12);
        lineDataSet.setCircleColor(Color.WHITE);
        lineDataSet.setCircleHoleColor(Color.rgb(16, 100, 147));
        lineDataSet.setCircleRadius(5);
        lineDataSet.setCircleHoleRadius(3);
        lineDataSet.enableDashedLine(5, 10, 0);
    }

    private class MyAxisValueFormatter implements IAxisValueFormatter
    {
        @Override
        public String getFormattedValue(float value, AxisBase axis)
        {
            // Sets how many labels appear on x-axis
            axis.setLabelCount(5, true);

            return "Day " + value;
        }
    }

    private class MyYAxisValueFormatter implements IAxisValueFormatter
    {
        @Override
        public String getFormattedValue(float value, AxisBase axis)
        {
            // Sets how many labels appear on x-axis
            axis.setLabelCount(5, true);

            return "" + String.format("R%.0f", value);
        }
    }

    private class myValueFormatter implements IValueFormatter
    {
        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex,
                                        ViewPortHandler viewPortHandler)
        {
            return "" + String.format("R%.2f", value);
        }
    }

    // Taking data and getting ready to put it in the Chart
    private ArrayList<Entry> getDataValues()
    {
        ArrayList<Entry> dataVals = new ArrayList<>();
        String[] columns = {"SecondAmount", "ID"};

//        // Executing Query on how to retrieve the data or which data to get
//        Cursor cursor = sqLiteDatabase.query("cheque_data", columns, null,
//                null, null, null, null);
//
//        for (int i=0; i<cursor.getCount(); i++)
//        {
//            cursor.moveToNext();
//            dataVals.add(new Entry(cursor.getFloat(0), cursor.getFloat(1)));
//        }



        Cursor data = myDB.getGraphContentCredit();

        if (data.getCount() == 0)
        {
            Toast.makeText
                    (this, "The database is empty",
                            Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (data.moveToNext())
            {
                dataVals.add(new Entry
                        (data.getFloat(0), data.getFloat(3)));
            }
        }

        return dataVals;
    }
}