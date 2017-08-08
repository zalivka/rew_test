package rew.zalivka.rew;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import net.gree.reward.sdk.GreeAdsReward;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("zalivka://whatever"));
                startActivity(i);
            }
        });

        GreeAdsReward.setAppInfo("19324","ad1f6c78ee0b746ea3442ab233a7d105", false);

        String callbackURL = getIntent().getDataString();
        if (!TextUtils.isEmpty(callbackURL)) {
            GreeAdsReward.sendAction(this, "17067", "install", callbackURL, genNewId());
            Log.d("GreeAdsReward", "sendAction : " + callbackURL);
            Toast.makeText(this, "GreeAdsReward " + "sendAction : " + callbackURL, Toast.LENGTH_SHORT).show();
        }
    }

    private static String genNewId() {
        return UUID.randomUUID().toString();
    }
}
