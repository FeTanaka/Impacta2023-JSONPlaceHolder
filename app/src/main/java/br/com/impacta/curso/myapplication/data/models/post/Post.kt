package br.com.impacta.curso.myapplication.data.models.post

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    @PrimaryKey
    val id: Int,
    val body: String,
    val title: String,
    val userId: Int
) {
    fun getIdString() = this.id.toString()
    fun getUserIdString() = this.userId.toString()
}