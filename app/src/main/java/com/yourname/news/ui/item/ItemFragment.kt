package com.yourname.news.ui.item

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yourname.news.databinding.ItemFragmentBinding
import com.yourname.news.model.NewsItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemFragment : Fragment() {
    companion object {
        private const val ARG_ITEM = "item"
        fun newInstance(item: NewsItem) = ItemFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_ITEM, item)
            }
        }
    }

    private val viewModel: ItemViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val vm = viewModel
        return ItemFragmentBinding.inflate(inflater).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = vm
            btnOpen.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(vm.item.value?.link)))
            }
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.item.value = requireArguments().getParcelable(ARG_ITEM)
    }

    override fun onResume() {
        super.onResume()
        requireActivity().title = viewModel.item.value?.title
    }
}
