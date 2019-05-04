package com.websarva.wings.android.sounds;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer _player;

    private Button _btKpop;
    private Button _btJpop;
    private Button _btRb;
    private Button _btYogaku;

    private Button _btPlay;
    private Button _btBack;
    private Button _btForward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _btKpop = findViewById(R.id.btKpop);
        _btJpop = findViewById(R.id.btJpop);
        _btRb = findViewById(R.id.btRb);
        _btYogaku = findViewById(R.id.btYogaku);

        _btPlay = findViewById(R.id.btPlay);
        _btBack = findViewById(R.id.btBack);
        _btForward = findViewById(R.id.btForward);

        _btKpop.setEnabled(true);
        _btJpop.setEnabled(true);
        _btRb.setEnabled(true);
        _btYogaku.setEnabled(true);

        _btPlay.setEnabled(true);
        _btBack.setEnabled(true);
        _btForward.setEnabled(true);

        _player = new MediaPlayer();


    }

    public void kpop(View view) {
        if (_player != null) {
            _player.stop();
            _btPlay.setText(R.string.bt_play_play);
        }
        _player = new MediaPlayer();
        String mediaFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.kpop_man_sample;

        //音声ファイルのURI文字列を元にURIオブジェクトを生成。
        Uri mediaFileUri = Uri.parse(mediaFileUriStr);
        try {
            //メディアプレーヤーに音声ファイルを指定。
            _player.setDataSource(MainActivity.this, mediaFileUri);
            //非同期でのメディア再生準備が完了した際のリスナを設定。
            //_player.setOnPreparedListener(new PlayerPreparedListener());
            //メディア再生が終了した際のリスナを設定。
            _player.setOnCompletionListener(new PlayerCompletionListener());
            //非同期でメディア再生を準備。
            _player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //スイッチを取得。
        Switch loopSwitch = findViewById(R.id.swLoop);
        //スイッチにリスナを設定。
        loopSwitch.setOnCheckedChangeListener(new LoopSwitchChangedListener());

    }

    public void jpop(View view) {
        if (_player != null) {
            _player.stop();
            _btPlay.setText(R.string.bt_play_play);
        }
        _player = new MediaPlayer();
        String mediaFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.poprock_sample_man;

        //音声ファイルのURI文字列を元にURIオブジェクトを生成。
        Uri mediaFileUri = Uri.parse(mediaFileUriStr);
        try {
            //メディアプレーヤーに音声ファイルを指定。
            _player.setDataSource(MainActivity.this, mediaFileUri);
            //非同期でのメディア再生準備が完了した際のリスナを設定。
            //_player.setOnPreparedListener(new PlayerPreparedListener());
            //メディア再生が終了した際のリスナを設定。
            _player.setOnCompletionListener(new PlayerCompletionListener());
            //非同期でメディア再生を準備。
            _player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //スイッチを取得。
        Switch loopSwitch = findViewById(R.id.swLoop);
        //スイッチにリスナを設定。
        loopSwitch.setOnCheckedChangeListener(new LoopSwitchChangedListener());

    }

    public void rb(View view) {
        if (_player != null) {
            _player.stop();
            _btPlay.setText(R.string.bt_play_play);
        }
        _player = new MediaPlayer();
        String mediaFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.rb_sample_man;

        //音声ファイルのURI文字列を元にURIオブジェクトを生成。
        Uri mediaFileUri = Uri.parse(mediaFileUriStr);
        try {
            //メディアプレーヤーに音声ファイルを指定。
            _player.setDataSource(MainActivity.this, mediaFileUri);
            //非同期でのメディア再生準備が完了した際のリスナを設定。
            //_player.setOnPreparedListener(new PlayerPreparedListener());
            //メディア再生が終了した際のリスナを設定。
            _player.setOnCompletionListener(new PlayerCompletionListener());
            //非同期でメディア再生を準備。
            _player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //スイッチを取得。
        Switch loopSwitch = findViewById(R.id.swLoop);
        //スイッチにリスナを設定。
        loopSwitch.setOnCheckedChangeListener(new LoopSwitchChangedListener());

    }

    public void yogaku(View view) {
        if (_player != null) {
            _player.stop();
            _btPlay.setText(R.string.bt_play_play);
        }
        _player = new MediaPlayer();
        String mediaFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.yougaku_sample_man;

        //音声ファイルのURI文字列を元にURIオブジェクトを生成。
        Uri mediaFileUri = Uri.parse(mediaFileUriStr);
        try {
            //メディアプレーヤーに音声ファイルを指定。
            _player.setDataSource(MainActivity.this, mediaFileUri);
            //非同期でのメディア再生準備が完了した際のリスナを設定。
            //_player.setOnPreparedListener(new PlayerPreparedListener());
            //メディア再生が終了した際のリスナを設定。
            _player.setOnCompletionListener(new PlayerCompletionListener());
            //非同期でメディア再生を準備。
            _player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //スイッチを取得。
        Switch loopSwitch = findViewById(R.id.swLoop);
        //スイッチにリスナを設定。
        loopSwitch.setOnCheckedChangeListener(new LoopSwitchChangedListener());

    }

    @Override
    protected void onDestroy() {
        //親クラスのメソッド呼び出し。
        super.onDestroy();
        //プレーヤーが再生中なら…
        if (_player.isPlaying()) {
            //プレーヤーを停止。
            _player.stop();
        }
        //プレーヤーを解放。
        _player.release();
        //プレーヤー用フィールドをnullに。
        _player = null;
    }

    public void onPlayButtonClick(View view) {
        //プレーヤーが再生中だったら…
        if (_player.isPlaying()) {
            //プレーヤーを一時停止。
            _player.pause();
            //再生ボタンのラベルを「再生」に設定。
            _btPlay.setText(R.string.bt_play_play);
        }
        //プレーヤーが再生中じゃなかったら…
        else {
            //プレーヤーを再生。
            _player.start();
            //再生ボタンのラベルを「一時停止」に設定。
            _btPlay.setText(R.string.bt_play_pause);
        }
    }

    public void onBackButtonClick(View view) {
        //再生位置を先頭に変更。
        _player.seekTo(0);
    }

    public void onForwardButtonClick(View view) {
        //現在再生中のメディファイルの長さを取得。
        int duration = _player.getDuration();
        //再生位置を終端に変更。
        _player.seekTo(duration);
        //再生中でないなら…
        if(!_player.isPlaying()) {
            //再生を開始。
            _player.start();
        }
    }

//    private class PlayerPreparedListener implements MediaPlayer.OnPreparedListener {
//
//        @Override
//        public void onPrepared(MediaPlayer mp) {
//            //各ボタンをタップ可能に設定。
//            _btKpop.setEnabled(true);
//            _btJpop.setEnabled(true);
//            _btRb.setEnabled(true);
//            _btYogaku.setEnabled(true);
//
//            _btPlay.setEnabled(true);
//            _btBack.setEnabled(true);
//            _btForward.setEnabled(true);
//        }
//    }

    private class PlayerCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            //ループ設定がされていないならば…
            if(!_player.isLooping()) {
                //再生ボタンのラベルを「再生」に設定。
                _btPlay.setText(R.string.bt_play_play);
            }
        }
    }

    private class LoopSwitchChangedListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            //ループするかどうかを設定。
            _player.setLooping(isChecked);
        }
    }
}