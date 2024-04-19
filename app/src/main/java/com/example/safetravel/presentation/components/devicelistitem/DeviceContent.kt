package com.example.safetravel.presentation.components.devicelistitem

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.safetravel.domain.model.Device
import com.example.safetravel.domain.model.LockStatus
import com.example.safetravel.presentation.model.DeviceType
import com.example.safetravel.presentation.theme.SafeTravelTheme
import java.util.UUID

@Composable
fun DeviceContent(
    device: Device,
    onLockStateClicked: () -> Unit,
    onCustomizeClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onRenameClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            modifier = Modifier.size(80.dp),
            painter = painterResource(device.type.drawableRes),
            contentDescription = null
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically)
        ) {
            Text(
                text = device.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 4.dp)
            )

            Text(
                text = device.macAddress,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 4.dp)
            )

            DeviceActionsRow(
                lockStatus = device.lockStatus,
                onLockStateClicked = onLockStateClicked,
                onCustomizeClick = onCustomizeClick,
                onDeleteClick = onDeleteClick,
                onRenameClick = onRenameClick
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DeviceContentPreview() {
    SafeTravelTheme {
        DeviceContent(
            device = Device(
                macAddress = UUID.randomUUID().toString(),
                name = "Backpack",
                lockStatus = LockStatus.LOCKED,
                uuid = UUID.randomUUID().toString(),
                isConnected = false,
                isVerified = false,
                isConnectionLoading = false,
                type = DeviceType.BACKPACK

            ),
            onLockStateClicked = {},
            onCustomizeClick = {},
            onDeleteClick = {},
            onRenameClick = {}
        )
    }
}
