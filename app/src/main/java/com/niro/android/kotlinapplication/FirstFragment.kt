package com.niro.android.kotlinapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.niro.android.kotlinapplication.adapters.PhotoAdapter
import com.niro.android.kotlinapplication.api.UserAPIService
import com.niro.android.kotlinapplication.databinding.FragmentFirstBinding
import com.niro.android.kotlinapplication.model.Photo
import com.niro.android.kotlinapplication.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val userAPIService = UserAPIService.create()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.layoutManager = LinearLayoutManager(view.context)
        val photos = userAPIService.getPhotos()

        photos.enqueue(object :Callback<List<Photo>>{
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                val photosBody = response.body()
                val adapter = PhotoAdapter(photosBody!!)
                binding.recyclerview.adapter = adapter
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {

            }

        })

//        binding.buttonFirst.setOnClickListener {
//            val editText = binding.editTextId.editableText
//            val user = userAPIService.getUser(editText);
//
//            user.enqueue(object : Callback<User> {
//                override fun onResponse(call: Call<User>, response: Response<User>) {
//
//                    val body = response.body()
//                    body?.let {
//                        Log.i("FirstFragment Name:", it.name)
//                        binding.textviewUserName.text = it.name
//                        binding.textviewUserEmail.text = it.email
//                    }
//                }
//
//                override fun onFailure(call: Call<User>, t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//            })
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




