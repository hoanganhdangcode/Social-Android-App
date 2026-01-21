package com.hoanganhdangcode.meetdrop

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var appnamecompose = findViewById<ComposeView>(R.id.appname);
        appnamecompose.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    AppnameCompose(
                    )
                }
            }
        }
        var loadingindicator = findViewById<ComposeView>(R.id.loadingindicator);
        loadingindicator.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    LoadingCompose(
                    )
                }
            }
        }

    }
    @Composable
    fun AppnameCompose() {
            Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(modifier = Modifier.fillMaxWidth(), color =  Color(37,150,190,255),text = "MeetDrop", fontWeight = FontWeight.Bold,
                fontSize = 30.sp, fontFamily = FontFamily.Default, textAlign = TextAlign.Center )
        }
    }
    @Composable
    fun LoadingCompose() {
        Column(modifier = Modifier.fillMaxWidth()) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth().height(8.dp).padding(horizontal = 40.dp, vertical = 0.dp), trackColor = Color(37,150,190,50), color = Color(37,150,190,255), strokeCap = ProgressIndicatorDefaults.LinearStrokeCap)
            Spacer(modifier = Modifier.height(20.dp))

        }



    }




}