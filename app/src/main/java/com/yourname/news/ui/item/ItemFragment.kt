package com.yourname.news.ui.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yourname.news.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemFragment : Fragment() {
    companion object {
        private const val ARG_TITLE = "title"
        fun newInstance(title: String) = ItemFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_TITLE, title)
            }
        }
    }

    private val viewModel: ItemViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.title = requireArguments().getString(ARG_TITLE)!!
    }

    override fun onResume() {
        super.onResume()
        requireActivity().title = viewModel.title
    }
}
