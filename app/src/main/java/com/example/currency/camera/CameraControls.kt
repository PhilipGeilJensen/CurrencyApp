package com.example.currency.camera

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material.icons.sharp.Phone
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.currency.R

/**
 * The UI that shows the different CameraControls - Flip, Take Image, Open Gallery
 * @param cameraUIAction Callback for the Camera UI Action
 * @see com.example.currency.camera.CameraControl
 */
@Composable
fun CameraControls(cameraUIAction: (CameraUIAction) -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        CameraControl(
            R.drawable.cameraswitch_fill1_wght400_grad0_opsz48,
            "Flip camera",
            modifier= Modifier.size(48.dp),
            onClick = { cameraUIAction(CameraUIAction.OnSwitchCameraClick) }
        )

        CameraControl(
            R.drawable.lens_fill1_wght400_grad0_opsz48,
            "Take picture",
            modifier= Modifier
                .size(64.dp)
                .padding(1.dp)
                .border(1.dp, Color.White, CircleShape),
            onClick = { cameraUIAction(CameraUIAction.OnCameraClick) }
        )

        CameraControl(
            R.drawable.photo_library_fill1_wght400_grad0_opsz48,
            "Open gallery",
            modifier= Modifier.size(48.dp),
            onClick = { cameraUIAction(CameraUIAction.OnGalleryViewClick) }
        )

    }
}

/**
 * UI Control for a camera control button.
 * @param imageVector The icon to show
 * @param contentDesc Content description
 * @param modifier Modifiers for the component
 * @param onClick Callback for when the component is clicked.
 */
@Composable
fun CameraControl(
    imageVector: Int,
    contentDesc: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {


    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            painterResource(id = imageVector),
            contentDescription = contentDesc,
            modifier = modifier,
            tint = Color.White
        )
    }

}