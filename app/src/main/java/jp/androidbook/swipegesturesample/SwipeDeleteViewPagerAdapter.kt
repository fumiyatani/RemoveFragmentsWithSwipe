package jp.androidbook.swipegesturesample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

class SwipeDeleteViewPagerAdapter(fragmentManager: FragmentManager, private var fragmentList: ArrayList<Fragment>): FragmentStatePagerAdapter(fragmentManager) {


    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItemPosition(`object`: Any): Int {
        val target = `object` as Fragment
        return if (target in fragmentList) {
            PagerAdapter.POSITION_UNCHANGED
        } else {
            PagerAdapter.POSITION_NONE
        }
    }

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
        notifyDataSetChanged()
    }

    fun deleteFragment(deleteIndex: Int) {
        fragmentList.removeAt(deleteIndex)
        notifyDataSetChanged()
    }
}