package com.example.safetravel.domain

import com.example.safetravel.data.model.DeviceEntity
import com.example.safetravel.domain.model.Device

fun DeviceEntity.toDevice(): Device {
    return Device(
        macAddress = this.macAddress,
        name = this.name,
        isLocked = this.isLocked,
        uuid = this.uuid
    )
}