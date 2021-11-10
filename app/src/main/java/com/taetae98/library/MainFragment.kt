package com.taetae98.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.taetae98.library.adapter.TestDTOAdapter
import com.taetae98.library.database.AppDatabase
import com.taetae98.library.databinding.FragmentMainBinding
import com.taetae98.library.dto.TestDTO
import com.taetae98.modules.library.binding.BindingFragment
import com.taetae98.modules.library.util.SimpleSelectionTracker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : BindingFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val appDatabase by lazy { AppDatabase.getInstance(requireContext()) }
    private val testDTOAdapter by lazy { TestDTOAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appDatabase.dao().findAllLiveData().observe(viewLifecycleOwner) {
            testDTOAdapter.submitList(it)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        onCreateRecyclerView()
        
        return binding.root
    }

    private fun onCreateRecyclerView() {
        with(binding.recyclerView) {
            adapter = testDTOAdapter
        }

        testDTOAdapter.selectionTracker = SimpleSelectionTracker(binding.recyclerView)
    }

    override fun onBindingCreated() {
        super.onBindingCreated()
        binding.setOnAdd {
            CoroutineScope(Dispatchers.IO).launch {
                val index = testDTOAdapter.itemCount
                val arrayList = ArrayList<TestDTO>()
                repeat(5) {
                    arrayList.add(
                        TestDTO(
                            data = "Data : ${index + it}"
                        )
                    )
                }

                appDatabase.dao().insert(arrayList)
            }
        }

        binding.setOnRemove {
            CoroutineScope(Dispatchers.IO).launch {
                appDatabase.dao().delete(testDTOAdapter.currentList)
            }
        }
    }
}