package com.example.submissiondicodingfundamentalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submissiondicodingfundamentalandroid.databinding.ActivityDetailsBinding
import com.example.submissiondicodingfundamentalandroid.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<Users>(EXTRA_USER) as Users
        binding.apply {
            imgAvatar.setImageResource(user.avatar)
            tvName.text = user.name
            tvUsername.text = user.username
            tvCompany.text = user.company
            tvLocation.text = user.location
            followers.text = user.followers
            following.text = user.following
            repository.text = user.repository
        }
    }


    companion object{
        const val  EXTRA_USER = "extra_user"
    }
}