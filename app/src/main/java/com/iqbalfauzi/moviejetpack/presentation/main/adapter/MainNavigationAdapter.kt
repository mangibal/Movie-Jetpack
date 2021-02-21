package com.iqbalfauzi.moviejetpack.presentation.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.iqbalfauzi.moviejetpack.presentation.home.view.HomeFragment
import com.iqbalfauzi.moviejetpack.presentation.profile.ProfileFragment
import com.iqbalfauzi.moviejetpack.presentation.saved.SavedFragment

/**
 * Created by Iqbal Fauzi on 21/02/21 11.37
 * iqbal.fauzi.if99@gmail.com
 */
class MainNavigationAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private val fragments = listOf(HomeFragment(), SavedFragment(), ProfileFragment())

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}