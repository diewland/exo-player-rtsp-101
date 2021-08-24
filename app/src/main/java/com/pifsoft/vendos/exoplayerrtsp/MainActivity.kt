package com.pifsoft.vendos.exoplayerrtsp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource
import com.google.android.exoplayer2.ui.PlayerView


class MainActivity : AppCompatActivity() {

    lateinit var player: SimpleExoPlayer

    val rtspUri = "rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mediaSource = RtspMediaSource.Factory()
            .createMediaSource(MediaItem.fromUri(rtspUri))

        // init player
        player = SimpleExoPlayer.Builder(this).build()
        player.setMediaSource(mediaSource)
        // player.setMediaItem(MediaItem.fromUri(rtspUri))
        player.prepare()
        player.playWhenReady = true

        // init player view
        val playerView = findViewById<PlayerView>(R.id.player_view)
        playerView.player = player
    }
}