package com.example.safetravel.presentation.components.devicelistitem

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.safetravel.R
import com.example.safetravel.presentation.theme.SafeTravelTheme

@Composable
fun DeviceActionsRow(
    isLocked: Boolean,
    onUnlockClick: () -> Unit,
    onNfcClick: () -> Unit,
    onCustomizeClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onRenameClick: () -> Unit,
) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        FilledTonalIconToggleButton(
            checked = isLocked,
            shape = MaterialTheme.shapes.small,
            onCheckedChange = {
                if (isLocked) {
                    onUnlockClick()
                }
            }
        ) {
            Icon(
                painter = if (isLocked) {
                    painterResource(R.drawable.ic_locked)
                } else {
                    painterResource(R.drawable.ic_unlocked)
                },
                contentDescription = null,
            )
        }

        FilledTonalIconButton(
            onClick = onNfcClick,
            shape = MaterialTheme.shapes.small
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_nfc),
                contentDescription = null,
            )
        }

        FilledTonalIconButton(
            onClick = onCustomizeClick,
            shape = MaterialTheme.shapes.small
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_customize),
                contentDescription = null,
            )
        }

        FilledTonalIconButton(
            onClick = onRenameClick,
            shape = MaterialTheme.shapes.small
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_rename),
                contentDescription = null,
            )
        }

        FilledTonalIconButton(
            onClick = onDeleteClick,
            shape = MaterialTheme.shapes.small
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_delete),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DeviceActionsRowPreview() {
    SafeTravelTheme {
        DeviceActionsRow(
            isLocked = true,
            onUnlockClick = {},
            onNfcClick = {},
            onCustomizeClick = {},
            onDeleteClick = {},
            onRenameClick = {}
        )
    }
}
