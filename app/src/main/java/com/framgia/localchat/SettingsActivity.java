package com.framgia.localchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SettingsActivity extends AppCompatActivity {

    private LinearLayout mLinearRowContainer;
    private Menu mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mLinearRowContainer = (LinearLayout) findViewById(R.id.linear_row_container);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void inflateRow(int position) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.settings_row, null);
        final EditText etName = (EditText) rowView.findViewById(R.id.et_name);
        etName.setVisibility(View.VISIBLE);
        mLinearRowContainer.addView(rowView, mLinearRowContainer.getChildCount() - 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        mMenu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                MenuItem itemEdit = mMenu.findItem(R.id.action_edit);
                if (itemEdit.getTitle().equals(getString(R.string.action_edit))) {
                    itemEdit.setTitle(getString(R.string.action_save));
                    inflateRow(0);
                } else {
                    itemEdit.setTitle(getString(R.string.action_edit));
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
