package at.ollmann.philipp.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import at.ollmann.philipp.recipeapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.text.Editable
import android.text.TextWatcher

import com.google.android.material.chip.ChipGroup
import com.google.android.material.chip.Chip




const val BASE_URL = "https://api.spoonacular.com/recipes/"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recylerviewUsers.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recylerviewUsers.layoutManager = linearLayoutManager

        binding.textfieldSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                getMyData(Diets.PALEO, s.toString())
            }
        })

        enumValues<Diets>().forEach {
            var diet = it
            val chip = layoutInflater.inflate(R.layout.custom_chip, binding.chipgroupDiets, false) as Chip
            chip.text = it.key
            chip.setOnClickListener{
                getMyData(diet)
            }
            binding.chipgroupDiets.addView(chip)
        }
        getMyData(Diets.PALEO)
    }

    private fun getMyData(diet: Diets, query: String? = null) {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData(diet.key, query)

        Log.d("MainActivity", "getMyData: called")

        retrofitData.enqueue(object : Callback<Recipes?> {
            override fun onResponse(call: Call<Recipes?>, response: Response<Recipes?>) {
                val responseBody = response.body()!!
                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                binding.recylerviewUsers.adapter = myAdapter
            }

            override fun onFailure(call: Call<Recipes?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}