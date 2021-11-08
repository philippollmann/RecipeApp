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
import at.ollmann.philipp.recipeapp.models.Diets
import at.ollmann.philipp.recipeapp.models.Recipes
import com.google.android.material.chip.Chip

const val BASE_URL = "https://api.spoonacular.com/recipes/"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var myAdapter: RecipeRecyclerViewAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    private var currentDiet: Diets? = null
    private var currentSearchTerm: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityMainRecylerviewRecipes.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        binding.activityMainRecylerviewRecipes.layoutManager = linearLayoutManager

        binding.activityMainTextfieldSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                currentSearchTerm = s.toString()
                getMyData()
            }
        })

        enumValues<Diets>().forEach {
            var diet = it
            val chip = layoutInflater.inflate(R.layout.diet_chip, binding.chipgroupDiets, false) as Chip
            chip.text = it.key
            chip.setOnClickListener{
                currentDiet = diet
                getMyData()
            }
            binding.chipgroupDiets.addView(chip)
        }
        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData(currentDiet?.key, currentSearchTerm)
        retrofitData.enqueue(object : Callback<Recipes?> {
            override fun onResponse(call: Call<Recipes?>, response: Response<Recipes?>) {
                val responseBody = response.body()!!
                myAdapter = RecipeRecyclerViewAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                binding.activityMainRecylerviewRecipes.adapter = myAdapter
            }
            override fun onFailure(call: Call<Recipes?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}