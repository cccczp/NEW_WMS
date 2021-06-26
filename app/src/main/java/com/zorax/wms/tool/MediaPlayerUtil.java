package com.zorax.wms.tool;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

import com.zorax.wms.R;

/**
 * @创作者 czp
 * @创作时间 2021/3/23 14:54
 * @描述
 */
public class MediaPlayerUtil {

    private  Context mContext;

    public MediaPlayerUtil(Context context) {
        mContext = context;
    }

    public void start() {
        MediaPlayer mediaPlayer = new MediaPlayer();//这个我定义了一个成员函数

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        MediaPlayer finalMediaPlayer = mediaPlayer;
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
              finalMediaPlayer.seekTo(0);
            }
        });
        AssetFileDescriptor file = mContext.getResources().openRawResourceFd(R.raw.beep);
        try{
            mediaPlayer.setDataSource(file.getFileDescriptor(),file.getStartOffset(),file.getLength());
            file.close();
            mediaPlayer.setVolume(0.0f,1.0f);
            mediaPlayer.prepare();
        }catch (Exception e){
            Log.w("",e);
            mediaPlayer = null;
        }

        mediaPlayer.start();
        finalMediaPlayer.start();
    }

}
