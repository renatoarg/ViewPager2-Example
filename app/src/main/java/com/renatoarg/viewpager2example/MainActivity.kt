package com.renatoarg.viewpager2example

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2


class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.mVp)
        setUpPagerAdapter()
    }

    /**
     * set up adapter same like you do for RecyclerView or other components
     */
    private fun setUpPagerAdapter() {
        val pagerAdapter =
            PagerAdapter(fetchDummyData()!!)
        viewPager2.adapter = pagerAdapter
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    /**
     *
     * @return this method will return dummy data in form of list
     */
    private fun fetchDummyData(): List<PagerM>? {
        val pagerMList: MutableList<PagerM> = ArrayList()
        val dummyArr = resources.getStringArray(R.array.string_array_name)
        val dummyImgArr = resources.getStringArray(R.array.string_array_image)

        for (i in 0..2) {
            val pagerM = PagerM()
            val resourceId = this.resources.getIdentifier(dummyImgArr[i], "drawable", this.packageName)
            pagerM.pagerDescription = dummyArr[i]
            pagerM.image = BitmapFactory.decodeResource(resources, resourceId)
            pagerMList.add(pagerM)
        }
        return pagerMList
    }
}
