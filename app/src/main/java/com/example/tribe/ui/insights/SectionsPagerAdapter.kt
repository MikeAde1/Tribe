package com.example.tribe.ui.insights

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return when(position) {
            0 -> {
                BusinessFragment.newInstance(position + 1)
            }
            1 -> {
                BusinessFragment.newInstance(position + 1)
            }
            2 -> {
                BusinessFragment.newInstance(position + 1)
            }
            else -> BusinessFragment.newInstance(position + 1)
        }

    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Trending Topics"
            }
            1 -> {
                return "Business News"
            }
            2 -> {
                return "Personal Finance"
            }
        }
        return super.getPageTitle(position)
    }
}
