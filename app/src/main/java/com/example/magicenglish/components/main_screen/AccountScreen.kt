package com.example.magicenglish.components.main_screen

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberPermissionState

const val CAMERA_PERMISSION = Manifest.permission.CAMERA


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun cameraPermissionState(): PermissionState {
    return rememberPermissionState(permission = CAMERA_PERMISSION)
}

val placeHolderBitmap: Bitmap = BitmapFactory.decodeResource(
    Resources.getSystem(),
    android.R.drawable.ic_menu_camera
)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun AccountScreen() {
    var resultBitmap: Bitmap? by rememberSaveable { mutableStateOf(placeHolderBitmap) }

    val launcherForImageCapture = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) {
        resultBitmap = if (it.toString().isEmpty()) {
            placeHolderBitmap
        } else {
            it
        }
    }

    ScreenContentAccompanist(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        resultBitmap = resultBitmap,
        launcherForImageCapture = launcherForImageCapture
    )
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun ScreenContentAccompanist(
    modifier: Modifier,
    cameraPermission: PermissionState = cameraPermissionState(),
    resultBitmap: Bitmap?,
    launcherForImageCapture: ManagedActivityResultLauncher<Void?, Bitmap?>
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(20.dp)
    ) {
        Text(
            text = "Your profile!",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .clip(shape = CircleShape)
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = CircleShape
                )
        ) {
            resultBitmap?.asImageBitmap()?.let {
                Image(
                    bitmap = it,
                    contentDescription = "Captured image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .clickable {
                            if (cameraPermission.hasPermission) {
                                launcherForImageCapture.launch()
                            } else if (!cameraPermission.hasPermission) {
                                cameraPermission.launchPermissionRequest()
                            }
                        }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        ProfileOutlinedTextField(value = "Name")
        ProfileOutlinedTextField(value = "Email")
        ProfileOutlinedTextField(value = "Change password")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .padding(horizontal = 36.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun ProfileOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit = { }
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.padding(vertical = 10.dp),
        textStyle = TextStyle(color = Color.Gray)
    )
}