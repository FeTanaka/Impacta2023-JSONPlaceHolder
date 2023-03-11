package br.com.impacta.curso.myapplication.ui.fragment.postcomments

import androidx.lifecycle.*
import br.com.impacta.curso.myapplication.data.local.BancoDeDados
import br.com.impacta.curso.myapplication.data.models.comment.Comment
import br.com.impacta.curso.myapplication.data.models.comment.CommentRepository
import br.com.impacta.curso.myapplication.data.remote.JSONEndpoints
import br.com.impacta.curso.myapplication.ui.fragment.listpost.ListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel(private val db: BancoDeDados, private val endpoints: JSONEndpoints): ViewModel() {

    private var _lista: MutableLiveData<List<Comment>> = MutableLiveData()
    val lista: LiveData<List<Comment>> = _lista

    private val commentRepo: CommentRepository = CommentRepository(db, endpoints)

    fun carregaList(postId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _lista.postValue(commentRepo.carregaComentarios(postId))
        }
    }
}

class PostViewModelFactory(private val db: BancoDeDados, private val endpoints: JSONEndpoints): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            return PostViewModel(db, endpoints) as T
        }
        throw java.lang.IllegalArgumentException()
    }
}