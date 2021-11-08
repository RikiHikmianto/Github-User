package id.rikihikmianto.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.rikihikmianto.githubuser.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail User"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val githubUser: GithubUser = intent.getParcelableExtra<GithubUser>(EXTRA_DATA) as GithubUser
        binding.tvFollowers.text = githubUser.followers
        binding.tvFollowing.text = githubUser.following
        binding.tvRepo.text = githubUser.repository
        binding.tvName.text = githubUser.name
        binding.tvUsername.text = githubUser.username
        binding.tvCompany.text = githubUser.company
        binding.tvLocation.text = githubUser.location
        binding.imgAvatar.setImageResource(githubUser.avatar)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}