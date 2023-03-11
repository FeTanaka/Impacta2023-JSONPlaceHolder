package br.com.impacta.curso.myapplication.ui.fragment.listpost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.impacta.curso.myapplication.data.models.post.Post
import br.com.impacta.curso.myapplication.databinding.PostRvItemBinding

class PostAdapter(private val lista: List<Post>, private val acao: (Int) -> Unit): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(val binding: PostRvItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (post: Post) {
            binding.post = post
            binding.root.setOnClickListener {
                acao(post.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PostRvItemBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(lista[position])
    }
}