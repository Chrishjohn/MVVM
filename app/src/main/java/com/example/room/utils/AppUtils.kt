package com.example.room.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import com.example.room.Application
import com.example.room.R
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

object AppUtils {
    private const val APP_TAG = "CliniBook"

    fun logString(message: String?): Int {
        return Log.i(APP_TAG, message!!)
    }

    fun isEmailValid(email: String?): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun isZipCodeValid(zipCode: String?): Boolean {
        val expression = "[0-9]{5}(?:-[0-9]{4})?\$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(zipCode)
        return matcher.matches()
    }

    fun isNameValid(name: String?): Boolean {
        val expression = "^[a-zA-Z]+\$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(name)
        return matcher.matches()
    }

    fun getRequestBody(value: String?): RequestBody? {
        return value!!.toRequestBody("multipart/form-data".toMediaTypeOrNull())
    }

    @JvmStatic
    fun isValidPassword(password: String?): Boolean {
        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
        val pattern = Pattern.compile(PASSWORD_PATTERN)
        val matcher = pattern.matcher(password)
        return matcher.matches()
    }

    fun hasInternetConnection(application: android.app.Application): Boolean {
        val connectivityManager = application.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val capabilities =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            return when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.activeNetworkInfo?.run {
                return when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return false
    }

    fun getErrorMessage(responseBody: ResponseBody): String? {
        var string = ""
        try {
            val jsonObject = JSONObject(responseBody.string())
            if (jsonObject.getJSONObject("Data") != null) {

            } else {
                jsonObject.getString("message")
            }
        } catch (e: Exception) {
            string = e.message.toString()
        }
        return string
    }
    fun isPhoneValid(phone: String?): Boolean {
        val expression = "^+(?:[0-9] ?){7,9}[0-9]\$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(phone)
        return matcher.matches()
    }


    @JvmStatic
    fun getText(textView: TextView): String {
        return textView.text.toString().trim { it <= ' ' }
    }

    fun showToast(context: Context?, message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    @JvmStatic
    fun startFromRightToLeft(context: Context) {
        (context as Activity).overridePendingTransition(R.anim.trans_left_in, R.anim.no_animation)
    }

    @JvmStatic
    fun finishFromLeftToRight(context: Context) {
        (context as Activity).overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
    }


    @JvmStatic
    fun startFromBottomToUp(context: Context) {
        (context as Activity).overridePendingTransition(
                R.anim.slide_in_bottom,
                R.anim.slide_out_bottom
        )
    }

    @JvmStatic
    fun startFromUpToBottom(context: Context) {
        (context as Activity).overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_top)
    }


    @SuppressLint("HardwareIds")
    fun getDeviceId(context: Context): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

  /*  *//*   public static RequestBody getRequestBody(String value) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), value);
    }*/
    @JvmStatic
    fun hideSoftKeyboard(activity: Activity) {
        val focusedView = activity.currentFocus
        if (focusedView != null) {
            val inputMethodManager =
                activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(focusedView.windowToken, 0)
        }
    }

    // Check EditText or String is Empty or null etc.
    fun isEmpty(str: String?): Boolean {
        return TextUtils.isEmpty(str)
    }


    fun showAlertDialog(context: Context, title: String?, message: String?) {
        val builder = AlertDialog.Builder(context)
        builder.setCancelable(false)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(context.getString(R.string.ok)) { dialog, which -> dialog.dismiss() }
        builder.show()
    }

    @JvmStatic
    fun roundTwoDecimals(d: Double): Double {
        val twoDForm = DecimalFormat("#.##")
        return java.lang.Double.valueOf(twoDForm.format(d))
    }

    @JvmStatic
    fun isMyServiceRunning(serviceClass: Class<*>, context: Context): Boolean {
        val manager = (context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager)
        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
        return false
    }

    fun capitalize(capString: String): String? {
        val capBuffer = StringBuffer()
        val capMatcher: Matcher =
            Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(capString)
        while (capMatcher.find()) {
            capMatcher.appendReplacement(
                    capBuffer,
                    capMatcher.group(1).toUpperCase() + capMatcher.group(2).toLowerCase()
            )
        }
        return capMatcher.appendTail(capBuffer).toString()
    }

    @JvmStatic
    fun dateChange(time: String): String? {
        val inputPattern = "yyyy-MM-dd HH:mm"
        val outputPattern = "HH:mm"
        val inputFormat = SimpleDateFormat(inputPattern)
        val outputFormat = SimpleDateFormat(outputPattern)
        var date: Date? = null
        var str: String? = null
        try {
            date = inputFormat.parse(time)
            str = outputFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return str
    }
    @JvmStatic
    fun isConnectedToInternet(context: Context?): Boolean {
        val cm = Application.application?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var netInfo: NetworkInfo? = null
        if (cm != null) {
            netInfo = cm.activeNetworkInfo
        }
        return netInfo != null && netInfo.isConnected && netInfo.isAvailable
    }


    fun convertTime(time: String): String {
        val _24HourSDF = SimpleDateFormat("HH:mm"  , Locale.US)
        val _12HourSDF = SimpleDateFormat("hh:mm a", Locale.US)
        var _12HourDt: Date? = null
        try {
            _12HourDt = _12HourSDF.parse(time)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return _24HourSDF.format(_12HourDt)
    }

}