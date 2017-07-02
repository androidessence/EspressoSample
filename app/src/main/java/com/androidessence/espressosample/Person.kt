package com.androidessence.espressosample

import android.os.Parcel
import android.os.Parcelable


data class Person(var firstName: String = "", var lastName: String = "", var age: Int = 0, var emailAddress: String = ""): Parcelable {
    val fullName: String
        get() = "$firstName $lastName"

    constructor(parcel: Parcel?): this() {
        firstName = parcel?.readString().orEmpty()
        lastName = parcel?.readString().orEmpty()
        age = parcel?.readInt() ?: 0
        emailAddress = parcel?.readString().orEmpty()
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(firstName)
        p0?.writeString(lastName)
        p0?.writeInt(age)
        p0?.writeString(emailAddress)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField val CREATOR = object : Parcelable.Creator<Person> {
            override fun createFromParcel(p0: Parcel?): Person {
                return Person(p0)
            }

            override fun newArray(p0: Int): Array<Person?> {
                return arrayOfNulls<Person?>(p0)
            }
        }
    }
}