package id.rikihikmianto.githubuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.rikihikmianto.githubuser.databinding.ItemRowUserBinding
import java.util.*

class ListGithubUserAdapter(private val listGithub: ArrayList<GithubUser>) :
    RecyclerView.Adapter<ListGithubUserAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: GithubUser)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val dataUser = listGithub[position]
        holder.binding.tvName.text = dataUser.name
        holder.binding.tvCompany.text = dataUser.company
        holder.binding.tvFollowing.text = dataUser.following
        holder.binding.tvFollowers.text = dataUser.followers
        Glide.with(holder.itemView.context).load(dataUser.avatar)
            .apply(RequestOptions().override(100, 100)).circleCrop()
            .into(holder.binding.imgItemAvatar)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listGithub[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listGithub.size
    }
}

