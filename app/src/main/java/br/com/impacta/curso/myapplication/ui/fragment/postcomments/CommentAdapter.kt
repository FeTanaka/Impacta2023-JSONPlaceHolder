package br.com.impacta.curso.myapplication.ui.fragment.postcomments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.impacta.curso.myapplication.data.models.comment.Comment
import br.com.impacta.curso.myapplication.databinding.CommentRvItemBinding

class CommentAdapter(private val lista: List<Comment>): RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    inner class CommentViewHolder(val binding: CommentRvItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(comment:Comment) {
            binding.comment = comment
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CommentRvItemBinding.inflate(inflater, parent, false)
        return CommentViewHolder(binding)
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(lista[position])
    }

}