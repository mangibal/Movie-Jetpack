package com.iqbalfauzi.moviejetpack.external.extensions

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import coil.transform.RoundedCornersTransformation
import com.iqbalfauzi.moviejetpack.R

/**
 * Created by Iqbal Fauzi on 2/22/21 9:51 AM
 * iqbal.fauzi.if99@gmail.com
 */
//PlaceholderType
enum class PlaceholderType {
    CUSTOM,
    LIGHT,
    DARK
}

// Coil Image Loader
fun ImageView.coil(
    imageUrl: String?,
    placeholderType: PlaceholderType = PlaceholderType.DARK,
    placeholder: Int = 0,
    cornerRadius: Float = 0f
) {
    this.load(imageUrl) {
        transformations(RoundedCornersTransformation(cornerRadius))
        crossfade(true)
        when (placeholderType) {
            PlaceholderType.CUSTOM -> placeholder(placeholder)
            PlaceholderType.LIGHT -> placeholder(createCircularProgressDrawableLight(context))
            PlaceholderType.DARK -> placeholder(createCircularProgressDrawable(context))
        }
        error(R.drawable.ic_broken_image)
    }
}

fun ImageView.coil(
    imageBitmap: Bitmap?,
    placeholderType: PlaceholderType = PlaceholderType.DARK,
    placeholder: Int = 0
) {
    this.load(imageBitmap) {
        crossfade(true)
        when (placeholderType) {
            PlaceholderType.CUSTOM -> placeholder(placeholder)
            PlaceholderType.LIGHT -> placeholder(createCircularProgressDrawableLight(context))
            PlaceholderType.DARK -> placeholder(createCircularProgressDrawable(context))
        }
        error(R.drawable.ic_broken_image)
    }
}

fun ImageView.coil(
    imageId: Int,
    placeholderType: PlaceholderType = PlaceholderType.DARK,
    placeholder: Int = 0
) {
    this.load(imageId) {
        crossfade(true)
        when (placeholderType) {
            PlaceholderType.CUSTOM -> placeholder(placeholder)
            PlaceholderType.LIGHT -> placeholder(createCircularProgressDrawableLight(context))
            PlaceholderType.DARK -> placeholder(createCircularProgressDrawable(context))
        }
        error(R.drawable.ic_broken_image)
    }
}

fun createCircularProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).also {
        it.apply {
            setColorSchemeColors(context.getColorCompat(R.color.purple_500))
            strokeWidth = 8f
            centerRadius = 44f
            start()
        }
    }
}

fun createCircularProgressDrawableLight(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).also {
        it.apply {
            setColorSchemeColors(Color.WHITE)
            strokeWidth = 8f
            centerRadius = 44f
            start()
        }
    }
}