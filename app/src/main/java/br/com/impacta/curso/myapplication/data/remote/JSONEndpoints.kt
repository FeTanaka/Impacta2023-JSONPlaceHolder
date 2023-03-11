package br.com.impacta.curso.myapplication.data.remote

import br.com.impacta.curso.myapplication.data.models.comment.Comment
import br.com.impacta.curso.myapplication.data.models.post.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface JSONEndpoints {

    @GET("/posts")
    suspend fun getPosts(): List<Post>

    @GET("/posts/{postId}")
    suspend fun getPost(@Path("postId") postId: Int): Post

    @GET("/posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId: Int): List<Comment>
}