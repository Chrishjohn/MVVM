package com.example.room.data.model.seller

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



class SellerListResponse {
    @SerializedName("code")
    @Expose
    var code: String? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    class Datum {
        @SerializedName("product_id")
        @Expose
        var productId: String? = null

        @SerializedName("product_name")
        @Expose
        var productName: String? = null

        @SerializedName("seller_name")
        @Expose
        var sellerName: String? = null

        @SerializedName("category_name")
        @Expose
        var categoryName: String? = null

        @SerializedName("package_size")
        @Expose
        var packageSize: String? = null

        @SerializedName("available_quantity")
        @Expose
        var availableQuantity: String? = null

        @SerializedName("min_order_quantity")
        @Expose
        var minOrderQuantity: String? = null

        @SerializedName("regular_price")
        @Expose
        var regularPrice: String? = null

        @SerializedName("area")
        @Expose
        var area: String? = null

        @SerializedName("block")
        @Expose
        var block: String? = null

        @SerializedName("street")
        @Expose
        var street: String? = null

        @SerializedName("lane")
        @Expose
        var lane: String? = null

        @SerializedName("house_number")
        @Expose
        var houseNumber: String? = null

        @SerializedName("floor")
        @Expose
        var floor: String? = null

        @SerializedName("apartment_number")
        @Expose
        var apartmentNumber: String? = null

        @SerializedName("postal_code")
        @Expose
        var postalCode: String? = null

        @SerializedName("landmark")
        @Expose
        var landmark: String? = null

        @SerializedName("city")
        @Expose
        var city: String? = null

        @SerializedName("state")
        @Expose
        var state: String? = null

        @SerializedName("country")
        @Expose
        var country: String? = null

        @SerializedName("latitude")
        @Expose
        var latitude: String? = null

        @SerializedName("longitude")
        @Expose
        var longitude: String? = null

        @SerializedName("product_image")
        @Expose
        var productImage: String? = null

        @SerializedName("email")
        @Expose
        var email: String? = null

        @SerializedName("seller_id")
        @Expose
        var sellerId: String? = null

        @SerializedName("mobile")
        @Expose
        var mobile: String? = null

        @SerializedName("sku")
        @Expose
        var sku: String? = null

        @SerializedName("description")
        @Expose
        var description: String? = null

        @SerializedName("production_date")
        @Expose
        var productionDate: String? = null

        @SerializedName("expire_date")
        @Expose
        var expireDate: String? = null

        @SerializedName("delivery_option")
        @Expose
        var deliveryOption: String? = null

        @SerializedName("delivery_time")
        @Expose
        var deliveryTime: String? = null

        @SerializedName("delivery_note")
        @Expose
        var deliveryNote: String? = null

        @SerializedName("discount_quantity")
        @Expose
        var discountQuantity: String? = null

        @SerializedName("discount_price")
        @Expose
        var discountPrice: String? = null

        @SerializedName("days_pay_full")
        @Expose
        var daysPayFull: String? = null

        @SerializedName("payment_note")
        @Expose
        var paymentNote: String? = null

        @SerializedName("buyback_option")
        @Expose
        var buybackOption: String? = null

        @SerializedName("buyback_note")
        @Expose
        var buybackNote: String? = null

        @SerializedName("return_option")
        @Expose
        var returnOption: String? = null

        @SerializedName("return_note")
        @Expose
        var returnNote: String? = null

        @SerializedName("processing_fee")
        @Expose
        var processingFee: String? = null

        @SerializedName("product_image2")
        @Expose
        var productImage2: String? = null

        @SerializedName("product_image3")
        @Expose
        var productImage3: String? = null

        @SerializedName("product_image4")
        @Expose
        var productImage4: String? = null

        @SerializedName("product_image5")
        @Expose
        var productImage5: String? = null

        /**
         * No args constructor for use in serialization
         *
         */
        constructor() {}

        /**
         *
         * @param country
         * @param returnOption
         * @param deliveryTime
         * @param city
         * @param regularPrice
         * @param postalCode
         * @param latitude
         * @param sellerName
         * @param houseNumber
         * @param discountPrice
         * @param description
         * @param discountQuantity
         * @param packageSize
         * @param categoryName
         * @param productName
         * @param processingFee
         * @param productImage
         * @param sellerId
         * @param productionDate
         * @param street
         * @param block
         * @param expireDate
         * @param state
         * @param floor
         * @param landmark
         * @param sku
         * @param lane
         * @param email
         * @param longitude
         * @param area
         * @param availableQuantity
         * @param buybackNote
         * @param productId
         * @param deliveryNote
         * @param mobile
         * @param daysPayFull
         * @param productImage3
         * @param returnNote
         * @param productImage2
         * @param paymentNote
         * @param buybackOption
         * @param minOrderQuantity
         * @param productImage5
         * @param deliveryOption
         * @param productImage4
         * @param apartmentNumber
         */
        constructor(
            productId: String?,
            productName: String?,
            sellerName: String?,
            categoryName: String?,
            packageSize: String?,
            availableQuantity: String?,
            minOrderQuantity: String?,
            regularPrice: String?,
            area: String?,
            block: String?,
            street: String?,
            lane: String?,
            houseNumber: String?,
            floor: String?,
            apartmentNumber: String?,
            postalCode: String?,
            landmark: String?,
            city: String?,
            state: String?,
            country: String?,
            latitude: String?,
            longitude: String?,
            productImage: String?,
            email: String?,
            sellerId: String?,
            mobile: String?,
            sku: String?,
            description: String?,
            productionDate: String?,
            expireDate: String?,
            deliveryOption: String?,
            deliveryTime: String?,
            deliveryNote: String?,
            discountQuantity: String?,
            discountPrice: String?,
            daysPayFull: String?,
            paymentNote: String?,
            buybackOption: String?,
            buybackNote: String?,
            returnOption: String?,
            returnNote: String?,
            processingFee: String?,
            productImage2: String?,
            productImage3: String?,
            productImage4: String?,
            productImage5: String?
        ) : super() {
            this.productId = productId
            this.productName = productName
            this.sellerName = sellerName
            this.categoryName = categoryName
            this.packageSize = packageSize
            this.availableQuantity = availableQuantity
            this.minOrderQuantity = minOrderQuantity
            this.regularPrice = regularPrice
            this.area = area
            this.block = block
            this.street = street
            this.lane = lane
            this.houseNumber = houseNumber
            this.floor = floor
            this.apartmentNumber = apartmentNumber
            this.postalCode = postalCode
            this.landmark = landmark
            this.city = city
            this.state = state
            this.country = country
            this.latitude = latitude
            this.longitude = longitude
            this.productImage = productImage
            this.email = email
            this.sellerId = sellerId
            this.mobile = mobile
            this.sku = sku
            this.description = description
            this.productionDate = productionDate
            this.expireDate = expireDate
            this.deliveryOption = deliveryOption
            this.deliveryTime = deliveryTime
            this.deliveryNote = deliveryNote
            this.discountQuantity = discountQuantity
            this.discountPrice = discountPrice
            this.daysPayFull = daysPayFull
            this.paymentNote = paymentNote
            this.buybackOption = buybackOption
            this.buybackNote = buybackNote
            this.returnOption = returnOption
            this.returnNote = returnNote
            this.processingFee = processingFee
            this.productImage2 = productImage2
            this.productImage3 = productImage3
            this.productImage4 = productImage4
            this.productImage5 = productImage5
        }
    }
}

