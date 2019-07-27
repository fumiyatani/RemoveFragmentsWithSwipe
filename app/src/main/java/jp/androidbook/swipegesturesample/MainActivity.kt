package jp.androidbook.swipegesturesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    private val fragmentList = ArrayList<Fragment>(0)
    private lateinit var adapter: SwipeDeleteViewPagerAdapter

    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = SwipeDeleteViewPagerAdapter(supportFragmentManager, fragmentList)

        swipeDeleteViewPager.adapter = adapter
        swipeDeleteViewPager.addOnPageChangeListener(this)

        fab.setOnClickListener {
            addFragment()
        }
    }

    private fun addFragment() {
        if (fragmentList.size % 2 == 0) {
            adapter.addFragment(Fragment2())
        } else {
            adapter.addFragment(Fragment1())
        }

        if (swipeDeleteViewPager.currentItem < fragmentList.size - 1)
        swipeDeleteViewPager.setCurrentItem(swipeDeleteViewPager.currentItem + 1, true)
    }

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        val pagePositionDeffer = position - currentPage
        if (pagePositionDeffer < 0) {
            adapter.deleteFragment(position + 1)
        }
        currentPage = position
    }
}
