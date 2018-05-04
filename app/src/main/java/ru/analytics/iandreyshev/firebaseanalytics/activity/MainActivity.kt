package ru.analytics.iandreyshev.firebaseanalytics.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.analytics.iandreyshev.firebaseanalytics.R
import ru.analytics.iandreyshev.firebaseanalytics.adapter.CourseRVAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = LinearLayoutManager(this)
        val viewAdapter = CourseRVAdapter().apply {
            onItemClick = { data ->
                Intent(this@MainActivity, LearnActivity::class.java).let {
                    startActivity(it)
                }
            }
        }

        rvCourseList.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
