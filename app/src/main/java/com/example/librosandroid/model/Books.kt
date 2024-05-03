package com.example.librosandroid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * @param stringResourceId parametro que pasa el nombre del libro
 * @param stringAutorId parametro que pasa el auntor del libro
 * @param stringYearId parametro que pasa el año de publicación del libro
 * @param imageResourceId imagen del libro
 */
data class Books(
    @StringRes val stringResourceId: Int,
    @StringRes val stringAutorId: Int,
    @StringRes val stringYearId: Int,
    @DrawableRes val imageResourceId: Int
)
