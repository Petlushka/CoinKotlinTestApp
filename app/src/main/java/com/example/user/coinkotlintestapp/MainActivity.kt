package com.example.user.coinkotlintestapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.user.coinkotlintestapp.network.MealsResponse
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

open class MainActivity : AppCompatActivity(), View.OnClickListener {

    val presenter: MainPresenter by inject { parametersOf(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        update_button.setOnClickListener(this)

    }

    fun showData(result: MealsResponse) {
        text.text =result.meals.get(0).strMeal
    }

    override fun onClick(p0: View?) {
        presenter.getData()
    }

}
