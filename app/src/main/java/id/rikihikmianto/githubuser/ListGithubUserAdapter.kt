package id.rikihikmianto.githubuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        val (_, name, _, _, company, followers, following, avatar) = listGithub[position]
        holder.binding.tvName.text = name
        holder.binding.tvCompany.text = company
        holder.binding.tvFollowing.text = following
        holder.binding.tvFollowers.text = followers
        holder.binding.imgItemAvatar.setImageResource(avatar)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listGithub[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listGithub.size
    }
}