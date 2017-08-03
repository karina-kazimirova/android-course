package com.example.classwork5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.R;

/**
 * Created by Sve on 02.08.2017.
 */

public class CLW5Activity extends Activity {

    //private  MyBroadcastReceiver receiver = new MyBroadcastReceiver();

    private TextView textView;
    private int i = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork5);

        Intent intent = new Intent(CLW5Activity.this, MyIntentService.class);
        intent.putExtra(MyIntentService.KEY_ACTION, "Задание 0");
        startService(intent);

        Intent intent2 = new Intent(CLW5Activity.this, MyIntentService.class);
        intent2.putExtra(MyIntentService.KEY_ACTION, "Задание 1");
        startService(intent2);

        Intent intent3 = new Intent(CLW5Activity.this, MyIntentService.class);
        intent3.putExtra(MyIntentService.KEY_ACTION, "Задание 2");
        startService(intent3);


        textView = (TextView) findViewById(R.id.textView);

        // Запускаем Service. Будет работать пока не сработает stopService()
       // startService(new Intent(this, MyService.class));

        // Отсанавливаем  Service
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(CLW5Activity.this, MyService.class);
               // stopService(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        // Сообщения будем получать только при открытии определенной активити
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(MyIntentService.MY_ACTION);
        registerReceiver(receiver, intentFilter);


        Intent intent = new Intent(CLW5Activity.this, MyService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // отписались при закрытии активити
        unregisterReceiver(receiver);
        unbindService(serviceConnection);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("CCC", "onServiceConnection()");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("CCC", "onServiceDisconnected()");
        }
    };

    //
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("AAA", "onReceiver");
            i++;
            textView.setText("i=" + i);



        }
    };
}
