package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatNewNode extends AppCompatActivity {

    EditText edTitle, edDes;
    TextView tvTime, tvDate, tvChoseTags, tvChoseWeeks;
    Spinner spChoseType;
    Button btnTune;
    ArrayList<String> typeJobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_new_node);
        setTitle("Creat New Node");

        edTitle = findViewById(R.id.edTitle);
        edDes = findViewById(R.id.edDes);
        tvTime = findViewById(R.id.tvTime);
        tvDate = findViewById(R.id.tvDate);
        tvChoseTags = findViewById(R.id.tvChoseTags);
        tvChoseWeeks = findViewById(R.id.tvChoseWeeks);
        spChoseType = findViewById(R.id.spChose);
        btnTune = findViewById(R.id.btnTune);

        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(CreatNewNode.this)
                        .setTitle("Time Picker Dialog")
                        .create();
                alertDialog.show();
            }
        });
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(CreatNewNode.this)
                        .setTitle("Date Picker Dialog")
                        .create();
                alertDialog.show();
            }
        });

        typeJobs = new ArrayList<>();
        typeJobs.add("Work");
        typeJobs.add("Friend");
        typeJobs.add("Family");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, typeJobs);
        spChoseType.setAdapter(arrayAdapter);

        tvChoseTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] tags = {"Family", "Game", "Android", "Friend", "VTC"};
                final List<String> tagsList = Arrays.asList(tags);
                final boolean[] ischeck = {false, false, false, false, false};

                AlertDialog alertDialog = new AlertDialog.Builder(CreatNewNode.this)
                        .setTitle("Chose Tags")
                        .setMultiChoiceItems(tags, ischeck, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                ischeck[i] = b;
                            }
                        })
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvChoseTags.setText("");
                                for (int j = 0; j < ischeck.length; j++) {
                                    boolean checked = ischeck[j];
                                    if (checked) {
                                        tvChoseTags.setText(tvChoseTags.getText() + tagsList.get(j) + ",");
                                    }
                                }
                                tvChoseTags.setText(tvChoseTags.getText().toString().substring(0,tvChoseTags.getText().length()-1));
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        });
        tvChoseWeeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
                final List<String> weeksList = Arrays.asList(weeks);
                final boolean[] ischeck = {false, false, false, false, false, false, false};

                AlertDialog alertDialog = new AlertDialog.Builder(CreatNewNode.this)
                        .setTitle("Chose Weeks")
                        .setMultiChoiceItems(weeks, ischeck, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                ischeck[i] = b;
                                String items = weeksList.get(i);
                            }
                        })
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvChoseWeeks.setText("");
                                for (int j = 0; j < ischeck.length; j++) {
                                    boolean checked = ischeck[j];
                                    if (checked) {
                                        tvChoseWeeks.setText(tvChoseWeeks.getText() + weeksList.get(j) + ",");
                                    }
                                }
                                tvChoseWeeks.setText(tvChoseWeeks.getText().toString().substring(0,tvChoseWeeks.getText().length()-1));
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        });
        btnTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_tune, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.mnItemFiles:
                                break;
                            case R.id.mnItemDefault:
                                String[] tunes = {"Nexus Tune", "Window Tune", "Peep Tune", "Nokia Tune", "Etc"};
                                AlertDialog alertDialog = new AlertDialog.Builder(CreatNewNode.this)
                                        .setTitle("Set Tune")
                                        .setSingleChoiceItems(tunes, 1, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        })
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(getBaseContext(), "OK", Toast.LENGTH_LONG).show();
                                            }
                                        })
                                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_LONG).show();
                                            }
                                        })
                                        .create();
                                alertDialog.show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_popup, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(CreatNewNode.this, MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
