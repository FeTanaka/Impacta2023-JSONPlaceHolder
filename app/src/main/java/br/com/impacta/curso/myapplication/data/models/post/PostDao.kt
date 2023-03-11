package br.com.impacta.curso.myapplication.data.models.post

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostDao {

    @Insert
    suspend fun inserir(post: Post)

    @Insert
    suspend fun inserir(lista: List<Post>)

    @Query("SELECT * FROM post WHERE id = :postId")
    suspend fun buscarPorId(postId: Int): Post

    @Query("SELECT * FROM post")
    suspend fun buscarTodos(): List<Post>

}