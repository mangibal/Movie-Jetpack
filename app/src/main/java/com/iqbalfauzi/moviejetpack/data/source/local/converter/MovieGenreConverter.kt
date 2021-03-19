package com.iqbalfauzi.moviejetpack.data.source.local.converter

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

/**
 * Created by Iqbal Fauzi on 3/9/21 11:58 AM
 * iqbal.fauzi.if99@gmail.com
 */
class MovieGenreConverter {
    private val moshi: Moshi = Moshi.Builder().build()
    private val type = Types.newParameterizedType(List::class.java, Int::class.javaObjectType)
    private val adapter: JsonAdapter<List<Int>> = moshi.adapter(type)

    @TypeConverter
    fun fromJson(values: String): List<Int>? {
        return adapter.fromJson(values)
    }

    @TypeConverter
    fun toJson(value: List<Int>): String {
        return adapter.toJson(value)
    }
}