package com.tutorials.hp.recyclerviewmysql.MySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.tutorials.hp.recyclerviewmysql.Recycler.MyAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Oclemmy on 3/29/2016 for ProgrammingWizards Channel.
 */
public class Parser extends AsyncTask<Void,Integer,Integer> {

    Context c;
    String data;
    RecyclerView rv;

    ProgressDialog pd;
    ArrayList<String> players=new ArrayList<>();
    MyAdapter adapter;

    public Parser(Context c, String data, RecyclerView rv) {
        this.c = c;
        this.data = data;
        this.rv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parse Data");
        pd.setMessage("Parsing...Please Wait!");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return this.parse();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        pd.dismiss();

        if(integer==1)
        {
            adapter=new MyAdapter(c,players);
            rv.setAdapter(adapter);
        }else {
            Toast.makeText(c,"Unable to parse data",Toast.LENGTH_SHORT).show();
        }
    }

    private int parse()
    {
        try
        {
            JSONArray ja=new JSONArray(data);
            JSONObject jo=null;

            players.clear();

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                String name=jo.getString("Name");
                players.add(name);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}















