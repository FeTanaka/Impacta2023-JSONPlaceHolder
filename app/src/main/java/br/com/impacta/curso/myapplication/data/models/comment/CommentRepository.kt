package br.com.impacta.curso.myapplication.data.models.comment

import br.com.impacta.curso.myapplication.data.local.BancoDeDados
import br.com.impacta.curso.myapplication.data.remote.JSONEndpoints

class CommentRepository(
    private val room: BancoDeDados,
    private val endpoins: JSONEndpoints
) {

    val dao = room.getCommentDao()

    suspend fun carregaComentarios(postId: Int): List<Comment> {
        var listaComentarios: List<Comment> = listOf()
        try {
            listaComentarios = endpoins.getComments(postId)
            dao.inserir(listaComentarios)
            listaComentarios = dao.buscarPorPostId(postId)
        } catch (e: java.lang.Exception) {
            listaComentarios = endpoins.getComments(postId)
            dao.inserir(listaComentarios)
        }
        return listaComentarios
    }

}