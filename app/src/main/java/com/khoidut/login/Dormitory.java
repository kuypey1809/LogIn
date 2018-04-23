package com.khoidut.login;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class Dormitory extends AppCompatActivity {
    MqttHelper mqttHelper;

    TextView dataReceived;

    public int percent;

//    public static int percent toUnsignedInt(byte x);

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ktx);

        dataReceived = (TextView) findViewById(R.id.dataReceived);


        startMqtt();
    }


    private void startMqtt() {
        mqttHelper = new MqttHelper(getApplicationContext());
        mqttHelper.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {

            }

            @Override
            public void connectionLost(Throwable throwable) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
//                Log.w("Debug", mqttMessage.toString());
                dataReceived.setText(mqttMessage.toString());

                String xxx= mqttMessage.toString();
//                System.out.println(xxx);
                int cailon;
                cailon = Integer.parseInt(xxx.trim());
                System.out.println(cailon);

                if (cailon <= 15){
                    ImageView changeColor = (ImageView) findViewById(R.id.imageView);
                    int red = Color.parseColor("#FF00FF40");
                    changeColor.setColorFilter(red);
                }

                if (cailon >= 16 && cailon <=20){
                    ImageView changeColor = (ImageView) findViewById(R.id.imageView);
                    int blue = Color.parseColor("#FFFFF700");
                    changeColor.setColorFilter(blue);
                }

                if (cailon >= 20 && cailon <=100){
                    ImageView changeColor = (ImageView) findViewById(R.id.imageView);
                    int red = Color.parseColor("#FFFF0000");
                    changeColor.setColorFilter(red);
                }

            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

            }
        });
    }


}
