package com.vancoding.recyclerviewcompose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composerecyclerview.model.TvShow

class TvShowInfoActivity : ComponentActivity() {
    companion object {
        private const val TvShowId = "tvshowid"
        fun intent(context: Context, tvShow: TvShow)=
            Intent(context, TvShowInfoActivity::class.java).apply {
                putExtra(TvShowId, tvShow)
            }
    }

    private val tvShow : TvShow by lazy {
        intent?.getSerializableExtra(TvShowId) as TvShow
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewMoreInfo(tvShow = tvShow)
        }
    }
}

@Composable
fun ViewMoreInfo(tvShow: TvShow){
    val scrollState = rememberScrollState()
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = tvShow.imageId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Fit)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = tvShow.name,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = tvShow.overview,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Original release : ${tvShow.year}",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "IMDB : ${tvShow.rating}",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}
