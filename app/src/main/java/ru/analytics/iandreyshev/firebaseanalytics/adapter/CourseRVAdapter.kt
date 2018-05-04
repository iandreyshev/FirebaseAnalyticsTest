package ru.analytics.iandreyshev.firebaseanalytics.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_course.view.*
import ru.analytics.iandreyshev.firebaseanalytics.R
import ru.analytics.iandreyshev.firebaseanalytics.data.CourseData

class CourseRVAdapter : RecyclerView.Adapter<CourseRVAdapter.Holder>() {

    companion object {
        private const val ITEMS_COUNT = 100
    }

    var onItemClick: (CourseData) -> Unit = {}

    private val mItems = List(ITEMS_COUNT, { CourseData(it.toLong()) })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_course, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int =
            mItems.count()

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = mItems[position]
        holder.data = data
        holder.itemView.setOnClickListener {
            onItemClick(data)
        }
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        var data: CourseData? = null
            set(value) {
                field = value
                itemView.tvTitle.text = field.toString()
            }
    }
}
