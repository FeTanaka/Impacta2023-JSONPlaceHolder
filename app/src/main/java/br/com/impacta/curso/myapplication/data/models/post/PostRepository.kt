package br.com.impacta.curso.myapplication.data.models.post

import br.com.impacta.curso.myapplication.data.local.BancoDeDados
import br.com.impacta.curso.myapplication.data.models.post.Post
import br.com.impacta.curso.myapplication.data.remote.JSONEndpoints

class PostRepository(
    private val room: BancoDeDados,
    private val endpoins: JSONEndpoints
    ) {

    private val dao = room.getPostDao()

    suspend fun carregaPosts(): List<Post> {
        val listaPost = endpoins.getPosts()
        dao.inserir(listaPost)
        return dao.buscarTodos()
    }

    suspend fun recuperaPost(postId: Int): Post {
        return try {
            dao.buscarPorId(postId)
        } catch (e: java.lang.Exception) {
            val post = endpoins.getPost(postId)
            dao.inserir(post)
            dao.buscarPorId(postId)
        }
    }

}