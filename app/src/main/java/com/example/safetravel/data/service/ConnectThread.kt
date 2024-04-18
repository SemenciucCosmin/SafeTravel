package com.example.safetravel.data.service

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.util.Log
import com.example.safetravel.domain.model.SocketType
import java.io.IOException
import java.util.UUID

class ConnectThread(
    private val device: BluetoothDevice,
    private val socketType: SocketType,
    private val listener: ConnectThreadListener
) : Thread() {
    private lateinit var socket: BluetoothSocket

    @SuppressLint("MissingPermission")
    override fun run() {
        listener.runWithBluetoothPermission {
            try {
                val uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
                socket = when (socketType) {
                    SocketType.SECURE -> device.createRfcommSocketToServiceRecord(uuid)
                    SocketType.INSECURE -> device.createInsecureRfcommSocketToServiceRecord(uuid)
                }

                Log.i(TAG, "Socket: $socketType created")
                setName("ConnectThread $socketType")

                try {
                    socket.connect()
                    listener.onConnected(socket, device, socketType)
                    Log.i(TAG, "Socket: $socketType connection successful")
                } catch (connectException: IOException) {
                    listener.onConnectionFailed(device)
                    Log.e(TAG, "Failed to connect socket: $socketType", connectException)
                }

            } catch (socketException: Exception) {
                Log.e(TAG, "Failed to create socket: $socketType", socketException)
            }
        }
    }

    fun closeSocket() {
        try {
            socket.close()
            Log.i(TAG, "Closed Socket: $socketType")
        } catch (closeException: IOException) {
            Log.e(TAG, "Failed to close socket: $socketType", closeException)
        }
    }

    companion object {
        private const val TAG = "ConnectThread"
    }
}
