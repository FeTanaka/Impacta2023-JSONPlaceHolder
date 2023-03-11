package br.com.impacta.curso.myapplication.data.models.comment

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Comment(
    @PrimaryKey
    val id: Int,
    val body: String,
    val email: String,
    val name: String,
    val postId: Int
) {
    fun getIdString() = this.id.toString()
    fun getPostIdString() = this.postId.toString()
}