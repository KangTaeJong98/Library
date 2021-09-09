package com.taetae98.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.taetae98.library.database.AppDatabase
import com.taetae98.library.databinding.FragmentMainBinding
import com.taetae98.library.dto.TestDTO
import com.taetae98.modules.library.binding.BindingFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : BindingFragment<FragmentMainBinding>(R.layout.fragment_main) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)



        CoroutineScope(Dispatchers.IO).launch {
            val dao = AppDatabase.getInstance(requireContext()).dao()
            val dto = TestDTO(data = "Hi")

            dao.insert(dto)
            dao.update(dto.copy(data = "Hello"))
            dao.delete(dto)
        }

        return binding.root
    }
}