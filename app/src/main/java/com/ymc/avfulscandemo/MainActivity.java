package com.ymc.avfulscandemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ymc.avfulscandemo.view.AntivirusFullScanBarView;
import com.ymc.avfulscandemo.view.RubbishRotationView;

public class MainActivity extends AppCompatActivity {
    /**
     * 小图标
     */
    private static final int[] f22479J = {R.drawable.ic_small_android, R.drawable.ic_small_book,
            R.drawable.ic_small_cache, R.drawable.ic_small_key, R.drawable.ic_small_more,
            R.drawable.ic_small_set, R.drawable.ic_small_tree, R.drawable.ic_small_usb};
    RubbishRotationView r1;
    RubbishRotationView r2;
    RubbishRotationView r3;
    AntivirusFullScanBarView sbv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1 = findViewById(R.id.rotation1);
        r2 = findViewById(R.id.rotation2);
        r3 = findViewById(R.id.rotation3);
        sbv = findViewById(R.id.fullsbv);
        r1.setRes(R.drawable.ic_antivirus_safe_rt, R.drawable.ic_antivirus_rt, getString(R.string.string_antivirus_vulnerability_risk));
        r2.setRes(R.drawable.ic_antivirus_safe_pp, R.drawable.ic_antivirus_pp, getString(R.string.string_antivirus_privacy_leak));
        r3.setRes(R.drawable.ic_antivirus_safe_vs, R.drawable.ic_antivirus_vs, getString(R.string.string_antivirus_virus_threat));
        r1.start();
        r2.start();
        r3.start();
        sbv.start();
    }
}