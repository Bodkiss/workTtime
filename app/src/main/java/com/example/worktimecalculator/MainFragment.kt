package com.example.worktimecalculator

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.worktimecalculator.databinding.FragmentMainBinding
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds



class MainFragment : Fragment() {
    var startTime = System.currentTimeMillis()
    var stopTime = System.currentTimeMillis()
    var isStarted = false
    private lateinit var binding:FragmentMainBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        return view


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnStartWork.setOnClickListener {
                if(!isStarted){
               startTime()
                }
                else{
                    stopTime()
                }
            }




    }
    private fun currentTime():String{
        val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
        return sdf.format(Date())
    }
    private fun stopTime(){

        stopTime = System.currentTimeMillis()
        binding.twStoptwork.text = currentTime()
        val timeDiff = (stopTime-startTime)/1000
        val timeDiffMin = timeDiff/60
        binding.twtime.text = "Час роботи: $timeDiff сек, \n або $timeDiffMin хв"
        isStarted = false
        binding.btnStartWork.text = "Початок роботи"

    }
    private fun startTime(){

        startTime =  System.currentTimeMillis()
        binding.twStartwork.text = currentTime()
        isStarted = true
        binding.btnStartWork.text = "Кінець роботи"
        binding.twStoptwork.text = "Кінець роботи"
        binding.twtime.text = " "

    }




}