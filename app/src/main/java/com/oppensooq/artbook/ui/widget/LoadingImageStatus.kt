package com.oppensooq.artbook.ui.widget

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.oppensooq.artbook.R
import com.oppensooq.artbook.ui.state.LoadingImageStatus

@Composable
fun LoadingImageStatus(status: LoadingImageStatus) {
    Icon(
        if (status == LoadingImageStatus.Error) painterResource(id = R.drawable.ic_error) else painterResource(
            id = R.drawable.icon_placeholder
        ),
        contentDescription = "clear"
    )
}

@Preview(showBackground = true)
@Composable
fun LoadingImageStatusPreview() {
    LoadingImageStatus(LoadingImageStatus.Error)
}
