package com.example.test

import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.BroadcastReceiver
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Bluetoothアダプタ
val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

class BluetoothConnect {
    // BLEスキャン
    fun scan(): Int{
        if (!this.canUse()) {
            return -1
        }

        mBluetoothLeScanner = bluetoothAdapter?.bluetoothLeScanner  // BLEスキャナ
        mScanCallback = initCallbacks()     // コールバックの初期化

        println(mScanCallback.toString())
        println("mScanCallback")
        return 0
    }

    // BLEスキャン停止
    fun stop_scan(){
        mBluetoothLeScanner = bluetoothAdapter?.bluetoothLeScanner  // BLEスキャナ
        mBluetoothLeScanner?.stopScan(mScanCallback)
    }

    // Bluetoothのサポートをチェック
    private fun canUse(): Boolean{
        return bluetoothAdapter != null
    }

    // コールバックの初期化（BroadcastReceiverクラス）
    /*
    private fun initCallbacks(): BroadcastReceiver? {
        return object : BroadcastReceiver() {
            
        }
    }
    */

    // コールバックの初期化（scancallbackクラス）
    private fun initCallbacks(): ScanCallback? {
        return object : ScanCallback() {
            override fun onScanResult(
                callbackType: Int,
                result: ScanResult
            ) {
                super.onScanResult(callbackType, result)

                // デバイスが見つかった
                if (result != null && result.device != null) {
                    // リストに追加などなどの処理をおこなう
                    //addDevice(result.getDevice(), result.getRssi());
                    println(result.getDevice())
                    println(result.getRssi())
                }
                return
            }
        }
    }
}