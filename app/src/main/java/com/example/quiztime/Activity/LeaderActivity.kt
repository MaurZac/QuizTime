package com.example.quiztime.Activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.quiztime.Adapter.LeaderAdapter
import com.example.quiztime.Domain.UserModel
import com.example.quiztime.R
import com.example.quiztime.databinding.ActivityLeaderBinding

class LeaderActivity : AppCompatActivity() {

    lateinit var binding: ActivityLeaderBinding
    private val leaderAdapter by lazy { LeaderAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.apply {
            scoreText01.text = loadData().get(0).score.toString()
            scoreText11.text = loadData().get(1).score.toString()
            scoreText3.text = loadData().get(2).score.toString()
            titleTop.text = loadData().get(0).name
            titleTop2.text = loadData().get(1).name
            titleTop3.text = loadData().get(2).name

            val drawableResourceId: Int = binding.root.resources.getIdentifier(
                loadData().get(0).pic, "drawable", binding.root.context.packageName
            )
            val drawableResourceId1: Int = binding.root.resources.getIdentifier(
                loadData().get(1).pic, "drawable", binding.root.context.packageName
            )
            val drawableResourceId2: Int = binding.root.resources.getIdentifier(
                loadData().get(2).pic, "drawable", binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId)
                .into(pic1)
            Glide.with(root.context)
                .load(drawableResourceId1)
                .into(pic2)
            Glide.with(root.context)
                .load(drawableResourceId2)
                .into(pic3)

            bottomMenu.setItemSelected(R.id.Board)
            bottomMenu.setOnItemSelectedListener {
                if(it == R.id.home){
                    startActivity(Intent(this@LeaderActivity,MainActivity::class.java))
                }
            }

            var list: MutableList<UserModel> = loadData()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)
            leaderAdapter.differ.submitList(list)
            leaderView.apply {
                layoutManager = LinearLayoutManager(this@LeaderActivity)
                adapter = leaderAdapter
            }
        }

    }

    private fun loadData():MutableList<UserModel>{
        val users: MutableList<UserModel> = mutableListOf()
        users.add(UserModel(1,"Carmen", "person1", score = 4850))
        users.add(UserModel(1,"Jac", "person2", score = 4830))
        users.add(UserModel(1,"Trix", "person3", score = 4890))
        users.add(UserModel(1,"Mau", "person4", score = 4856))
        users.add(UserModel(1,"Appa", "person5", score = 4853))

        return users

    }
}