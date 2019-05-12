package com.websarva.wings.android.sounds;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.service.autofill.TextValueSanitizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

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

    private int totalTime;
    private TextView elapsedTimeLabel;
    private TextView remainingTimeLabel;
    private SeekBar positionBar;

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

        elapsedTimeLabel = findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = findViewById(R.id.remainingTimeLabel);


    }

    public void kpop(View view) {
        if (_player != null) {
            _player.stop();
            _btPlay.setText(R.string.bt_play_play);
        }
//        _player = new MediaPlayer();
//        String mediaFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.kpop_man_sample;
//
//        //音声ファイルのURI文字列を元にURIオブジェクトを生成。
//        Uri mediaFileUri = Uri.parse(mediaFileUriStr);
//        try {
//            //メディアプレーヤーに音声ファイルを指定。
//            _player.setDataSource(MainActivity.this, mediaFileUri);
//            //非同期でのメディア再生準備が完了した際のリスナを設定。
//            //_player.setOnPreparedListener(new PlayerPreparedListener());
//            //メディア再生が終了した際のリスナを設定。
//            _player.setOnCompletionListener(new PlayerCompletionListener());
//            //非同期でメディア再生を準備。
//            _player.prepareAsync();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        _player = MediaPlayer.create(this, R.raw.kpop_man_sample);

        _player.setLooping(true);
        _player.seekTo(0);
        totalTime = _player.getDuration();

        positionBar = findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser){
                            _player.seekTo(progress);
                            positionBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (_player != null) {
                    try {
                        Message msg = new Message();
                        msg.what =_player.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();

//        //スイッチを取得。
//        Switch loopSwitch = findViewById(R.id.swLoop);
//        //スイッチにリスナを設定。
//        loopSwitch.setOnCheckedChangeListener(new LoopSwitchChangedListener());

    }

    public void jpop(View view) {
        if (_player != null) {
            _player.stop();
            _btPlay.setText(R.string.bt_play_play);
        }
//        _player = new MediaPlayer();
//        String mediaFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.poprock_sample_man;
//
//        //音声ファイルのURI文字列を元にURIオブジェクトを生成。
//        Uri mediaFileUri = Uri.parse(mediaFileUriStr);
//        try {
//            //メディアプレーヤーに音声ファイルを指定。
//            _player.setDataSource(MainActivity.this, mediaFileUri);
//            //非同期でのメディア再生準備が完了した際のリスナを設定。
//            //_player.setOnPreparedListener(new PlayerPreparedListener());
//            //メディア再生が終了した際のリスナを設定。
//            _player.setOnCompletionListener(new PlayerCompletionListener());
//            //非同期でメディア再生を準備。
//            _player.prepareAsync();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        _player = MediaPlayer.create(this, R.raw.poprock_sample_man);

        _player.setLooping(true);
        _player.seekTo(0);
        totalTime = _player.getDuration();

        positionBar = findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser){
                            _player.seekTo(progress);
                            positionBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (_player != null) {
                    try {
                        Message msg = new Message();
                        msg.what =_player.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();

//        //スイッチを取得。
//        Switch loopSwitch = findViewById(R.id.swLoop);
//        //スイッチにリスナを設定。
//        loopSwitch.setOnCheckedChangeListener(new LoopSwitchChangedListener());

    }

    public void rb(View view) {
        if (_player != null) {
            _player.stop();
            _btPlay.setText(R.string.bt_play_play);
        }
//        _player = new MediaPlayer();
//        String mediaFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.rb_sample_man;
//
//        //音声ファイルのURI文字列を元にURIオブジェクトを生成。
//        Uri mediaFileUri = Uri.parse(mediaFileUriStr);
//        try {
//            //メディアプレーヤーに音声ファイルを指定。
//            _player.setDataSource(MainActivity.this, mediaFileUri);
//            //非同期でのメディア再生準備が完了した際のリスナを設定。
//            //_player.setOnPreparedListener(new PlayerPreparedListener());
//            //メディア再生が終了した際のリスナを設定。
//            _player.setOnCompletionListener(new PlayerCompletionListener());
//            //非同期でメディア再生を準備。
//            _player.prepareAsync();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //スイッチを取得。
//        Switch loopSwitch = findViewById(R.id.swLoop);
//        //スイッチにリスナを設定。
//        loopSwitch.setOnCheckedChangeListener(new LoopSwitchChangedListener());

        _player = MediaPlayer.create(this, R.raw.rb_sample_man);

        _player.setLooping(true);
        _player.seekTo(0);
        totalTime = _player.getDuration();

        positionBar = findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser){
                            _player.seekTo(progress);
                            positionBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (_player != null) {
                    try {
                        Message msg = new Message();
                        msg.what =_player.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();

    }

    public void yogaku(View view) {
        if (_player != null) {
            _player.stop();
            _btPlay.setText(R.string.bt_play_play);
            if(_player.isLooping()) {
                _player.setLooping(false);
            }
        }
//        _player = new MediaPlayer();
//        String mediaFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.yougaku_sample_man;
//
//        //音声ファイルのURI文字列を元にURIオブジェクトを生成。
//        Uri mediaFileUri = Uri.parse(mediaFileUriStr);
//        try {
//            //メディアプレーヤーに音声ファイルを指定。
//            _player.setDataSource(MainActivity.this, mediaFileUri);
//            //非同期でのメディア再生準備が完了した際のリスナを設定。
//            //_player.setOnPreparedListener(new PlayerPreparedListener());
//            //メディア再生が終了した際のリスナを設定。
//            _player.setOnCompletionListener(new PlayerCompletionListener());
//            //非同期でメディア再生を準備。
//            _player.prepareAsync();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //スイッチを取得。
//        Switch loopSwitch = findViewById(R.id.swLoop);
//        //スイッチにリスナを設定。
//        loopSwitch.setOnCheckedChangeListener(new LoopSwitchChangedListener());

        _player = MediaPlayer.create(this, R.raw.yougaku_sample_man);

        _player.setLooping(true);
        _player.seekTo(0);
        totalTime = _player.getDuration();

        positionBar = findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser){
                            _player.seekTo(progress);
                            positionBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (_player != null) {
                    try {
                        Message msg = new Message();
                        msg.what =_player.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();

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

//    private class PlayerCompletionListener implements MediaPlayer.OnCompletionListener {
//
//        @Override
//        public void onCompletion(MediaPlayer mp) {
//            //ループ設定がされていないならば…
//            if(!_player.isLooping()) {
//                //再生ボタンのラベルを「再生」に設定。
//                _btPlay.setText(R.string.bt_play_play);
//            }
//        }
//    }

//    private class LoopSwitchChangedListener implements CompoundButton.OnCheckedChangeListener {
//
//        @Override
//        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//            //ループするかどうかを設定。
//            _player.setLooping(isChecked);
//        }
//    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            int currentPosition = msg.what;

            positionBar.setProgress(currentPosition);

            String elapsedTime = createTimeLabel(currentPosition);
            elapsedTimeLabel.setText(elapsedTime);

            String remainingTime =  "- " + createTimeLabel(totalTime-currentPosition);
            remainingTimeLabel.setText(remainingTime);

            return true;
        }
    });

    public String createTimeLabel(int time){
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }
}