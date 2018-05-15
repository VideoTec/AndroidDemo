package work.wangxiang.androiddemo;
import android.content.Context;
import android.content.Intent;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.alimuzaffar.lib.pin.PinEntryEditText;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import work.wangxiang.android.common.App;
import work.wangxiang.android.common.Utils;
import work.wangxiang.livetv.view.LiveTvActivity;
import work.wangxiang.localvideo.view.VideoListActivity;
import work.wangxiang.test.recyclerview.ActivityFragmentTest;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    PinEntryEditText pinEntryEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pinEntryEditText = findViewById(R.id.pinEntryEditText);
        //pinEntryEditText.setFocusable(true);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        //udpListener.start();
    }

    public void onLoadLocalVideo(View view) {
        //VideoListActivity.openVideoList(this);
        pinEntryEditText.requestFocus();
        App.getCtx().showSoftKeyboard(pinEntryEditText);
    }

    public void onRecyclerViewTest(View view) {
        startActivity(new Intent(this, ActivityFragmentTest.class));
    }

    public void onLoadLiveTv(View view) {
        //startActivity(new Intent(this, LiveTvActivity.class));
        App.getCtx().hideSoftKeyboard(pinEntryEditText);
    }

    public void onStartBroadcast(View view) {
        findViewById(R.id.start_broadcast).setEnabled(false);

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    DatagramSocket socket = new DatagramSocket();
                    socket.setBroadcast(true);
                    InetAddress address = getBroadcastAddress();
                    DatagramPacket pkt = new DatagramPacket(TAG.getBytes(), TAG.length(), address, 1983);
                    while (true) {
                        socket.send(pkt);
                        sleep(1000);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "broadcast stopped", e);
                    runOnUiThread(() -> findViewById(R.id.start_broadcast).setEnabled(true));
                }
            }
        }.start();
    }

    private InetAddress getBroadcastAddress() throws IOException {
        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        DhcpInfo dhcp = wifi.getDhcpInfo(); // handle null somehow

        int broadcast = (dhcp.ipAddress & dhcp.netmask) | ~dhcp.netmask;
        byte[] quads = new byte[4];
        for (int k = 0; k < 4; k++)
            quads[k] = (byte) ((broadcast >> k * 8) & 0xFF);
        return InetAddress.getByAddress(quads);
    }

    private Thread udpListener = new Thread() {
        @Override
        public void run() {
            super.run();
            try {
                byte[] data = new byte[1024];
                DatagramSocket udpSocket = new DatagramSocket(1983);
                DatagramPacket pkt = new DatagramPacket(data, data.length);
                //while(true) {
                    udpSocket.receive(pkt);
                    udpSocket.send(pkt);
                    Log.i(TAG, "address: " + pkt.getAddress() + "; port: " + pkt.getPort() + "; socket address: " + pkt.getSocketAddress());
                //}
            } catch (Exception e) {
                Log.e(TAG, "udp listener stopped", e);
            }
            runOnUiThread(() -> findViewById(R.id.listen_1983).setEnabled(true));
        }
    };

    public void onListen1983(View view) {
        findViewById(R.id.listen_1983).setEnabled(false);
        new Thread() {
            @Override
            public void run() {
                super.run();
                DatagramSocket udpSocket = null;
                try {
                    byte[] data = new byte[1024];
                    udpSocket = new DatagramSocket(1983);
                    DatagramPacket pkt = new DatagramPacket(data, data.length);
                    //while(true) {
                    udpSocket.receive(pkt);
                    udpSocket.send(pkt);
                    Log.i(TAG, "address: " + pkt.getAddress() + "; port: " + pkt.getPort() + "; socket address: " + pkt.getSocketAddress());
                    //}
                } catch (Exception e) {
                    Log.e(TAG, "udp listener stopped", e);
                } finally {
                    if (udpSocket != null) {
                        udpSocket.close();
                    }
                }
                runOnUiThread(() -> findViewById(R.id.listen_1983).setEnabled(true));
            }
        }.start();
    }
}
