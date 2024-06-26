package com.example.safetravel.domain

import com.example.safetravel.data.model.DeviceEntity
import com.example.safetravel.domain.model.Device

fun Device.toDeviceEntity(): DeviceEntity {
    return DeviceEntity(
        macAddress = this.macAddress,
        name = this.name,
        uuid = this.uuid,
        isVerified = this.isVerified,
        typeId = this.type.id
    )
}
