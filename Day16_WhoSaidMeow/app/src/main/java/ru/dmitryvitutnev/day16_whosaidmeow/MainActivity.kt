package ru.dmitryvitutnev.day16_whosaidmeow

import android.annotation.TargetApi
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private var mSoundPool: SoundPool? = null
    private var mAssetManager: AssetManager? = null
    private var mCatSound = 0
    private var mChickenSound = 0
    private var mCowSound = 0
    private var mDogSound = 0
    private var mDuckSound = 0
    private var mSheepSound = 0
    private var mStreamID = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            // Для устройств до Android 5
//            createOldSoundPool();
//        } else {
//            // Для новых устройств
//            createNewSoundPool();
//        }

//        mAssetManager = getAssets();
//
//        // получим идентификаторы
//        mCatSound = loadSound("cat.ogg");
//        mChickenSound = loadSound("chicken.ogg");
//        mCowSound = loadSound("cow.ogg");
//        mDogSound = loadSound("dog.ogg");
//        mDuckSound = loadSound("duck.ogg");
//        mSheepSound = loadSound("sheep.ogg");
        imageButtonChicken.setOnClickListener {
            onClickListener(imageButtonChicken)
        }
        imageButtonCat.setOnClickListener {
            onClickListener(imageButtonCat)
        }
        imageButtonDuck.setOnClickListener {
            onClickListener(imageButtonDuck)
        }
        imageButtonSheep.setOnClickListener {
            onClickListener(imageButtonSheep)
        }
        imageButtonDog.setOnClickListener {
            onClickListener(imageButtonDog)
        }
        imageButtonCow.setOnClickListener {
            onClickListener(imageButtonCow)
        }

    }

    fun onClickListener(v: View) {
        when (v.id) {
            imageButtonCow.id -> playSound(mCowSound)
            imageButtonChicken.id -> playSound(mChickenSound)
            imageButtonCat.id -> playSound(mCatSound)
            imageButtonDuck.id -> playSound(mDuckSound)
            imageButtonSheep.id -> playSound(mSheepSound)
            imageButtonDog.id -> playSound(mDogSound)
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun createNewSoundPool() {
        val attributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        mSoundPool = SoundPool.Builder()
            .setAudioAttributes(attributes)
            .build()
    }

    private fun createOldSoundPool() {
        mSoundPool = SoundPool(3, AudioManager.STREAM_MUSIC, 0)
    }

    private fun playSound(sound: Int): Int {
        if (sound > 0) {
            mStreamID = mSoundPool!!.play(sound, 1f, 1f, 1, 0, 1f)
        }
        return mStreamID
    }

    private fun loadSound(fileName: String): Int {
        val afd: AssetFileDescriptor
        afd = try {
            mAssetManager!!.openFd(fileName)
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(
                applicationContext, "Не могу загрузить файл $fileName",
                Toast.LENGTH_SHORT
            ).show()
            return -1
        }
        return mSoundPool!!.load(afd, 1)
    }

    override fun onResume() {
        super.onResume()
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            // Для устройств до Android 5
            createOldSoundPool()
        } else {
            // Для новых устройств
            createNewSoundPool()
        }
        mAssetManager = assets

        // получим идентификаторы
        mCatSound = loadSound("cat.ogg")
        mChickenSound = loadSound("chicken.ogg")
        mCowSound = loadSound("cow.ogg")
        mDogSound = loadSound("dog.ogg")
        mDuckSound = loadSound("duck.ogg")
        mSheepSound = loadSound("sheep.ogg")
    }

    override fun onPause() {
        super.onPause()
        mSoundPool!!.release()
        mSoundPool = null
    }
}