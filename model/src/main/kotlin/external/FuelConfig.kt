package external

import fuel.FuelBuilder
import okhttp3.OkHttpClient

class FuelConfig {
    fun getFuelClient() = FuelBuilder()
        .config(OkHttpClient())
        .build()
}