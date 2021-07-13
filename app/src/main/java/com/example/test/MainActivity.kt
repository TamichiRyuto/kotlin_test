package com.example.test

//import BluetoothConnect
import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


var mBluetoothLeScanner: BluetoothLeScanner? = null
var mScanCallback: ScanCallback? = null

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            // BLEコネクタのインスタンスを生成
            var connecter: BluetoothConnect = BluetoothConnect()

            // スキャンの開始
            Toast.makeText(this, "接続中", Toast.LENGTH_LONG).show()
            if(connecter.scan() == -1) {
                Toast.makeText(this, "BLE未対応", Toast.LENGTH_LONG).show()
            }

        }
    }
}