package com.example.rn.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.rn.R;

/**
 * Created by andrie on 19/05/15.
 */
public class MinumanFragment extends Fragment {

    //deklarasi
    protected ListView lv2;
    protected ListAdapter adapter;
    SQLiteDatabase db;
    Cursor cursor;
    EditText et_db;

    public MinumanFragment() {
        // Required empty public constructor
    }

//    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




    public void detail(int position) {
        int im = 0;
        String _id = "";
        String nama = "";
        String bahan = "";
        String cara = "";
        if (cursor.moveToFirst()) {
            cursor.moveToPosition(position);
            im = cursor.getInt(cursor.getColumnIndex("img"));
            nama = cursor.getString(cursor.getColumnIndex("nama"));
            bahan = cursor.getString(cursor.getColumnIndex("bahan"));
            cara = cursor.getString(cursor.getColumnIndex("cara"));
        }

        Intent iIntent = new Intent(getActivity(), DB_Parse.class);
        iIntent.putExtra("dataIM", im);
        iIntent.putExtra("dataNama", nama);
        iIntent.putExtra("dataBahan", bahan);
        iIntent.putExtra("dataCara", cara);
        getActivity().setResult(Activity.RESULT_OK,iIntent);

        startActivityForResult(iIntent, 99);

    }

//    @SuppressWarnings("deprecation")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_minuman, container, false);

        db = (new DB_Resep(getActivity())).getWritableDatabase();
        lv2 = (ListView)rootView.findViewById(R.id.lv2);
        et_db = (EditText)rootView.findViewById(R.id.et2);

        Button btnsearch = (Button)rootView.findViewById(R.id.btn2);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit_db = et_db.getText().toString();
                if (!edit_db.equals("")) {
                    try {
                        cursor = db.rawQuery("SELECT * FROM resepminuman WHERE nama LIKE ?",
                                new String[]{"%" + edit_db + "%"});
                        adapter = new SimpleCursorAdapter(
                                getActivity(),
                                R.layout.isi_lv,
                                cursor,
                                new String[]{"nama", "bahan", "img"},
                                new int[]{R.id.tv_nama, R.id.tvBahan,
                                        R.id.imV});

                        if (adapter.getCount() == 0) {
                            Toast.makeText(
                                    getActivity(),
                                    "Tidak ditemukan data dengan kata kunci " + edit_db
                                            + "", Toast.LENGTH_SHORT).show();
                        } else {
                            lv2.setAdapter(adapter);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        cursor = db.rawQuery("SELECT * FROM resepminuman ORDER BY nama ASC",
                                null);

                        adapter = new SimpleCursorAdapter(
                                getActivity(),
                                R.layout.isi_lv,
                                cursor,
                                new String[]{"nama", "bahan", "img"},
                                new int[]{R.id.tv_nama, R.id.tvBahan, R.id.imV});

                        lv2.setAdapter(adapter);
                        lv2.setTextFilterEnabled(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });


        try {
            //select dari database resep, menampilkan nya
            // secara urut sesuai abjad
            cursor = db.rawQuery("SELECT * FROM resepminuman ORDER BY nama ASC",
                    null);

            adapter = new SimpleCursorAdapter(getActivity(), R.layout.isi_lv, cursor,
                    new String[] { "nama", "bahan", "img" }, new int[] {
                    R.id.tv_nama, R.id.tvBahan, R.id.imV });
            lv2.setAdapter(adapter);
            lv2.setTextFilterEnabled(true);

            lv2.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    detail(position);


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Inflate the layout for this fragment

//        return inflater.inflate(R.layout.fragment_minuman, container, false);
        return rootView;

    }

}
