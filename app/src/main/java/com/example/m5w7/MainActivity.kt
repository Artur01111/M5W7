package com.example.m5w7

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllCharacters()
    }

    private fun getAllCharacters() {
        RetrofitInstance.api.getAllCharacters().enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {
                if (response.isSuccessful) {
                    val characters = response.body()?.results
                    characters?.forEach { character ->
                        Log.d("Character", "Name: ${character.name}, Status: ${character.status}")
                    }
                } else {
                    Log.e("Error", "Response code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("Error", "Network request failed: ${t.message}")
            }
        })
    }
}