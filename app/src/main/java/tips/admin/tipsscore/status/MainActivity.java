package tips.admin.tipsscore.status;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<tips> arrayList;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        arrayList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list_tips);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("http://172.19.152.113/tipscoreJSON/dailytips.php");
            }
        });
    }

    class ReadJSON extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            try {
                JSONObject jsonObject = new JSONObject(content);
                JSONArray jsonArray =  jsonObject.getJSONArray("data");

                for(int i =0;i<jsonArray.length(); i++){
                    JSONObject tipsObj = jsonArray.getJSONObject(i);
                    arrayList.add(new tips (
                            ("") + tipsObj.getString ( "status" ),

                            ("") + tipsObj.getString ( "Time" ) ,
                            ("") + tipsObj.getString ( "league" ) ,

                            ("") + tipsObj.getString ( "Match" ) ,
                            ("Tip:") + tipsObj.getString ( "Tips" ) ,
                            ("Odd:") + tipsObj.getString ( "Odds" ) ,
                            ("Results:") + tipsObj.getString ( "Results" )

                    ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            TipsAdapter adapter = new TipsAdapter(
                    getApplicationContext(), R.layout.listtips, arrayList
            );
            lv.setAdapter(adapter);
        }
    }


    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader (urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}