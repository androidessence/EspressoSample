package com.androidessence.espressosample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class PersonAdapter(private var people: MutableList<Person> = ArrayList()) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    fun addPerson(person: Person) {
        people.add(person)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PersonViewHolder {
        val context = parent?.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return people.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder?, position: Int) {
        val person = people[position]
        holder?.bindPerson(person)
    }

    class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView = view as TextView

        fun bindPerson(person: Person) {
            textView.text = person.fullName
        }
    }
}