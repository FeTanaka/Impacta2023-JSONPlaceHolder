package br.com.impacta.curso.myapplication.ui.fragment.listpost

import androidx.lifecycle.*
import br.com.impacta.curso.myapplication.data.local.BancoDeDados
import br.com.impacta.curso.myapplication.data.models.post.Post
import br.com.impacta.curso.myapplication.data.models.post.PostRepository
import br.com.impacta.curso.myapplication.data.remote.JSONEndpoints
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(private val db: BancoDeDados, private val endpoints: JSONEndpoints): ViewModel() {

    private var _lista: MutableLiveData<List<Post>> = MutableLiveData()
    val lista: LiveData<List<Post>> = _lista

    private val postRepo: PostRepository = PostRepository(db, endpoints)

    fun carregaLista() {
        viewModelScope.launch(Dispatchers.IO) {
            _lista.postValue(postRepo.carregaPosts())
        }
    }
}

class ListViewModelFactory(private val db: BancoDeDados, private val endpoints: JSONEndpoints): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(db, endpoints) as T
        }
        throw java.lang.IllegalArgumentException()
    }
}