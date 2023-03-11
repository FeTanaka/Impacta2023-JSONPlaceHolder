package br.com.impacta.curso.myapplication.data.models.comment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CommentDao {

    @Insert
    suspend fun inserir(comment: Comment)

    @Insert
    suspend fun inserir(lista: List<Comment>)

    @Query("SELECT * FROM comment WHERE postId = :postId")
    suspend fun buscarPorPostId(postId: Int): List<Comment>

}