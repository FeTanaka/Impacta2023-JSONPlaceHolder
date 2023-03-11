package br.com.impacta.curso.myapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.impacta.curso.myapplication.data.models.comment.Comment
import br.com.impacta.curso.myapplication.data.models.comment.CommentDao
import br.com.impacta.curso.myapplication.data.models.post.Post
import br.com.impacta.curso.myapplication.data.models.post.PostDao

@Database(entities = [Post::class, Comment::class], version = 1)
abstract class BancoDeDados: RoomDatabase() {

    abstract fun getPostDao(): PostDao
    abstract fun getCommentDao(): CommentDao

    companion object {
        @Volatile
        private var INSTANCIA: BancoDeDados? = null

        fun getInstancia(context: Context): BancoDeDados {
            return INSTANCIA ?: synchronized(this) {
                var instancia = Room.databaseBuilder(
                    context.applicationContext,
                    BancoDeDados::class.java,
                    "bancoDeDados.sqlite"
                ).build()
                INSTANCIA = instancia
                instancia
            }
        }
    }

}