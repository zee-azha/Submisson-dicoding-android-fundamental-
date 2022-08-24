package com.example.submissiondicodingfundamentalandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submissiondicodingfundamentalandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val list = ArrayList<Users>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.rvUser.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        binding.apply {
            rvUser.layoutManager = LinearLayoutManager(this@MainActivity)
            val listUserAdapter = ListUserAdapter(list)
            rvUser.adapter = listUserAdapter
           listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {


               override fun onItemClicked(users: Users) {
                   val extra = Users(
                       users.avatar,
                       users.username,
                       users.name,
                       users.location,
                       users.company,
                       users.followers,
                       users.following,
                       users.repository,



                   )
                   val intentWithExtraData = Intent(this@MainActivity, DetailsActivity::class.java)
                   intentWithExtraData.putExtra(DetailsActivity.EXTRA_USER,extra)
                   startActivity(intentWithExtraData)
               }

           })
        }
    }

    private val listUser: ArrayList<Users>

        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val listUser = ArrayList<Users>()
            for (i in dataName.indices){
                val users = Users(dataAvatar.getResourceId(i,-1),dataUsername[i],dataName[i],dataLocation[i],dataCompany[i],dataFollowers[i],dataFollowing[i],dataRepository[i],)
                listUser.add(users)
            }
            return  listUser



        }
}