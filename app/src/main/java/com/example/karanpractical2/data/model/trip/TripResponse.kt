package com.example.karanpractical2.data.model.trip

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class TripResponse {
    @SerializedName("Message")
    @Expose
    var message: String? = null

    @SerializedName("TripList")
    @Expose
    var tripList: List<Trip>? = null
    class Trip {
        @SerializedName("DriverID")
        @Expose
        var driverID = 0

        @SerializedName("DriverMobileNo")
        @Expose
        var driverMobileNo: String? = null

        @SerializedName("DriverName")
        @Expose
        var driverName: String? = null

        @SerializedName("DriverPic")
        @Expose
        var driverPic: String? = null

        @SerializedName("FromLocation")
        @Expose
        var fromLocation: String? = null

        @SerializedName("ID")
        @Expose
        var id = 0

        @SerializedName("IsAccepted")
        @Expose
        var isAccepted = 0

        @SerializedName("LuggageType")
        @Expose
        var luggageType: String? = null

        @SerializedName("PickupContactName")
        @Expose
        var pickupContactName: String? = null

        @SerializedName("PickupContactNo")
        @Expose
        var pickupContactNo: String? = null

        @SerializedName("PickupNotes")
        @Expose
        var pickupNotes: String? = null

        @SerializedName("ReceiverContactName")
        @Expose
        var receiverContactName: String? = null

        @SerializedName("ReceiverContactNo")
        @Expose
        var receiverContactNo: String? = null

        @SerializedName("ReceiverNotes")
        @Expose
        var receiverNotes: String? = null

        @SerializedName("RejectReason")
        @Expose
        var rejectReason: String? = null

        @SerializedName("ToLocation")
        @Expose
        var toLocation: String? = null

        @SerializedName("TripPhotos")
        @Expose
        var tripPhotos: Any? = null

        @SerializedName("TripStartDate")
        @Expose
        var tripStartDate: String? = null

        @SerializedName("TripStartTime")
        @Expose
        var tripStartTime: String? = null

        @SerializedName("TripStatus")
        @Expose
        var tripStatus: String? = null

        @SerializedName("UserID")
        @Expose
        var userID = 0

        @SerializedName("UserMobileNo")
        @Expose
        var userMobileNo: String? = null

        @SerializedName("UserName")
        @Expose
        var userName: String? = null

        @SerializedName("UserPic")
        @Expose
        var userPic: String? = null

        @SerializedName("UserRating")
        @Expose
        var userRating = 0

        @SerializedName("UserRatingComment")
        @Expose
        var userRatingComment: String? = null

        @SerializedName("Vehicle")
        @Expose
        var vehicle: String? = null

        @SerializedName("VehicleBrand")
        @Expose
        var vehicleBrand: String? = null

        @SerializedName("VehicleNumber")
        @Expose
        var vehicleNumber: String? = null

        @SerializedName("Weight")
        @Expose
        var weight: String? = null

    }

}

