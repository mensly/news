package com.yourname.news.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.yourname.news.R
import com.yourname.news.ui.item.ItemFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireView().findViewById<RecyclerView>(R.id.list).adapter =
            NewsItemAdapter(viewLifecycleOwner, viewModel.items) {
                parentFragmentManager.commit {
                    replace(R.id.container, ItemFragment.newInstance(it.title))
                    addToBackStack(it.id)
                }
            }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().title = getString(R.string.app_name)
        viewModel.refresh()
    }
}
