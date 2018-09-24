package com.example.axel.geoguess



class GeoObject internal constructor(private var isEurope: Boolean?, private var mGeoImageName: Int) {

    fun getisEurope(): Boolean? {

        return isEurope

    }

    fun setisEurope(isEurope: Boolean) {

        this.isEurope = isEurope

    }

    fun getmGeoImageName(): Int {

        return mGeoImageName

    }

    fun setmGeoImageName(mGeoImageName: Int) {

        this.mGeoImageName = mGeoImageName

    }

    companion object {

       val isInEurope = arrayOf(
                true,
                false,
                false,
                true,
                false,
                true,
                true,
                false
               )

        val GeoImageList = intArrayOf(
                R.drawable.img1_yes_denmark,
                R.drawable.img2_no_canada,
                R.drawable.img3_no_bangladesh,
                R.drawable.img4_yes_kazachstan,
                R.drawable.img5_no_colombia,
                R.drawable.img6_yes_poland,
                R.drawable.img7_yes_malta,
                R.drawable.img8_no_thailand
               )
    }
}