package com.example.noida1

import android.app.Application

class GlobalActivity : Application() {
    companion object {
        @JvmField
        var homeAPIResponse: String = "This_is_global_variable"
        var check_session:String= "false"
    }

}