package timemasta.flagsquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import timemasta.timemasta.flagsquizapp.Common.CustomAdapter;
import timemasta.timemasta.flagsquizapp.DbHelper.DbHelper;
import timemasta.timemasta.flagsquizapp.Model.Ranking;
import dev.edmt.flagsquizapp.R;

public class Score extends AppCompatActivity {
    ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        lstView = (ListView)findViewById(R.id.lstRanking);
        DbHelper db = new DbHelper(this);
        List<Ranking> lstRanking = db.getRanking();
        if(lstRanking.size() > 0)
        {
            CustomAdapter adapter = new CustomAdapter(this,lstRanking);
            lstView.setAdapter(adapter);
        }
    }
}
