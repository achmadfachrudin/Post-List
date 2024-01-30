package com.achmad.baseandroid.core.extension

fun Int?.orZero(): Int {
    return this ?: 0
}

fun Long?.orZero(): Long {
    return this ?: 0
}

fun Double?.orZero(): Double {
    return this ?: 0.0
}

fun Int.formatWithCommas(): String {
    return String.format("%,d", this)
}
