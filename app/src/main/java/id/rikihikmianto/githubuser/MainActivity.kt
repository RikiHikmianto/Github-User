package id.rikihikmianto.githubuser

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.rikihikmianto.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<GithubUser>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvGithub.setHasFixedSize(true)

        list.addAll(listGithubUser)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        if (application.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvGithub.layoutManager = GridLayoutManager(this, 2)
        } else {
            binding.rvGithub.layoutManager = LinearLayoutManager(this)
        }
        val listGithubUserAdapter = ListGithubUserAdapter(list)
        binding.rvGithub.adapter = listGithubUserAdapter
        listGithubUserAdapter.setOnItemClickCallback(object :
            ListGithubUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: GithubUser) {
                showSelectedGithub(data)
            }
        })
    }

    private fun showSelectedGithub(data: GithubUser) {
        intent = Intent(this@MainActivity, DetailUser::class.java)
        intent.putExtra(DetailUser.EXTRA_DATA, data)
        startActivity(intent)
    }

    private val listGithubUser: ArrayList<GithubUser>
        get() {
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val listGithubUser = ArrayList<GithubUser>()

            for (i in dataName.indices) {
                val githubUser = GithubUser(
                    dataUsername[i],
                    dataName[i],
                    dataLocation[i],
                    dataRepository[i],
                    dataCompany[i],
                    dataFollowers[i],
                    dataFollowing[i],
                    dataAvatar.getResourceId(i, -1)
                )
                listGithubUser.add(githubUser)
            }
            return listGithubUser
        }
}