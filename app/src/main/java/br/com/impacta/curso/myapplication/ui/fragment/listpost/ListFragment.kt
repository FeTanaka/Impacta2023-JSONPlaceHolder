package br.com.impacta.curso.myapplication.ui.fragment.listpost

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.impacta.curso.myapplication.R
import br.com.impacta.curso.myapplication.data.local.BancoDeDados
import br.com.impacta.curso.myapplication.data.remote.JSONEndpoints
import br.com.impacta.curso.myapplication.data.remote.MyRetrofit
import br.com.impacta.curso.myapplication.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListViewModel by viewModels {
        ListViewModelFactory(
            BancoDeDados.getInstancia(requireContext()),
            MyRetrofit
                .getInstance("https://jsonplaceholder.typicode.com/")
                .create(JSONEndpoints::class.java)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.lista.observe(viewLifecycleOwner) { lista ->
            binding.rv.adapter = PostAdapter(lista) { id ->
                findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToCommentFragment(id)
                )
            }
            binding.rv.layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.carregaLista()
    }
}