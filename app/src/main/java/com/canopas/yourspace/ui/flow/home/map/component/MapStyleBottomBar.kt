package com.canopas.yourspace.ui.flow.home.map.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.canopas.yourspace.R
import com.canopas.yourspace.ui.theme.AppTheme

@Composable
fun MapStyleBottomSheet(onClose: () -> Unit, onStyleSelected: (String) -> Unit) {
    var isDisable by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(
                color = AppTheme.colorScheme.surface,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(R.string.map_bottom_bar_title),
                style = AppTheme.appTypography.header3,
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
            IconButton(onClick = onClose) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close"
                )
            }
        }

        val styles = listOf(
            stringResource(R.string.map_style_app_theme),
            stringResource(R.string.map_style_terrain),
            stringResource(R.string.map_style_satellite)
        )
        val stylesIcons = listOf(
            R.drawable.ic_map_app_theme,
            R.drawable.ic_map_terrain,
            R.drawable.ic_map_satellite
        )
        Row(
            modifier = Modifier.padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            styles.forEach { style ->
                Card(
                    colors = CardDefaults.cardColors(AppTheme.colorScheme.surface),
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                        .clickable {
                            isDisable = !isDisable
                            onStyleSelected(style)
                        },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Image(
                        painter = painterResource(stylesIcons[styles.indexOf(style)]),
                        contentDescription = style
                    )
                    Text(
                        text = style,
                        style = AppTheme.appTypography.body1.copy(color = AppTheme.colorScheme.textPrimary),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
